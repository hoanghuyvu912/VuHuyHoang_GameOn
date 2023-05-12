package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.GameImage;
import com.nonIt.GameOn.service.dto.GameImageDto;
import com.nonIt.GameOn.service.restDto.GameImageRestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameImageMapper extends EntityMapper<GameImageRestDto, GameImage, GameImageDto>{
//    GameImageDto toDto(GameImage gameImage);
//
//    List<GameImageDto> toDtos(List<GameImage> gameImages);
//
//    GameImageRestDto toRestDto(GameImage gameImage);
//
//    List<GameImageRestDto> toRestDtos(List<GameImage> gameImages);
}
