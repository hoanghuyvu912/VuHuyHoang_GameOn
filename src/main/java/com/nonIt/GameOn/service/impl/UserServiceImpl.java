package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.entity.Role;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.entity.UserRoleAssignment;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.service.UserService;
import com.nonIt.GameOn.service.dto.UserDto;
import com.nonIt.GameOn.service.mapper.UserMapper;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserRestDto> getAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserRestDto findById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(GameOnException::UserNotFound);
        return userMapper.toDto(user);
    }

    @Override
    public UserRestDto createUser(UserDto userDto) {
        Period age = Period.between(userDto.getDob(), LocalDate.now());
        int years = age.getYears();

        if (userDto.getFirstName() == null || userDto.getFirstName().trim().isBlank() || userDto.getFirstName().isEmpty()) {
            throw GameOnException.badRequest("FirstNameNotFound", "First name is missing");
        }
        if (userDto.getLastName() == null || userDto.getLastName().trim().isBlank() || userDto.getLastName().isEmpty()) {
            throw GameOnException.badRequest("LastNameNotFound", "Last name is missing");
        }
        if (userDto.getPassword() == null || userDto.getPassword().trim().isBlank() || userDto.getPassword().isEmpty()) {
            throw GameOnException.badRequest("PasswordNotFound", "Password is missing");
        }
        if (userDto.getEmail() == null || userDto.getEmail().trim().isBlank() || userDto.getEmail().isEmpty()) {
            throw GameOnException.badRequest("EmailNotFound", "Email is missing");
        }
        if (userDto.getTel() == null || userDto.getTel().trim().isBlank() || userDto.getTel().isEmpty()) {
            throw GameOnException.badRequest("TelephoneNumberNotFound", "Telephone number is missing");
        }
        if (userDto.getAddress() == null || userDto.getAddress().trim().isBlank() || userDto.getAddress().isEmpty()) {
            throw GameOnException.badRequest("AddressNotFound", "Address is missing");
        }
        if (years < 18) {
            throw GameOnException.badRequest("IllegalAge", "User must be 18-year-old.");
        }
        if (userDto.getGender() != Gender.Female && userDto.getGender() != Gender.Male) {
            throw GameOnException.badRequest("InvalidGender", "Gender must be MALE or FEMALE.");
        }
//        if (userDto.getProfileImg() == null || userDto.getProfileImg().trim().isBlank() || userDto.getProfileImg().isEmpty()) {
//            throw GameOnException.badRequest("ProfileImageNotFound", "Profile image is missing");
//        }
        if (userDto.getBalance() < 0) {
            throw GameOnException.badRequest("InvalidBalance", "Balance must be a positive number");
        }

        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .tel(userDto.getTel())
                .address(userDto.getAddress())
                .dob(userDto.getDob())
                .gender(userDto.getGender())
                .profileImg(userDto.getProfileImg())
                .balance(userDto.getBalance())
                .active(userDto.isActive())
                .build();

        List<UserRoleAssignment> tempList = new ArrayList<>();


        if (userDto.getRoles().size() == 0) {
            UserRoleAssignment role = new UserRoleAssignment();
            role.setRole(Role.ROLE_USER);
            role.setUsers(user);
            tempList.add(role);
        } else {
            for (int i = 0; i < userDto.getRoles().size(); i++) {
                UserRoleAssignment role = new UserRoleAssignment();
                role.setRole(userDto.getRoles().get(i));
                role.setUsers(user);
                tempList.add(role);
            }
        }

//        User finalUser = user;
//        userDto.getRoles().forEach(r -> {
//            UserRoleAssignment role = new UserRoleAssignment();
//            role.setRole(r);
//            role.setUsers(finalUser);
//            tempList.add(role);
//        });

        user.setRoles(tempList);

        user = userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public UserRestDto updateUser(Integer userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(GameOnException::UserNotFound);
        Period age;
        int years;
        if (userDto.getDob() != null) {
            age = Period.between(userDto.getDob(), LocalDate.now());
            years = age.getYears();
            if (years < 18) {
                throw GameOnException.badRequest("IllegalAge", "User must be 18-year-old.");
            }
        }

        if (userDto.getFirstName() != null) {
            if (userDto.getFirstName().trim().isBlank() || userDto.getFirstName().isEmpty()) {
                throw GameOnException.badRequest("FirstNameNotFound", "First name is missing");
            }
        }
        if (userDto.getLastName() != null) {
            if (userDto.getLastName().trim().isBlank() || userDto.getLastName().isEmpty()) {
                throw GameOnException.badRequest("LastNameNotFound", "Last name is missing");
            }
        }
        if (userDto.getPassword() != null) {
            if (userDto.getPassword().trim().isBlank() || userDto.getPassword().isEmpty()) {
                throw GameOnException.badRequest("PasswordNotFound", "Password is missing");
            }
        }
        if (userDto.getEmail() != null) {
            if (userDto.getEmail().trim().isBlank() || userDto.getEmail().isEmpty()) {
                throw GameOnException.badRequest("EmailNotFound", "Email is missing");
            }
        }
        if (userDto.getTel() != null) {
            if (userDto.getTel().trim().isBlank() || userDto.getTel().isEmpty()) {
                throw GameOnException.badRequest("TelephoneNumberNotFound", "Telephone number is missing");
            }
        }
        if (userDto.getAddress() != null) {
            if (userDto.getAddress().trim().isBlank() || userDto.getAddress().isEmpty()) {
                throw GameOnException.badRequest("AddressNotFound", "Address is missing");
            }
        }
        if (userDto.getGender() != null) {
            if (userDto.getGender() != Gender.Female && userDto.getGender() != Gender.Male) {
                throw GameOnException.badRequest("InvalidGender", "Gender must be MALE or FEMALE.");
            }
        }
        if (userDto.getBalance() != null) {
            if (userDto.getBalance() < 0) {
                throw GameOnException.badRequest("InvalidBalance", "Balance must be a positive number");
            }
        }
//        if (userDto.getRole() != null) {
//            if (userDto.getRole() != Role.ROLE_USER && userDto.getRole() != Role.ROLE_ADMIN) {
//                throw GameOnException.badRequest("InvalidRole", "Role must be " + Role.ROLE_USER + " or " + Role.ROLE_ADMIN);
//            }
//        }
        userMapper.mapFromDto(userDto, user);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserRestDto> findByGender(Gender gender) {
        return userMapper.toDtos(userRepository.findByGender(gender));
    }

    @Override
    public List<UserRestDto> findByFirstNameContaining(String name) {
        return userRepository.findByFirstNameContaining(name).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRestDto> findByLastNameContaining(String name) {
        return userRepository.findByLastNameContaining(name).stream().map(userMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<UserRestDto> findByEmailContaining(String name) {
        return userRepository.findByEmailContaining(name).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRestDto> findByTelContaining(String name) {
        return userRepository.findByTelContaining(name).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRestDto> findByAddressContaining(String name) {
        return userRepository.findByAddressContaining(name).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRestDto> findByDobAfter(LocalDate date) {
        return userRepository.findByDobAfter(date).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRestDto> findByDobBefore(LocalDate date) {
        return userRepository.findByDobBefore(date).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRestDto> findByBalanceGreaterThan(Double balance) {
        return userRepository.findByBalanceGreaterThan(balance).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRestDto> findByBalanceLessThan(Double balance) {
        return userRepository.findByBalanceLessThan(balance).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRestDto> findByActiveTrue() {
        return userRepository.findByActiveTrue().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserRestDto> findByActiveFalse() {
        return userRepository.findByActiveFalse().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
