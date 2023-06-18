package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.GameGenre;
import com.nonIt.GameOn.service.createdto.GameGenreDto;
import com.nonIt.GameOn.service.restdto.GameGenreRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameGenreMapper extends EntityMapper<GameGenreRestDto, GameGenre, GameGenreDto> {
//    GameGenreDto toDto(GameGenre gameGenre);
//
//    List<GameGenreDto> toDtos(List<GameGenre> gameGenres);
//
//    GameGenreRestDto toRestDto(GameGenre gameGenre);
//
//    List<GameGenreRestDto> toRestDtos(List<GameGenre> gameGenres);
}
