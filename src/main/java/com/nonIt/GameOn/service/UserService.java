package com.nonIt.GameOn.service;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.service.dto.UserDto;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserRestDto> getAll();

    UserRestDto findById(Integer userId);

    UserRestDto createUser(UserDto userDto);

    UserRestDto updateUser(Integer userId, UserDto userDto);

    UserRestDto updateUserProfileImage(Integer userId, MultipartFile file) throws IOException;

    void showUserProfileImage(Integer userId) throws IOException;

    List<UserRestDto> findByGender(Gender gender);

    List<UserRestDto> findByFirstNameContaining(String name);

    List<UserRestDto> findByLastNameContaining(String name);

    List<UserRestDto> findByEmailContaining(String name);

    List<UserRestDto> findByTelContaining(String name);

    List<UserRestDto> findByAddressContaining(String name);

    List<UserRestDto> findByDobAfter(LocalDate date);

    List<UserRestDto> findByDobBefore(LocalDate date);

    List<UserRestDto> findByBalanceGreaterThan(Double balance);

    List<UserRestDto> findByBalanceLessThan(Double balance);

    List<UserRestDto> findByActiveTrue();

    List<UserRestDto> findByActiveFalse();

    void deleteUser(Integer userId);
}
