package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.GameGenre;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameGenreDto;
import com.nonIt.GameOn.service.createdto.GameGenreDto;
import com.nonIt.GameOn.service.restdto.GameGenreRestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameGenreMapper extends EntityMapper<GameGenreRestDto, GameGenre, GameGenreDto> {
    @Mapping(target = "gameId", source = "game.id")
    @Mapping(target = "gameName", source = "game.name")
    @Mapping(target = "genreId", source = "genre.id")
    @Mapping(target = "genreName", source = "genre.name")
    SimplifiedGameGenreDto toSimplifiedDto(GameGenre gameGenre);
}
