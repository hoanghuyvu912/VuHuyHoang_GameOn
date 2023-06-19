package com.nonIt.GameOn.service;

import com.nonIt.GameOn.rest.resourcesdto.SimplifiedReceiptDetailsDto;
import com.nonIt.GameOn.service.createdto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.restdto.ReceiptDetailsRestDto;
import com.nonIt.GameOn.service.customDto.GameStatisticsDto;
import com.nonIt.GameOn.service.customDto.GameWithUsedGameCodeListDto;
import com.nonIt.GameOn.service.customDto.RevenuePerMonthInYearDto;

import java.time.LocalDate;
import java.util.List;

public interface ReceiptDetailsService {
    List<ReceiptDetailsRestDto> getAll();

    List<SimplifiedReceiptDetailsDto> findByReceiptUserId(Integer userId);

    ReceiptDetailsRestDto findById(Integer receiptDetailsId);

    ReceiptDetailsRestDto createReceiptDetails(ReceiptDetailsDto receiptDetailsDto);

    ReceiptDetailsRestDto updateReceiptDetails(Integer receiptDetailsId, ReceiptDetailsDto receiptDetailsDto);

    void deleteReceiptDetails(Integer receiptDetailsId);

//    List<ReceiptDetailsRestDto> getRevenueOfReceiptDetailsBetweenDates(LocalDate date1, LocalDate date2);
    RevenuePerMonthInYearDto getRevenuePerMonthInYear(Integer month, Integer year);
    List<GameWithUsedGameCodeListDto> getBestSellerGamesBetweenDates(LocalDate startDate, LocalDate endDate);
    List<ReceiptDetailsDto> getReceiptDetailListBetweenDates(LocalDate startDate, LocalDate endDate);
    List<GameWithUsedGameCodeListDto> getWorstSellerGamesBetweenDates(LocalDate startDate, LocalDate endDate);

    List<GameStatisticsDto> getGameStatisticsDto(Integer month, Integer year);

}
