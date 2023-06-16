package com.nonIt.GameOn.service;

import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.entity.GameCodeStatus;
import com.nonIt.GameOn.service.dto.GameCodeDto;
import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.restDto.GameCodeRestDto;

import java.util.List;

public interface GameCodeService {
    List<GameCodeRestDto> getAll();
    GameCodeRestDto createGameCodeForGame(GameCodeDto gameCodeDto);
    GameCodeRestDto updateGameCode(Integer gameCodeId, GameCodeStatus gameCodeStatus);
}
