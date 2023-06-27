package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.*;
import com.nonIt.GameOn.exception.ResponseException;
import com.nonIt.GameOn.repository.*;
import com.nonIt.GameOn.rest.resourcesdto.ReceiptCreateDto;
import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.ReceiptService;
import com.nonIt.GameOn.service.createdto.ReceiptDto;
import com.nonIt.GameOn.service.customDto.ReceiptDetailResponseDto;
import com.nonIt.GameOn.service.restdto.ReceiptRestDto;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
class ReceiptServiceImplTest {
    @Autowired
    private ReceiptServiceImpl receiptService;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameCodeRepository gameCodeRepository;
    @Autowired
    private ReceiptDetailsRepository receiptDetailsRepository;

    private ReceiptCreateDto getReceiptCreateDto() {
        int userId = 4;
        Optional<User> user = userRepository.findById(userId);
        assertTrue(user.isPresent());

        int gameId = 2;
        Optional<Game> game = gameRepository.findById(gameId);
        assertTrue(game.isPresent());

        List<Integer> gameIdList = new ArrayList<>();
        gameIdList.add(gameId);

        ReceiptCreateDto receiptCreateDto = new ReceiptCreateDto(userId, gameIdList);
        return receiptCreateDto;
    }

    @Test
    void Should_HaveNewReceipt_When_CreateReceipt() {
        ReceiptCreateDto receiptCreateDto = getReceiptCreateDto();

        List<GameCode> gameCodeList = gameCodeRepository.findByGameId(receiptCreateDto.getGameIdList().get(0));

        ReceiptRestDto newReceiptDto = receiptService.createReceipt(receiptCreateDto);

       List<ReceiptDetailResponseDto>  receiptDetails = receiptDetailsRepository.findByReceiptId(newReceiptDto.getId());

        assertNotNull(newReceiptDto);
        assertNotNull(newReceiptDto.getId());
    }

    @Test
    void Should_ThrowException_When_CreateReceiptFail() {
        int wrongUserId = 432;
        int wrongGameId = 2;

        List<Integer> gameIdList = new ArrayList<>();
        gameIdList.add(wrongGameId);

        ReceiptCreateDto receiptCreateDto = new ReceiptCreateDto(wrongUserId, gameIdList);

        ResponseException exception = assertThrows(ResponseException.class, () -> {
            receiptService.createReceipt(receiptCreateDto);
        });
    }

    @Test
    void Should_ReturnUpdatedReceipt_When_UpdateAReceipt() {
        int newUserId = 3;
        Optional<User> user = userRepository.findById(newUserId);
        assertTrue(userRepository.existsById(newUserId));

        int receiptId = 2;
        Optional<Receipt> initialReceipt = receiptRepository.findById(receiptId);
        assertTrue(initialReceipt.isPresent());

        LocalDate newDate = LocalDate.parse("2023-06-26");

        ReceiptDto receiptDto = ReceiptDto.builder()
                .userId(newUserId)
                .receiptDate(newDate)
                .build();

        receiptService.updateReceipt(receiptId, receiptDto);

        Optional<Receipt> updatedReceipt = receiptRepository.findById(receiptId);
        assertTrue(updatedReceipt.isPresent());

        assertNotEquals(initialReceipt.get().getReceiptDate(), updatedReceipt.get().getReceiptDate());
        assertNotEquals(initialReceipt.get().getUser().getId(), updatedReceipt.get().getUser().getId());
    }

    @Test
    void updateReceipt_InvalidReceiptDate_ExceptionThrow() {
        int wrongNewUserId = 999;
        LocalDate wrongNewDate = LocalDate.parse("2024-06-26");

        int receiptId = 2;
        Optional<Receipt> initialReceipt = receiptRepository.findById(receiptId);
        assertTrue(initialReceipt.isPresent());

        ReceiptDto receiptDto = ReceiptDto.builder()
                .userId(wrongNewUserId)
                .receiptDate(wrongNewDate)
                .build();

        ResponseException exception = assertThrows(ResponseException.class, () -> {
            receiptService.updateReceipt(receiptId, receiptDto);
        });
    }

    @Test
    void When_DeleteReceipt_Expect_ReceiptIsDeleted() {
        ReceiptCreateDto receiptCreateDto = getReceiptCreateDto();
        receiptService.createReceipt(receiptCreateDto);

        int newReceiptId = receiptService.getAll().size() - 1;

        receiptService.deleteReceipt(newReceiptId);

        boolean receiptExists = receiptRepository.existsById(newReceiptId);
        assertFalse(receiptExists);
    }

    @Test
    void deleteReceipt_InvalidReceiptId_ExceptionThrow() {
        int wrongReceiptId = receiptService.getAll().size() + 1;
        System.out.println(wrongReceiptId);
        ResponseException exception = assertThrows(ResponseException.class, () -> {
            receiptService.deleteReceipt(wrongReceiptId);
        });
    }


}