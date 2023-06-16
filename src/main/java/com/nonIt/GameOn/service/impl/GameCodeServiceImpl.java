package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.GameCodeRepository;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.service.GameCodeService;
import com.nonIt.GameOn.service.dto.GameCodeDto;
import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.mapper.GameCodeMapper;
import com.nonIt.GameOn.service.restDto.GameCodeRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GameCodeServiceImpl implements GameCodeService {
    private final GameCodeRepository gameCodeRepository;
    private final GameCodeMapper gameCodeMapper;
    private final GameRepository gameRepository;
    @Override
    public List<GameCodeRestDto> getAll() {
        return gameCodeRepository.findAll().stream().map(gameCodeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public GameCodeRestDto createGameCodeForGame(GameCodeDto gameCodeDto) {
        Game game = gameRepository.findById(gameCodeDto.getGameId()).orElseThrow(GameOnException::GameNotFound);

        GameCode newGameCode = GameCode.builder()
                .gameCode(gameCodeDto.getGameCode())
                .game(game)
                .gameCodeStatus(gameCodeDto.getGameCodeStatus())
                .build();

        gameCodeRepository.save(newGameCode);
        return gameCodeMapper.toDto(newGameCode);
    }
}
