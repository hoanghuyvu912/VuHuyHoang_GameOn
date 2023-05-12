package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.GameSubGenre;
import com.nonIt.GameOn.service.dto.GameSubGenreDto;
import com.nonIt.GameOn.service.restDto.GameSubGenreRestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameSubGenreMapper extends EntityMapper<GameSubGenreRestDto, GameSubGenre, GameSubGenreDto>{
//    GameSubGenreDto toDto(GameSubGenre gameSubGenre);
//
//    List<GameSubGenreDto> toDtos(List<GameSubGenre> gameSubGenres);
//
//    GameSubGenreRestDto toRestDto(GameSubGenre gameSubGenre);
//
//    List<GameSubGenreRestDto> toRestDtos(List<GameSubGenre> gameSubGenres);
}
