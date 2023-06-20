package com.nonIt.GameOn.service.customDto;

import com.nonIt.GameOn.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameStatisticsDto {
    private Integer id;
    private String name;
    private Long gameCodeList;
    private Double revenue;
}
