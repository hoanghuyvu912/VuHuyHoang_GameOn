package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.ReceiptService;
import com.nonIt.GameOn.service.dto.ReceiptDto;
import com.nonIt.GameOn.service.restDto.ReceiptRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/receipts")
public class ReceiptResources {
    private final ReceiptService receiptService;

    @GetMapping
    public ResponseEntity<List<ReceiptRestDto>> getAllReceipt() {
        return ResponseEntity.ok(receiptService.getAll());
    }

    @GetMapping(value = "/{receiptId}")
    public ResponseEntity<ReceiptRestDto> getReceiptById(@PathVariable("receiptId") Integer receiptId) {
        return ResponseEntity.ok(receiptService.findById(receiptId));
    }

    @PostMapping
    public ResponseEntity<ReceiptRestDto> createReceipt(@RequestBody ReceiptDto receiptDto) {
        return ResponseEntity.ok(receiptService.createReceipt(receiptDto));
    }

    @PutMapping(value = "/{receiptId}")
    public ResponseEntity<ReceiptRestDto> updateReceiptById(@PathVariable("receiptId") Integer receiptId, @RequestBody ReceiptDto receiptDto) {
        return ResponseEntity.ok(receiptService.updateReceipt(receiptId, receiptDto));
    }

    @DeleteMapping(value = "/{receiptId}")
    public ResponseEntity<Void> deleteReceiptById(@PathVariable("receiptId") Integer receiptId) {
        receiptService.deleteReceipt(receiptId);
        return ResponseEntity.noContent().build();
    }
}
