package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameDto;
import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.createdto.GameDto;
import com.nonIt.GameOn.service.restdto.GameRestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class GameServiceImplTest {
    @Autowired
    private GameService gameService;

    @Test
    void getByRatingAndReleasedDateBetween() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date1Str = "2022/01/01";
        String date2Str = "2022/09/30";

        LocalDate date1 = LocalDate.parse(date1Str, formatter);
        LocalDate date2 = LocalDate.parse(date2Str, formatter);

        List<GameRestDto> tempList = gameService.getByRatingAndReleasedDateBetween(2, 4, date1, date2);

        assertTrue(tempList.size() > 0);
    }

    @Test
    void Should_ReturnListOfGame_When_GetAll() {
        assertTrue(gameService.getAll().size() > 0);
    }

    @Test
    void Should_ReturnAGame_When_FindByGameId() {
        Integer gameId = 1;

        SimplifiedGameDto game = gameService.findById(gameId);

        assertSame(gameId, game.getId());
    }

    @Test
    void Should_ThrowGameOnException_When_GameNotFound() {
        Integer gameId = 9999;

        assertThrows(GameOnException.GameNotFound().getClass(), () -> {
            gameService.findById(gameId);
        });
    }


}