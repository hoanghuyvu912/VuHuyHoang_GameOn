package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.service.ReceiptDetailsService;
import com.nonIt.GameOn.service.customDto.GameWithUsedGameCodeListDto;
import com.nonIt.GameOn.service.customDto.RevenuePerDateDto;
import com.nonIt.GameOn.service.dto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/receipt-details")
public class ReceiptDetailsResources {
    private final ReceiptDetailsService receiptDetailsService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ReceiptDetailsRestDto>> getAllReceiptDetails() {
        return ResponseEntity.ok(receiptDetailsService.getAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping(value = "/{receiptDetailsId}")
    public ResponseEntity<ReceiptDetailsRestDto> getReceiptDetailsById(@PathVariable("receiptDetailsId") Integer receiptDetailsId) {
        return ResponseEntity.ok(receiptDetailsService.findById(receiptDetailsId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ReceiptDetailsRestDto> createReceiptDetails(@RequestBody ReceiptDetailsDto receiptDetailsDto) {
        return ResponseEntity.ok(receiptDetailsService.createReceiptDetails(receiptDetailsDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{receiptDetailsId}")
    public ResponseEntity<ReceiptDetailsRestDto> updateReceiptDetailsById(@PathVariable("receiptDetailsId") Integer receiptDetailsId, @RequestBody ReceiptDetailsDto receiptDetailsDto) {
        return ResponseEntity.ok(receiptDetailsService.updateReceiptDetails(receiptDetailsId, receiptDetailsDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{receiptDetailsId}")
    public ResponseEntity<Void> deleteReceiptDetailsById(@PathVariable("receiptDetailsId") Integer receiptDetailsId) {
        receiptDetailsService.deleteReceiptDetails(receiptDetailsId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/bestseller-games")
    public ResponseEntity<List<GameWithUsedGameCodeListDto>> getBestSellerGamesBetweenDates(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate dateOne, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTwo ) {
            return ResponseEntity.ok(receiptDetailsService.getBestSellerGamesBetweenDates(dateOne, dateTwo));
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/revenue-per-date")
//    public ResponseEntity<List<RevenuePerDateDto>> getRevenuePerDateBetweenDates(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2) {
//        return ResponseEntity.ok(receiptDetailsService.getRevenuePerDateBetweenDates(date1, date2));
//    }
}
