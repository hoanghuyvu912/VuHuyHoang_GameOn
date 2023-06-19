package com.nonIt.GameOn.rest.resourcesdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedRatingDto {
    private Integer id;

    private Integer userId;

    private String username;

    private Integer rating;
}
