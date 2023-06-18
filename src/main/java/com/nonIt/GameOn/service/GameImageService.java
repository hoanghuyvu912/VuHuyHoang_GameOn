package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.createdto.GameImageDto;
import com.nonIt.GameOn.service.restdto.GameImageRestDto;

import java.util.List;

public interface GameImageService {
    List<GameImageRestDto> getAll();

    GameImageRestDto findById(Integer gameImageId);

    GameImageRestDto createGameImage(GameImageDto gameImageDto);

    GameImageRestDto updateGameImage(Integer gameImageId, GameImageDto gameImageDto);

    void deleteGameImage(Integer gameImageId);

    List<GameImageRestDto> getByGameId(Integer gameId);

    List<GameImageRestDto> getByGameName(String gameName);
}
