package com.nonIt.GameOn.service.customDto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameWithUsedGameCodeListDto {
    private SimplifiedGameDto simplifiedGameDto;
//    private Game game;
    private Integer numberOfUsedGameCode;
}
