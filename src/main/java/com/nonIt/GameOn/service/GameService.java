package com.nonIt.GameOn.service;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface GameService {
    //CRUD APIs
    List<GameRestDto> getAll();

    GameRestDto findById(Integer gameId);

    GameRestDto createGame(GameDto gameDto);

    GameRestDto updateGame(Integer gameId, GameDto gameDto);

    void deleteGame(Integer gameId);


    //Find by Game name related
    List<GameRestDto> findByNameContaining(String name);

    List<GameRestDto> findByNameContainingAndReleasedDateAfter(String gameName, LocalDate date);
    List<GameRestDto> findByNameContainingAndReleasedDateAfterAnd(String gameName, LocalDate date);


    List<GameRestDto> findByNameContainingAndReleasedDateBefore(String gameName, LocalDate date);

    List<GameRestDto> findByNameContainingAndReleasedDateBetween(String gameName, LocalDate date1, LocalDate date2);

    List<GameRestDto> findByNameContainingAndSystemReqContaining(String name, String req);

    List<GameRestDto> findByNameContainingAndPriceLessThanEqual(String name, Double price);

    List<GameRestDto> findByNameContainingAndPriceGreaterThanEqual(String name, Double price);

    List<GameRestDto> findByNameContainingAndPriceBetween(String name, Double price1, Double price2);

    List<GameRestDto> findByNameContainingAndDeveloperNameContaining(String gameName, String developerName);

    List<GameRestDto> findByNameContainingAndPublisherNameContaining(String gameName, String publisherName);


    //Find by Game releasedDate related
    List<GameRestDto> findByReleasedDateAfter(LocalDate date);

    List<GameRestDto> findByReleasedDateBefore(LocalDate date);

    List<GameRestDto> findByReleasedDateAfterAndSystemReqContaining(LocalDate date, String systemReq);

    List<GameRestDto> findByReleasedDateBeforeAndSystemReqContaining(LocalDate date, String systemReq);

    List<GameRestDto> findByReleasedDateBetweenAndSystemReqContaining(LocalDate date1, LocalDate date2, String systemReq);

    List<GameRestDto> findByReleasedDateAfterAndPriceLessThanEqual(LocalDate date, Double price);

    List<GameRestDto> findByReleasedDateAfterAndPriceGreaterThanEqual(LocalDate date, Double price);

    List<GameRestDto> findByReleasedDateAfterAndPriceBetween(LocalDate date, Double price1, Double price2);

    List<GameRestDto> findByReleasedDateBeforeAndPriceLessThanEqual(LocalDate date, Double price);

    List<GameRestDto> findByReleasedDateBeforeAndPriceGreaterThanEqual(LocalDate date, Double price);

    List<GameRestDto> findByReleasedDateBeforeAndPriceBetween(LocalDate date, Double price1, Double price2);

    List<GameRestDto> findByReleasedDateBetweenAndPriceBetween(LocalDate date1, LocalDate date2, Double price1, Double price2);


    //Find by Game systemReq related
    List<GameRestDto> findBySystemReqContaining(String req);

    List<GameRestDto> findBySystemReqContainingAndPriceGreaterThanEqual(String req, Double price);

    List<GameRestDto> findBySystemReqContainingAndPriceLessThanEqual(String req, Double price);

    List<GameRestDto> findBySystemReqContainingAndPriceBetween(String req, Double price1, Double price2);


    //Find by Game price related

    List<GameRestDto> findByPriceGreaterThan(Double price);

    List<GameRestDto> findByPriceLessThan(Double price);

    List<GameRestDto> findByPriceBetween(Double price1, Double price2);


    //Find by foreign key

    List<GameRestDto> getByDeveloperId(Integer developerId);

    List<GameRestDto> getByPublisherId(Integer publisherId);

    List<GameRestDto> getByUserId(Integer userId);

    List<GameRestDto> getByUsername(String username);

    List<GameRestDto> getByGenreId(Integer genreId);

    List<GameRestDto> getByGenreName(String genreName);

    List<GameRestDto> getBySubGenreId(Integer subGenreId);

    List<GameRestDto> getBySubGenreName(String subGenreName);

//    List<GameRestDto> getByRatingAndReleasedDateBetween(Integer rating1, Integer rating2, LocalDate date1, LocalDate date2);
}
