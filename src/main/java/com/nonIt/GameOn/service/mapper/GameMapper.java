package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper extends EntityMapper<GameRestDto, Game, GameDto> {
//    GameDto toDto(Game game);
//
//    List<GameDto> toDtos(List<Game> games);
//
//    GameRestDto toRestDto(Game game);
//
//    List<GameRestDto> toRestDtos(List<Game> games);
}
