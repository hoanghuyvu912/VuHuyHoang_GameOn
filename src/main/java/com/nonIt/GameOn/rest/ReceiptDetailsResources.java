package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.ReceiptDetailsService;
import com.nonIt.GameOn.service.dto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/receiptDetailss")
public class ReceiptDetailsResources {
    private final ReceiptDetailsService receiptDetailsService;

    @GetMapping
    public ResponseEntity<List<ReceiptDetailsRestDto>> getAllReceiptDetails() {
        return ResponseEntity.ok(receiptDetailsService.getAll());
    }

    @GetMapping(value = "/{receiptDetailsId}")
    public ResponseEntity<ReceiptDetailsRestDto> getReceiptDetailsById(@PathVariable("receiptDetailsId") Integer receiptDetailsId) {
        return ResponseEntity.ok(receiptDetailsService.findById(receiptDetailsId));
    }

    @PostMapping
    public ResponseEntity<ReceiptDetailsRestDto> createReceiptDetails(@RequestBody ReceiptDetailsDto receiptDetailsDto) {
        return ResponseEntity.ok(receiptDetailsService.createReceiptDetails(receiptDetailsDto));
    }

    @PutMapping(value = "/{receiptDetailsId}")
    public ResponseEntity<ReceiptDetailsRestDto> updateReceiptDetailsById(@PathVariable("receiptDetailsId") Integer receiptDetailsId, @RequestBody ReceiptDetailsDto receiptDetailsDto) {
        return ResponseEntity.ok(receiptDetailsService.updateReceiptDetails(receiptDetailsId, receiptDetailsDto));
    }

    @DeleteMapping(value = "/{receiptDetailsId}")
    public ResponseEntity<Void> deleteReceiptDetailsById(@PathVariable("receiptDetailsId") Integer receiptDetailsId) {
        receiptDetailsService.deleteReceiptDetails(receiptDetailsId);
        return ResponseEntity.noContent().build();
    }
}
