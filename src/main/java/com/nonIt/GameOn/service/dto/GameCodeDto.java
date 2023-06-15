package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.GameCodeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCodeDto {
    private Integer id;
    private String gameCode;
    private Integer gameId;
    private GameCodeStatus gameCodeStatus;
}
