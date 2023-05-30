package com.nonIt.GameOn.service.restDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BestSellerGamesDto {
    private String name;
    private Long copiesSold;
}
