package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.createdto.GameCodeDto;
import com.nonIt.GameOn.service.restdto.GameCodeRestDto;

import java.util.List;

public interface GameCodeService {
    List<GameCodeRestDto> getAll();
    GameCodeRestDto createGameCodeForGame(GameCodeDto gameCodeDto);
    GameCodeRestDto updateGameCode(Integer gameCodeId, GameCodeDto gameCodeDto);

    void deleteGameCode(Integer gameCodeId);
}
