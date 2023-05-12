package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Rating;
import com.nonIt.GameOn.service.dto.RatingDto;
import com.nonIt.GameOn.service.restDto.RatingRestDto;
import org.mapstruct.Mapper;

import java.util.List;

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
