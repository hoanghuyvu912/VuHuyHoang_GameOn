package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.service.createdto.DeveloperDto;
import com.nonIt.GameOn.service.restdto.DeveloperRestDto;
import org.mapstruct.Mapper;

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
