package com.nonIt.GameOn.service;

import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameDto;
import com.nonIt.GameOn.service.customDto.GameLibraryDto;
import com.nonIt.GameOn.service.customDto.GameSearchDto;
import com.nonIt.GameOn.service.createdto.GameDto;
import com.nonIt.GameOn.service.restdto.GameRestDto;

import java.time.LocalDate;
import java.util.List;

public interface GameService {
    //CRUD APIs
    List<SimplifiedGameDto> getAll();

    SimplifiedGameDto findById(Integer gameId);

    GameRestDto createGame(GameDto gameDto);

    GameRestDto updateGame(Integer gameId, GameDto gameDto);

    void deleteGame(Integer gameId);

    //Find featured games
    List<SimplifiedGameDto> getFeaturedGame();

    //Find best-seller games between a period
//    List<GameRestDto> getBestSellerGamesBetweenAPeriod();

    //Find by name
    List<GameRestDto> findByNameIgnoreCaseContaining(String name);


    //Find by name and released date
    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfter(String gameName, LocalDate date);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBefore(String gameName, LocalDate date);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetween(String gameName, LocalDate date1, LocalDate date2);


    //Find by name and released date and system req
    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContaining(String gameName, LocalDate date, String req);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContaining(String gameName, LocalDate date, String req);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContaining(String gameName, LocalDate date1, LocalDate date2, String req);


    //Find by name and released date and system req and price
    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, LocalDate date, String req, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, LocalDate date, String req, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, LocalDate date, String req, Double price1, Double price2);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, LocalDate date, String req, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, LocalDate date, String req, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, LocalDate date, String req, Double price1, Double price2);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, LocalDate date1, LocalDate date2, String req, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, LocalDate date1, LocalDate date2, String req, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, LocalDate date1, LocalDate date2, String req, Double price1, double price2);


    //Find by name and system req
    List<GameRestDto> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContaining(String name, String req);


    //Find by name and system req and price
    List<GameRestDto> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, String req, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, String req, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, String req, Double price1, Double price2);


    //Find by name and price
    List<GameRestDto> findByNameIgnoreCaseContainingAndPriceLessThanEqual(String name, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndPriceGreaterThanEqual(String name, Double price);

    List<GameRestDto> findByNameIgnoreCaseContainingAndPriceBetween(String name, Double price1, Double price2);


    List<GameRestDto> findByNameContainingAndDeveloperNameContaining(String gameName, String developerName);

    List<GameRestDto> findByNameContainingAndPublisherNameContaining(String gameName, String publisherName);


    //Find by released date
    List<GameRestDto> findByReleasedDateAfter(LocalDate date);

    List<GameRestDto> findByReleasedDateBefore(LocalDate date);

    List<GameRestDto> findByReleasedDateBetween(LocalDate date1, LocalDate date2);


    //Find by released date and system req
    List<GameRestDto> findByReleasedDateAfterAndSystemReqIgnoreCaseContaining(LocalDate date, String systemReq);

    List<GameRestDto> findByReleasedDateBeforeAndSystemReqIgnoreCaseContaining(LocalDate date, String systemReq);

    List<GameRestDto> findByReleasedDateBetweenAndSystemReqIgnoreCaseContaining(LocalDate date1, LocalDate date2, String systemReq);


    //Find by released date and system req and price
    List<GameRestDto> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(LocalDate date, String systemReq, Double price);

    List<GameRestDto> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(LocalDate date, String systemReq, Double price);

    List<GameRestDto> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(LocalDate date, String systemReq, Double price1, Double price2);

    List<GameRestDto> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(LocalDate date, String systemReq, Double price);

    List<GameRestDto> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(LocalDate date, String systemReq, Double price);

    List<GameRestDto> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(LocalDate date, String systemReq, Double price1, Double price2);

    List<GameRestDto> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(LocalDate date1, LocalDate date2, String systemReq, Double price);

    List<GameRestDto> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(LocalDate date1, LocalDate date2, String systemReq, Double price);

    List<GameRestDto> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(LocalDate date1, LocalDate date2, String systemReq, Double price1, Double price2);


    //Find by released date and price
    List<GameRestDto> findByReleasedDateAfterAndPriceLessThanEqual(LocalDate date, Double price);

    List<GameRestDto> findByReleasedDateAfterAndPriceGreaterThanEqual(LocalDate date, Double price);

    List<GameRestDto> findByReleasedDateAfterAndPriceBetween(LocalDate date, Double price1, Double price2);

    List<GameRestDto> findByReleasedDateBeforeAndPriceLessThanEqual(LocalDate date, Double price);

    List<GameRestDto> findByReleasedDateBeforeAndPriceGreaterThanEqual(LocalDate date, Double price);

    List<GameRestDto> findByReleasedDateBeforeAndPriceBetween(LocalDate date, Double price1, Double price2);

    List<GameRestDto> findByReleasedDateBetweenAndPriceLessThanEqual(LocalDate date1, LocalDate date2, Double price);

    List<GameRestDto> findByReleasedDateBetweenAndPriceGreaterThanEqual(LocalDate date1, LocalDate date2, Double price);

    List<GameRestDto> findByReleasedDateBetweenAndPriceBetween(LocalDate date1, LocalDate date2, Double price1, Double price2);


    //Find by system req
    List<GameRestDto> findBySystemReqIgnoreCaseContaining(String req);


    //Find by system req and price
    List<GameRestDto> findBySystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String req, Double price);

    List<GameRestDto> findBySystemReqIgnoreCaseContainingAndPriceLessThanEqual(String req, Double price);

    List<GameRestDto> findBySystemReqIgnoreCaseContainingAndPriceBetween(String req, Double price1, Double price2);


    //Find by Game price related

    List<GameRestDto> findByPriceGreaterThan(Double price);

    List<GameRestDto> findByPriceLessThan(Double price);

    List<GameRestDto> findByPriceBetween(Double price1, Double price2);


    //Find by foreign key
    List<GameRestDto> getByDeveloperId(Integer developerId);

    List<GameRestDto> getByPublisherId(Integer publisherId);

    List<GameLibraryDto> getByUser(String authorization);
//
//    List<GameRestDto> getByUsername(String username);

    List<GameRestDto> getByGenreId(Integer genreId);

    List<GameRestDto> getByGenreName(String genreName);

    List<GameRestDto> getBySubGenreId(Integer subGenreId);

    List<GameRestDto> getBySubGenreName(String subGenreName);

    //Custom queries
    List<GameRestDto> getByRatingAndReleasedDateBetween(Integer rating1, Integer rating2, LocalDate date1, LocalDate date2);


    //    TEST ADVANCED SEARCH
    List<GameRestDto> getGamesByGameSearchDto(GameSearchDto gameSearchDto);


}
