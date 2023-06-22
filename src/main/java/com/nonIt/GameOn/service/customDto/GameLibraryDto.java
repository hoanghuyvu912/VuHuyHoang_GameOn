package com.nonIt.GameOn.service.customDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameLibraryDto {
    private String gameName;
    private LocalDate receiptDate;
    private Double gamePrice;
}
