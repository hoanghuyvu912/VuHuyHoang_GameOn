package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.SubGenre;
import com.nonIt.GameOn.service.createdto.SubGenreDto;
import com.nonIt.GameOn.service.restdto.SubGenreRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubGenreMapper extends EntityMapper<SubGenreRestDto, SubGenre, SubGenreDto> {
}
