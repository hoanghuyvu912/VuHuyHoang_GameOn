package com.nonIt.GameOn.service;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.entity.ReceiptDetails;
import com.nonIt.GameOn.rest.resources_dto.SimplifiedReceiptDetailsDto;
import com.nonIt.GameOn.service.customDto.GameWithUsedGameCodeListDto;
import com.nonIt.GameOn.service.customDto.RevenuePerDateDto;
import com.nonIt.GameOn.service.dto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ReceiptDetailsService {
    List<ReceiptDetailsRestDto> getAll();

    List<SimplifiedReceiptDetailsDto> findByReceiptUserId(Integer userId);

    ReceiptDetailsRestDto findById(Integer receiptDetailsId);

    ReceiptDetailsRestDto createReceiptDetails(ReceiptDetailsDto receiptDetailsDto);

    ReceiptDetailsRestDto updateReceiptDetails(Integer receiptDetailsId, ReceiptDetailsDto receiptDetailsDto);

    void deleteReceiptDetails(Integer receiptDetailsId);

//    List<ReceiptDetailsRestDto> getRevenueOfReceiptDetailsBetweenDates(LocalDate date1, LocalDate date2);
//    List<RevenuePerDateDto> getRevenuePerDateBetweenDates(@Param("date1")LocalDate date1, @Param("date2")LocalDate date2);
//
    List<GameWithUsedGameCodeListDto> getBestSellerGamesBetweenDates(LocalDate startDate, LocalDate endDate);
    List<ReceiptDetailsDto> getReceiptDetailListBetweenDates(LocalDate startDate, LocalDate endDate);
    List<GameWithUsedGameCodeListDto> getWorstSellerGamesBetweenDates(LocalDate startDate, LocalDate endDate);

}
