package com.nonIt.GameOn.service.impl;


import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.entity.GameCodeStatus;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.exception.ResponseException;
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
    void When_ProvideTwoDate_Expect_ReceiptDetailList() {
        LocalDate startDate = LocalDate.parse("2023-06-15");
        LocalDate endDate = LocalDate.parse("2023-06-19");

        assertTrue(receiptDetailsService.getReceiptDetailListBetweenDates(startDate,endDate).size() > 0);
    }

    @Test
    void Should_ThrowException_When_GetInvalidDate(){
        LocalDate startDate = LocalDate.parse("2024-06-15");
        LocalDate endDate = LocalDate.parse("2024-06-19");

        ResponseException exception = assertThrows(ResponseException.class, () -> {
            receiptDetailsService.getReceiptDetailListBetweenDates(startDate, endDate);
        });
    }

    @Test
    void Should_ReturnBestSellerGames_When_GetBestsellerGamesBetweenDates() {
        LocalDate startDate = LocalDate.parse("2023-06-15");
        LocalDate endDate = LocalDate.parse("2023-06-20");

        assertTrue(receiptDetailsService.getBestSellerGamesBetweenDates(startDate, endDate).size() > 0);
    }
    @Test
    void Should_ThrowException_When_GetInvalidDateInGetBestSellerGames(){
        LocalDate startDate = LocalDate.parse("2024-06-15");
        LocalDate endDate = LocalDate.parse("2024-06-19");

        ResponseException exception = assertThrows(ResponseException.class, () -> {
            receiptDetailsService.getBestSellerGamesBetweenDates(startDate, endDate);
        });
    }
}