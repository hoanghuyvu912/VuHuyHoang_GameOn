package com.nonIt.GameOn.service.customDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDetailResponseDto {
    private Integer receiptDetailsId;
    private Integer receiptId;
    private String gameName;
    private Double gamePrice;

}