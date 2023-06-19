package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.ReceiptDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDto {
    private Integer userId;
    private LocalDate receiptDate;

}