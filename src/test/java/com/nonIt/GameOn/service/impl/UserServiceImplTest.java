package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.entity.Role;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.exception.ResponseException;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.service.createdto.UserDto;
import com.nonIt.GameOn.service.restdto.UserRestDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    public UserDto getUserDto() {
        LocalDate birthday = LocalDate.parse("2000-06-23");
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_USER);
        UserDto userDto = UserDto.builder()
                .firstName("Eldridge")
                .lastName("Feast")
                .username("eldridgefeast")
                .password("$2a$12$5F6WrM6jNeXJv.ci66QFPuqeyXGGFS6.lIiJ5dshLn88Nd6GsUr3.")
                .email("test@gmail.com")
                .tel("0989788787")
                .address("test tp hcm")
                .roles(roles)
                .dob(birthday)
                .gender(Gender.Female)
                .build();
        return userDto;
    }

    @Test
    void Should_ReturnUserList_When_GetAll() {
        assertTrue(userService.getAll().size() > 0);
    }

    @Test
    void createUser_ValidData_ReturnNewUser() {
        UserDto userDto = getUserDto();

        UserRestDto userRestDto = userService.createUser(userDto);

        assertNotNull(userRestDto);
    }

    @Test
    void When_AgeLessThan18_Expect_isAdultAsFalse() {
        UserDto userDto = getUserDto();
        LocalDate wrongBirthday = LocalDate.parse("2023-06-23");
        userDto.setDob(wrongBirthday);

        ResponseException exception = assertThrows(ResponseException.class, () -> {
            userService.createUser(userDto);
        });
    }

    @Test
    void Should_ThrowException_When_UserIdIsNotFound() {
        int updatedUserId = userService.getAll().size() + 1;

        UserDto updatedUserDto = getUserDto();

        ResponseException exception = assertThrows(ResponseException.class, () -> {
            userService.updateUser(updatedUserId, updatedUserDto);
        });
    }

    @Test
    void Should_UpdateUser_When_FieldOfUserChange() {
        UserDto updateUserDto = getUserDto();

        int userId = 6;

        Optional<User> user = userRepository.findById(userId);
        assertTrue(user.isPresent());

        assertNotEquals(user.get().getUsername(), updateUserDto.getUsername());
        userService.updateUser(userId,updateUserDto);

        Optional<User> userAfterUpdate = userRepository.findById(userId);
        assertEquals(updateUserDto.getUsername(),userAfterUpdate.get().getUsername());
    }

    @Test
    void When_DeleteUser_Expect_UserIsDeleted(){
        UserDto userDto = getUserDto();

        userService.createUser(userDto);

        int userId = userRepository.findAll().size() - 1;
        userService.deleteUser(userId);

        boolean userExists = userRepository.existsById(userId);
        assertFalse(userExists);
    }
}