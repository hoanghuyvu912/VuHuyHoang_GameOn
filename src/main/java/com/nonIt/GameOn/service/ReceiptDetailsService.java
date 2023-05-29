package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.customDto.RevenuePerDateDto;
import com.nonIt.GameOn.service.dto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReceiptDetailsService {
    List<ReceiptDetailsRestDto> getAll();

    ReceiptDetailsRestDto findById(Integer receiptDetailsId);

    ReceiptDetailsRestDto createReceiptDetails(ReceiptDetailsDto receiptDetailsDto);

    ReceiptDetailsRestDto updateReceiptDetails(Integer receiptDetailsId, ReceiptDetailsDto receiptDetailsDto);

    void deleteReceiptDetails(Integer receiptDetailsId);

//    List<ReceiptDetailsRestDto> getRevenueOfReceiptDetailsBetweenDates(LocalDate date1, LocalDate date2);
    List<RevenuePerDateDto> getRevenuePerDateBetweenDates(@Param("date1")LocalDate date1, @Param("date2")LocalDate date2);
}
