package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Publisher;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.DeveloperRepository;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.PublisherRepository;
import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.mapper.GameMapper;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final DeveloperRepository developerRepository;
    private final PublisherRepository publisherRepository;
    private final GameMapper gameMapper;

    @Override
    public List<GameRestDto> getAll() {
//        return gameMapper.toDtos(gameRepository.findAll());
        return gameRepository.findAll().stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public GameRestDto findById(Integer gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameOnException::GameNotFound);
        return gameMapper.toDto(game);
    }

    @Override
    public GameRestDto createGame(GameDto gameDto) {
        Developer developer = developerRepository.findById(gameDto.getDeveloperId()).orElseThrow(GameOnException::DeveloperNotFound);
        Publisher publisher = publisherRepository.findById(gameDto.getPublisherId()).orElseThrow(GameOnException::PublisherNotFound);

        Game game = Game.builder()
                .name(gameDto.getName())
                .thumbnail(gameDto.getThumbnail())
                .description(gameDto.getDescription())
                .trailer(gameDto.getTrailer())
                .releasedDate(gameDto.getReleasedDate())
                .systemReq(gameDto.getSystemReq())
                .price(gameDto.getPrice())
                .developer(developer)
                .publisher(publisher)
                .build();

        game = gameRepository.save(game);
        return gameMapper.toDto(game);
    }

    @Override
    public GameRestDto updateGame(Integer gameId, GameDto gameDto) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameOnException::GameNotFound);
        gameMapper.updateFromDto(gameDto, game);
        game = gameRepository.save(game);
        return gameMapper.toDto(game);
    }

    @Override
    public void deleteGame(Integer gameId) {
        gameRepository.deleteById(gameId);
    }
}
