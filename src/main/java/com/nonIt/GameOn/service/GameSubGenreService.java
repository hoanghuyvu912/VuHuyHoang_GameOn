package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.GameSubGenreDto;
import com.nonIt.GameOn.service.restDto.GameSubGenreRestDto;

import java.util.List;

public interface GameSubGenreService {
    List<GameSubGenreRestDto> getAll();

    GameSubGenreRestDto findById(Integer gameSubGenreId);
    GameSubGenreRestDto createGameSubGenre(GameSubGenreDto gameSubGenreDto);
    GameSubGenreRestDto updateGameSubGenre(Integer gameSubGenreId, GameSubGenreDto gameSubGenreDto);
    void deleteGameSubGenre(Integer gameSubGenreId);
}
