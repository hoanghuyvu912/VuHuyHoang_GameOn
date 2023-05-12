package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.RatingDto;
import com.nonIt.GameOn.service.restDto.RatingRestDto;

import java.util.List;

public interface RatingService {
    List<RatingRestDto> getAll();

    RatingRestDto findById(Integer ratingId);

    RatingRestDto createRating(RatingDto ratingDto);

    RatingRestDto updateRating(Integer ratingId, RatingDto ratingDto);

    void deleteRating(Integer ratingId);
}
