package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.service.createdto.GameCodeDto;
import com.nonIt.GameOn.service.restdto.GameCodeRestDto;
import com.nonIt.GameOn.service.customDto.GameCodeResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameCodeMapper extends EntityMapper<GameCodeRestDto, GameCode, GameCodeDto> {
    @Mapping(target = "gameId", source = "gameId")
    @Mapping(target = "gameCodeList", source = "gameCodeList")
    GameCodeResponseDto toGameCodeResponseDto(GameCodeDto gameCodeDto);
}

