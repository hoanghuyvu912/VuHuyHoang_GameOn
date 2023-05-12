package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Publisher;
import com.nonIt.GameOn.service.dto.PublisherDto;
import com.nonIt.GameOn.service.restDto.PublisherRestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper extends EntityMapper<PublisherRestDto, Publisher, PublisherDto>{
//    PublisherDto toDto(Publisher publisher);
//
//    List<PublisherDto> toDtos(List<Publisher> publishers);
//
//    PublisherRestDto toRestDto(Publisher publisher);
//
//    List<PublisherRestDto> toRestDtos(List<Publisher> publishers);
}
