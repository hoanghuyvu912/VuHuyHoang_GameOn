package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Rating;
import com.nonIt.GameOn.service.createdto.RatingDto;
import com.nonIt.GameOn.service.restdto.RatingRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper extends EntityMapper<RatingRestDto, Rating, RatingDto>{
//    RatingDto toDto(Rating rating);
//
//    List<RatingDto> toDtos(List<Rating> ratings);
//
//    RatingRestDto toRestDto(Rating rating);
//
//    List<RatingRestDto> toRestDtos(List<Rating> ratings);
}
