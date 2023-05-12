package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;

import java.util.List;

public interface ReceiptDetailsService {
    List<ReceiptDetailsRestDto> getAll();

    ReceiptDetailsRestDto findById(Integer receiptDetailsId);

    ReceiptDetailsRestDto createReceiptDetails(ReceiptDetailsDto receiptDetailsDto);

    ReceiptDetailsRestDto updateReceiptDetails(Integer receiptDetailsId, ReceiptDetailsDto receiptDetailsDto);

    void deleteReceiptDetails(Integer receiptDetailsId);
}
