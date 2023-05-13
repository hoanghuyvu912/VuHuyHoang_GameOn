package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.entity.Role;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.service.UserService;
import com.nonIt.GameOn.service.dto.UserDto;
import com.nonIt.GameOn.service.mapper.UserMapper;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
        if (userDto.getRole() != Role.USER && userDto.getRole() != Role.ADMIN) {
            throw GameOnException.badRequest("InvalidRole", "Gender must be " + Role.USER + " or " + Role.ADMIN);
        }

        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .tel(userDto.getTel())
                .address(userDto.getAddress())
                .dob(userDto.getDob())
                .gender(userDto.getGender())
                .profileImg(userDto.getProfileImg())
                .balance(userDto.getBalance())
                .role(userDto.getRole())
                .active(userDto.isActive())
                .build();

        user = userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public UserRestDto updateUser(Integer userId, UserDto userDto) {
        Period age = Period.between(userDto.getDob(), LocalDate.now());
        int years = age.getYears();
        User user = userRepository.findById(userId).orElseThrow(GameOnException::UserNotFound);
        if (years < 18) {
            throw GameOnException.badRequest("IllegalAge", "User must be 18-year-old.");
        }
        if (userDto.getGender() != Gender.Female && userDto.getGender() != Gender.Male) {
            throw GameOnException.badRequest("InvalidGender", "Gender must be MALE or FEMALE.");
        }
        if (userDto.getBalance() < 0) {
            throw GameOnException.badRequest("InvalidBalance", "Balance must be a positive number");
        }
        if (userDto.getRole() != Role.USER && userDto.getRole() != Role.ADMIN) {
            throw GameOnException.badRequest("InvalidRole", "Gender must be " + Role.USER + " or " + Role.ADMIN);
        }
        userMapper.updateFromDto(userDto, user);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
