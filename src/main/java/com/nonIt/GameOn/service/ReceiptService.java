package com.nonIt.GameOn.service;

import com.nonIt.GameOn.rest.resourcesdto.ReceiptCreateDto;
import com.nonIt.GameOn.service.createdto.ReceiptDto;
import com.nonIt.GameOn.service.restdto.ReceiptRestDto;

import java.time.LocalDate;
import java.util.List;

public interface ReceiptService {
    List<ReceiptRestDto> getAll();

    ReceiptRestDto findById(Integer receiptId);

    List<ReceiptRestDto> findByReceiptDateAfter(LocalDate date);

    List<ReceiptRestDto> findByReceiptDateBefore(LocalDate date);

//    ReceiptRestDto createReceipt(ReceiptCreateDto receiptCreateDto);

    ReceiptRestDto updateReceipt(Integer receiptId, ReceiptDto receiptDto);

    void deleteReceipt(Integer receiptId);

    List<ReceiptRestDto> getByUserId(Integer userId);
}
