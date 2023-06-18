package com.nonIt.GameOn.service.createdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDto {
    private Integer userId;
    private LocalDate receiptDate;

}
