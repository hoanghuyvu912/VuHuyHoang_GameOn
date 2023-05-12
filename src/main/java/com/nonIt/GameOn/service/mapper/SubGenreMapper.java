package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.SubGenre;
import com.nonIt.GameOn.service.dto.SubGenreDto;
import com.nonIt.GameOn.service.restDto.SubGenreRestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubGenreMapper extends EntityMapper<SubGenreRestDto, SubGenre, SubGenreDto> {
//    SubGenreDto toDto(SubGenre subGenre);
//
//    List<SubGenreDto> toDtos(List<SubGenre> subGenres);
//
//    SubGenreRestDto toRestDto(SubGenre subGenre);
//
//    List<SubGenreRestDto> toRestDtos(List<SubGenre> subGenres);
}
