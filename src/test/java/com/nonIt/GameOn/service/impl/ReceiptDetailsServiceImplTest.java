package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.service.customDto.GameStatisticsDto;
import com.nonIt.GameOn.service.customDto.RevenuePerMonthInYearDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ReceiptDetailsServiceImplTest {
    @Autowired
    private ReceiptDetailsServiceImpl receiptDetailsService;

    @Test
    void Should_ReturnListOfReceiptDetail_When_GetAll() {
        assertTrue(receiptDetailsService.getAll().size() > 0);
    }

    @Test
    void Should_ShowRevenuePerMonthInYear_When_GetAMonth() {
        int month = 6;
        int year = 2023;

        RevenuePerMonthInYearDto revenuePerMonthInYear = receiptDetailsService.getRevenuePerMonthInYear(month,year);

        assertTrue(revenuePerMonthInYear.getRevenue() > 0);
    }

    @Test
    void Should_ShowListOfBestSellerGame_Between_Dates() {
        LocalDate startDate = LocalDate.of(2023,6,1);
        LocalDate endDate = LocalDate.of(2023,6,20);

        assertTrue(receiptDetailsService.getBestSellerGamesBetweenDates(startDate,endDate).size() > 0);

    }

    @Test
    void Should_ShowReceiptDetailList_Between_Dates() {
        LocalDate startDate = LocalDate.of(2023,6,1);
        LocalDate endDate = LocalDate.of(2023,6,20);

        assertTrue(receiptDetailsService.getReceiptDetailListBetweenDates(startDate, endDate).size() > 0);
    }

    @Test
    void Should_ShowWorstSellerGame_Between_Dates() {
        LocalDate startDate = LocalDate.of(2023,6,1);
        LocalDate endDate = LocalDate.of(2023,6,20);

        assertTrue(receiptDetailsService.getWorstSellerGamesBetweenDates(startDate, endDate).size() > 0);
    }

    @Test
    void Should_ShowGameStatisticsList_PerMonth() {
        int month = 6;
        int year = 2023;

        List<GameStatisticsDto> gameStatisticsDto = receiptDetailsService.getGameStatisticsDto(month,year);

        assertTrue(gameStatisticsDto.size() > 0);
    }
}