package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.GameImage;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameImageDto;
import com.nonIt.GameOn.service.createdto.GameImageDto;
import com.nonIt.GameOn.service.restdto.GameImageRestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameImageMapper extends EntityMapper<GameImageRestDto, GameImage, GameImageDto> {
    @Mapping(target = "gameId", source = "game.id")
    SimplifiedGameImageDto toSimplifiedDto(GameImage gameImage);
}
