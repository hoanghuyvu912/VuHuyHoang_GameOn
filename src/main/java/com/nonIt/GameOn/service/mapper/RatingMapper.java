package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Rating;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedRatingDto;
import com.nonIt.GameOn.service.createdto.RatingDto;
import com.nonIt.GameOn.service.restdto.RatingRestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RatingMapper extends EntityMapper<RatingRestDto, Rating, RatingDto> {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "gameName", source = "game.name")
    SimplifiedRatingDto toSimplifiedDto(Rating rating);
}
