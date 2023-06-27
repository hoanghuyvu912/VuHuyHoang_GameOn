package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.entity.GameCodeStatus;
import com.nonIt.GameOn.exception.ResponseException;
import com.nonIt.GameOn.repository.GameCodeRepository;
import com.nonIt.GameOn.service.createdto.GameCodeDto;
import com.nonIt.GameOn.service.customDto.GameCodeResponseDto;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
class GameCodeServiceImplTest {
    @Autowired
    private GameCodeServiceImpl gameCodeService;
    @Autowired
    private GameCodeRepository gameCodeRepository;

    private GameCodeDto getGameCodeDto() {
        List<String> gameCodeList = new ArrayList<>();

        int gameId = 3;

        gameCodeList.add("asdf234asdf12");
        gameCodeList.add("asdf234as3422");
        gameCodeList.add("aqwerqwesdf12");
        gameCodeList.add("asdfghjrsdf12");

        GameCodeDto gameCodeDto = GameCodeDto.builder()
                .gameId(gameId)
                .gameCodeList(gameCodeList)
                .gameCode("asdfasdf234JSDHF")
                .build();
        return gameCodeDto;
    }

    @Test
    void Should_ReturnGameCodeList_When_GetAll() {
        assertTrue(gameCodeService.getAll().size() > 0);
    }

    @Test
    void Should_ReturnNewGameCode_When_Update() {
        GameCodeDto gameCodeDto = getGameCodeDto();

        Optional<GameCode> gameCode = gameCodeRepository.findAll().stream().filter(gc -> gc.getGameCodeStatus().equals(GameCodeStatus.Available)).findFirst();
        assertTrue(gameCode.isPresent());

        int gameCodeId = gameCode.get().getId();

        assertNotNull(gameCodeService.updateGameCode(gameCodeId, gameCodeDto));
    }

    @Test
    void Should_ReturnAGameCodeList_When_Create() {
        GameCodeDto gameCodeDto = getGameCodeDto();

        int gameId = gameCodeDto.getGameId();

        List<GameCode> gameCodeListBefore = gameCodeRepository.findByGameId(gameId);

        GameCodeResponseDto game = gameCodeService.createListGameCodeForGame(gameCodeDto);

        List<GameCode> gameCodeListAfter = gameCodeRepository.findByGameId(gameId);

        assertNotEquals(gameCodeListBefore,gameCodeListAfter);
    }
    @Test
    void Should_ThrowException_When_InvalidGameCodeId() {
        int gameCodeId = 999;
        assertFalse(gameCodeRepository.findById(gameCodeId).isPresent());

        ResponseException exception = assertThrows(ResponseException.class, () -> {
            gameCodeService.deleteGameCode(gameCodeId);
        });
    }

    @Test
    void Should_ThrowException_When_InvalidGameCode(){
        GameCodeDto gameCodeDto = getGameCodeDto();

        int gameCodeId = 999;
        assertFalse(gameCodeRepository.findById(gameCodeId).isPresent());

        ResponseException exception = assertThrows(ResponseException.class, () -> {
            gameCodeService.updateGameCode(gameCodeId, gameCodeDto);
        });

    }

}