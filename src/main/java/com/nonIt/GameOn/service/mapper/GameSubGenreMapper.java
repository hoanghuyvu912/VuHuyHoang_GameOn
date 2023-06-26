package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.GameGenre;
import com.nonIt.GameOn.entity.GameSubGenre;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameGenreDto;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameSubGenreDto;
import com.nonIt.GameOn.service.createdto.GameSubGenreDto;
import com.nonIt.GameOn.service.restdto.GameSubGenreRestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameSubGenreMapper extends EntityMapper<GameSubGenreRestDto, GameSubGenre, GameSubGenreDto> {
    @Mapping(target = "gameId", source = "game.id")
    @Mapping(target = "gameName", source = "game.name")
    @Mapping(target = "subGenreId", source = "subGenre.id")
    @Mapping(target = "subGenreName", source = "subGenre.name")
    SimplifiedGameSubGenreDto toSimplifiedDto(GameSubGenre gameSubGenre);
}
