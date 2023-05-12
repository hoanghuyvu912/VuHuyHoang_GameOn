package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.service.dto.DeveloperDto;
import com.nonIt.GameOn.service.restDto.DeveloperRestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeveloperMapper extends EntityMapper<DeveloperRestDto, Developer, DeveloperDto> {
//    DeveloperDto toDto(Developer developer);
//
//    List<DeveloperDto> toDtos(List<Developer> developers);
//
//    DeveloperRestDto toRestDto(Developer developer);
//
//    List<DeveloperRestDto> toRestDtos(List<Developer> developers);
}
