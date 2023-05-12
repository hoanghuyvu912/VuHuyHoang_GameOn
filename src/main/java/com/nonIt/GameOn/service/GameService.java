package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.restDto.GameRestDto;

import java.util.List;

public interface GameService {
    List<GameRestDto> getAll();
    GameRestDto findById(Integer gameId);
    GameRestDto createGame(GameDto gameDto);
    GameRestDto updateGame(Integer gameId, GameDto gameDto);
    void deleteGame(Integer gameId);
}
