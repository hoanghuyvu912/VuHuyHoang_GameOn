package com.nonIt.GameOn.rest.resourcesdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedReceiptDetailsDto {
    private Integer receiptDetailsId;
    private Integer gameId;
    private Integer receiptId;
}
