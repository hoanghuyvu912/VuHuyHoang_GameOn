package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.service.UserService;
import com.nonIt.GameOn.service.restdto.UserRestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

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

    @Test
    void Should_ReturnUsers_When_GetAll() {
        assertTrue(userService.getAll().size() > 0);
    }

    @Test
    void When_GenderIsMaleOrFemale_Expect_Users(){
        assertTrue(userService.findByGender(Gender.Female).size() > 0);
    }

    @Test
    void Should_ShowListOfUser_When_InputContainFirstName(){
        String firstName = "Pepito";

        assertTrue(userService.findByFirstNameContaining(firstName).size() > 0);
    }
}