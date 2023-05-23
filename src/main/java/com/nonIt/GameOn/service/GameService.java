package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface GameService {
    List<GameRestDto> getAll();

    List<GameRestDto> findByNameContaining(String name);

    List<GameRestDto> findByReleasedDateAfter(LocalDate date);

    List<GameRestDto> findByReleasedDateBefore(LocalDate date);

    List<GameRestDto> findByPriceGreaterThan(Double price);

    List<GameRestDto> findByPriceLessThan(Double price);

    List<GameRestDto> getByDeveloperId(Integer developerId);

    List<GameRestDto> getByPublisherId(Integer publisherId);

    List<GameRestDto> getByUserId(Integer userId);

    List<GameRestDto> getByUsername(String username);

    List<GameRestDto> getByGenreId(Integer genreId);

    List<GameRestDto> getByGenreName(String genreName);

    List<GameRestDto> getBySubGenreId(Integer subGenreId);

    List<GameRestDto> getBySubGenreName(String subGenreName);

    GameRestDto findById(Integer gameId);

    GameRestDto createGame(GameDto gameDto);

    GameRestDto updateGame(Integer gameId, GameDto gameDto);

    void deleteGame(Integer gameId);
}
