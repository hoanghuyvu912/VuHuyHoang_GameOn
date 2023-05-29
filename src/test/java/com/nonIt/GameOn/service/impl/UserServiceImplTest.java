package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.service.UserService;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void findByMonthOfRegisteredDate() {
        int month = 5;
        List<UserRestDto> tempList = userService.findByMonthOfRegisteredDate(month);
        tempList.stream().map(UserRestDto::getUsername).forEach(System.out::println);
    }
}