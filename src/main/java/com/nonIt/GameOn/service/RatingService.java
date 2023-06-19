package com.nonIt.GameOn.service;

import com.nonIt.GameOn.entity.Rating;
import com.nonIt.GameOn.service.createdto.RatingDto;
import com.nonIt.GameOn.service.restdto.GameRestDto;
import com.nonIt.GameOn.service.restdto.RatingRestDto;

import java.time.LocalDate;
import java.util.List;

public interface RatingService {
    List<RatingRestDto> getAll();

    RatingRestDto findById(Integer ratingId);

    RatingRestDto createRating(RatingDto ratingDto);

    RatingRestDto updateRating(Integer ratingId, RatingDto ratingDto);

    void deleteRating(Integer ratingId);

    List<RatingRestDto> getByUserId(Integer userId);
//    List<Rating> demo();

//    List<GameRestDto> getGameByRatingBetweenAndReleasedDateBetween(Integer rating1, Integer rating2, LocalDate date1, LocalDate date2);
}
