package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import com.nonIt.GameOn.service.restDto.RatingRestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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

        tempList.forEach(System.out::println);
    }

//    @Test
//    void getGamesByGameSearchDto() {
//
//        List<GameRestDto> gamesListByCriteria = gameService.getGamesByGameSearchDto();
//    }
}