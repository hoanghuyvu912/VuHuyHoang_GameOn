package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.service.dto.GameCodeDto;
import com.nonIt.GameOn.service.restDto.GameCodeRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameCodeMapper extends EntityMapper<GameCodeRestDto, GameCode, GameCodeDto> {
}
