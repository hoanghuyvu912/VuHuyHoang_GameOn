package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Genre;
import com.nonIt.GameOn.service.createdto.GenreDto;
import com.nonIt.GameOn.service.restdto.GenreRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper extends EntityMapper<GenreRestDto, Genre, GenreDto>{
//    GenreDto toDto(Genre Genre);
//
//    List<GenreDto> toDtos(List<Genre> genres);
//
//    GenreRestDto toRestDto(Genre genre);
//
//    List<GenreRestDto> toRestDtos(List<Genre> genres);
}
