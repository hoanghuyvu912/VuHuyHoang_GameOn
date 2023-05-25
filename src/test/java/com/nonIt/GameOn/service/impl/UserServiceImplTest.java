package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Role;
import com.nonIt.GameOn.entity.UserRoleAssignment;
import com.nonIt.GameOn.service.UserService;
import com.nonIt.GameOn.service.mapper.UserRoleAssignmentMapper;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import com.nonIt.GameOn.service.restDto.UserRoleAssignmentRestDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RequiredArgsConstructor
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleAssignmentMapper userRoleAssignmentMapper;

    @Test
    void getAll() {
        List<UserRestDto> userRestDtos = userService.getAll();
        List<List<Role>> roleString = userRestDtos.stream()
                .map(UserRestDto::getRoles)
                .map(ele -> ele.stream().map(UserRoleAssignment::getRole).collect(Collectors.toList()))
                .collect(Collectors.toList());
        roleString.forEach(System.out::println);
    }

    @Test
    void findById() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void findByGender() {
    }

    @Test
    void findByFirstNameContaining() {
    }

    @Test
    void findByLastNameContaining() {
    }

    @Test
    void findByEmailContaining() {
    }

    @Test
    void findByTelContaining() {
    }

    @Test
    void findByAddressContaining() {
    }

    @Test
    void findByDobAfter() {
    }

    @Test
    void findByDobBefore() {
    }

    @Test
    void findByBalanceGreaterThan() {
    }

    @Test
    void findByBalanceLessThan() {
    }

    @Test
    void findByActiveTrue() {
    }

    @Test
    void findByActiveFalse() {
    }

    @Test
    void deleteUser() {
    }
}