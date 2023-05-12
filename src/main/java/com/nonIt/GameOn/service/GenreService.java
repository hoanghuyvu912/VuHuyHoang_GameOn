package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.GenreDto;
import com.nonIt.GameOn.service.restDto.GenreRestDto;

import java.util.List;

public interface GenreService {
    List<GenreRestDto> getAll();

    GenreRestDto findById(Integer genreId);
    GenreRestDto createGenre(GenreDto genreDto);
    GenreRestDto updateGenre(Integer genreId, GenreDto genreDto);
    void deleteGenre(Integer genreId);
}
