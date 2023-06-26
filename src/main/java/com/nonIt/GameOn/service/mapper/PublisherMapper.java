package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Publisher;
import com.nonIt.GameOn.service.createdto.PublisherDto;
import com.nonIt.GameOn.service.restdto.PublisherRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper extends EntityMapper<PublisherRestDto, Publisher, PublisherDto>{
}
