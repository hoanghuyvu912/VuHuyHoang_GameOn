package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.ReceiptDto;
import com.nonIt.GameOn.service.restDto.ReceiptRestDto;

import java.time.LocalDate;
import java.util.List;

public interface ReceiptService {
    List<ReceiptRestDto> getAll();

    ReceiptRestDto findById(Integer receiptId);

    List<ReceiptRestDto> findByReceiptDateAfter(LocalDate date);

    List<ReceiptRestDto> findByReceiptDateBefore(LocalDate date);

    ReceiptRestDto createReceipt(ReceiptDto receiptDto);

    ReceiptRestDto updateReceipt(Integer receiptId, ReceiptDto receiptDto);

    void deleteReceipt(Integer receiptId);

    List<ReceiptRestDto> getByUserId(Integer userId);
}
