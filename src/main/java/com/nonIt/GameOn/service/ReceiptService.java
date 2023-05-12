package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.ReceiptDto;
import com.nonIt.GameOn.service.restDto.ReceiptRestDto;

import java.util.List;

public interface ReceiptService {
    List<ReceiptRestDto> getAll();

    ReceiptRestDto findById(Integer receiptId);

    ReceiptRestDto createReceipt(ReceiptDto receiptDto);

    ReceiptRestDto updateReceipt(Integer receiptId, ReceiptDto receiptDto);

    void deleteReceipt(Integer receiptId);
}
