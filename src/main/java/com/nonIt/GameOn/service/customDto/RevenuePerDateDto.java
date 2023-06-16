package com.nonIt.GameOn.service.customDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevenuePerDateDto {
    private LocalDate date;
    private Long gameCount;
    private Double revenue;
}