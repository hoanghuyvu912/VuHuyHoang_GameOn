package com.nonIt.GameOn.service;

import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameDto;
import com.nonIt.GameOn.service.customDto.GameLibraryDto;
import com.nonIt.GameOn.service.customDto.GameSearchDto;
import com.nonIt.GameOn.service.createdto.GameDto;
import com.nonIt.GameOn.service.customDto.GameWithUsedGameCodeListDto;
import com.nonIt.GameOn.service.restdto.GameRestDto;

import java.time.LocalDate;
import java.util.List;

public interface GameService {
    //CRUD APIs
    List<SimplifiedGameDto> getAll();

    SimplifiedGameDto findById(Integer gameId);

    SimplifiedGameDto createGame(GameDto gameDto);

    GameRestDto updateGame(Integer gameId, GameDto gameDto);

    void deleteGame(Integer gameId);

    //Find featured games
    List<SimplifiedGameDto> getFeaturedGame();

    //Find recent best-seller games
    List<GameWithUsedGameCodeListDto> getRecentBestSellerGames();

    //Find recent worst-seller games
    List<GameWithUsedGameCodeListDto> getRecentWorstSellerGames();

    //Find by name
    List<GameRestDto> findByNameIgnoreCaseContaining(String name);


    //Find by foreign key
    List<GameRestDto> getByDeveloperId(Integer developerId);

    List<GameRestDto> getByPublisherId(Integer publisherId);

    List<GameLibraryDto> getByUser(String authorization);

    List<GameRestDto> getByGenreId(Integer genreId);

    List<GameRestDto> getByGenreName(String genreName);

    List<GameRestDto> getBySubGenreId(Integer subGenreId);

    List<GameRestDto> getBySubGenreName(String subGenreName);

    //Custom queries
    List<GameRestDto> getByRatingAndReleasedDateBetween(Integer rating1, Integer rating2, LocalDate date1, LocalDate date2);


    //    TEST ADVANCED SEARCH
    List<GameRestDto> getGamesByGameSearchDto(GameSearchDto gameSearchDto);


}
