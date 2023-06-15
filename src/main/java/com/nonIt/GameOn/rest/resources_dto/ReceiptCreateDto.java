package com.nonIt.GameOn.rest.resources_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptCreateDto {
    private Integer userId;
    private List<Integer> gameIdList;
}
