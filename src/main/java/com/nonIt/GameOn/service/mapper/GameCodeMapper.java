package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.service.createdto.GameCodeDto;
import com.nonIt.GameOn.service.restdto.GameCodeRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameCodeMapper extends EntityMapper<GameCodeRestDto, GameCode, GameCodeDto> {
}
