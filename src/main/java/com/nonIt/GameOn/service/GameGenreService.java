package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.GameGenreDto;
import com.nonIt.GameOn.service.restDto.GameGenreRestDto;

import java.util.List;

public interface GameGenreService {
    List<GameGenreRestDto> getAll();

    GameGenreRestDto findById(Integer gameGenreId);
    GameGenreRestDto createGameGenre(GameGenreDto gameGenreDto);
    GameGenreRestDto updateGameGenre(Integer gameGenreId, GameGenreDto gameGenreDto);
    void deleteGameGenre(Integer gameGenreId);
}
