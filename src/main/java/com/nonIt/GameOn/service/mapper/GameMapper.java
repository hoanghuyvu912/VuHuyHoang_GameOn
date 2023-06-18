package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameDto;
import com.nonIt.GameOn.service.customDto.GameWithRatingDto;
import com.nonIt.GameOn.service.createdto.GameDto;
import com.nonIt.GameOn.service.restdto.GameRestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameMapper extends EntityMapper<GameRestDto, Game, GameDto> {
    GameWithRatingDto toGameWithRatingDto(Game game);

    @Mapping(target = "developerId", source = "developer.id")
    @Mapping(target = "publisherId", source = "publisher.id")
    @Mapping(target = "developerName", source = "developer.name")
    @Mapping(target = "publisherName", source = "publisher.name")
    SimplifiedGameDto toSimplifiedDto(Game game);
//    GameDto toDto(Game game);
//
//    List<GameDto> toDtos(List<Game> games);
//
//    GameRestDto toRestDto(Game game);
//
//    List<GameRestDto> toRestDtos(List<Game> games);
}
