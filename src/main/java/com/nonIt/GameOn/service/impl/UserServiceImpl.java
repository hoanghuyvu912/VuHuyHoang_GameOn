package com.nonIt.GameOn.service.impl;

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
//        return userMapper.toDtos(userRepository.findAll());
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public UserRestDto findById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(GameOnException::UserNotFound);
        return userMapper.toDto(user);
    }

    @Override
    public UserRestDto createUser(UserDto userDto) {
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
        User user = userRepository.findById(userId).orElseThrow(GameOnException::UserNotFound);
        userMapper.updateFromDto(userDto, user);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
