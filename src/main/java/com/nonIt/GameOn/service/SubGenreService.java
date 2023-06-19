package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.createdto.SubGenreDto;
import com.nonIt.GameOn.service.restdto.SubGenreRestDto;

import java.util.List;

public interface SubGenreService {
    List<SubGenreRestDto> getAll();

    SubGenreRestDto findById(Integer subGenreId);

    SubGenreRestDto createSubGenre(SubGenreDto subGenreDto);

    SubGenreRestDto updateSubGenre(Integer subGenreId, SubGenreDto subGenreDto);

    void deleteSubGenre(Integer subGenreId);
}
