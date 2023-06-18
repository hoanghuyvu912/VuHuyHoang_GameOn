package com.nonIt.GameOn.service.customDto;

import com.nonIt.GameOn.entity.GameCodeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCodeUpdatedDto {
    private String gameCode;
    private GameCodeStatus gameCodeStatus;
    private Integer gameId;
}
