package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.GameImage;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.GameImageRepository;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.service.GameImageService;
import com.nonIt.GameOn.service.dto.GameImageDto;
import com.nonIt.GameOn.service.mapper.GameImageMapper;
import com.nonIt.GameOn.service.restDto.GameImageRestDto;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GameImageServiceImpl implements GameImageService {
    private final GameImageRepository GameImageRepository;
    private final GameRepository gameRepository;
    private final GameImageMapper GameImageMapper;

    @Override
    public List<GameImageRestDto> getAll() {
        return GameImageRepository.findAll().stream().map(GameImageMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public GameImageRestDto findById(Integer gameImageId) {
        return GameImageRepository.findById(gameImageId).map(GameImageMapper::toDto).orElseThrow(GameOnException::GameImageNotFound);
    }

    @Override
    public GameImageRestDto createGameImage(GameImageDto gameImageDto) {
        Game game = gameRepository.findById(gameImageDto.getGameId()).orElseThrow(GameOnException::GameNotFound);

        if (gameImageDto.getImageLink() == null || gameImageDto.getImageLink().trim().isBlank() || gameImageDto.getImageLink().isEmpty()) {
            throw GameOnException.badRequest("ImageLinkNotFound", "Image link is missing.");
        }

        GameImage gameImage = GameImage.builder()
                .game(game)
                .imageLink(gameImageDto.getImageLink())
                .build();

        gameImage = GameImageRepository.save(gameImage);
        return GameImageMapper.toDto(gameImage);
    }

    @Override
    public GameImageRestDto updateGameImage(Integer GameImageId, GameImageDto gameImageDto) {
        GameImage gameImage = GameImageRepository.findById(GameImageId).orElseThrow(GameOnException::GameImageNotFound);

        Game game = gameRepository.findById(gameImageDto.getGameId()).orElseThrow(GameOnException::GameNotFound);

        if (gameImageDto.getImageLink() == null || gameImageDto.getImageLink().trim().isBlank() || gameImageDto.getImageLink().isEmpty()) {
            throw GameOnException.badRequest("ImageLinkNotFound", "Image link is missing.");
        }

        gameImage.setGame(game);
        gameImage.setImageLink(gameImageDto.getImageLink());

        GameImageRepository.save(gameImage);

        return GameImageMapper.toDto(gameImage);
    }

    @Override
    public void deleteGameImage(Integer gameImageId) {
        GameImageRepository.deleteById(gameImageId);
    }
}
