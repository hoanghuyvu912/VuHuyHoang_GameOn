package com.nonIt.GameOn.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class GameRepositoryTest {
    @Autowired
    private GameRepository gameRepository;
    @Test
    void getByUserId() {
        System.out.println(gameRepository.getByUserId(5));
        gameRepository.getByUserId(5).forEach(System.out::println);
    }
}