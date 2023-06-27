package com.nonIt.GameOn.service.impl;


import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.entity.GameCodeStatus;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.repository.GameCodeRepository;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.rest.resourcesdto.ReceiptCreateDto;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedReceiptDetailsDto;
import com.nonIt.GameOn.service.ReceiptDetailsService;
import com.nonIt.GameOn.service.ReceiptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class ReceiptDetailsServiceImplTest {
    @Autowired
    private ReceiptDetailsServiceImpl receiptDetailsService;
    @Autowired
    private ReceiptServiceImpl receiptService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameCodeRepository gameCodeRepository;
    @BeforeEach
    void setUp(){
        int userId = 4;
        Optional<User> user = userRepository.findById(userId);
        assertTrue(user.isPresent());

        int gameId = 3;
        Optional<Game> game = gameRepository.findById(gameId);
        assertTrue(game.isPresent());

        List<Integer> gameIdList = new ArrayList<>();
        gameIdList.add(gameId);

        ReceiptCreateDto receiptCreateDto = new ReceiptCreateDto(userId, gameIdList);

        receiptService.createReceipt(receiptCreateDto);
    }
    @Test
    void Should_ReturnReceiptDetailList_When_GetAll() {
        assertTrue(receiptDetailsService.getAll().size() > 0);
    }

    @Test
    void getReceiptDetailListBetweenDates() {
        LocalDate dateOne = LocalDate.parse("2023-06-15");
        LocalDate dateTwo = LocalDate.parse("2023-06-19");
        receiptDetailsService.getReceiptDetailListBetweenDates(dateOne,dateTwo);
    }

    @Test
    void getWorstSellerGamesBetweenDates() {
        LocalDate startDate = LocalDate.parse("2023-06-15");
        LocalDate endDate = LocalDate.parse("2023-06-20");

//        receiptDetailsService.getWorstSellerGamesBetweenDates(startDate, endDate).forEach(e -> System.out.println(e.getGame().getName() + ": " + e.getNumberOfUsedGameCode()));
    }
}