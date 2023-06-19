package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.GameCodeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCodeRestDto {
    private Integer id;
    private String gameCode;
    private Game game;
    private GameCodeStatus gameCodeStatus;
}
