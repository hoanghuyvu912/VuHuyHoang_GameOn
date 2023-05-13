package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Rating;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.RatingRepository;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.service.RatingService;
import com.nonIt.GameOn.service.dto.RatingDto;
import com.nonIt.GameOn.service.mapper.RatingMapper;
import com.nonIt.GameOn.service.restDto.RatingRestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Override
    public List<RatingRestDto> getAll() {
        return ratingRepository.findAll().stream().map(ratingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RatingRestDto findById(Integer ratingId) {
        return ratingRepository.findById(ratingId).map(ratingMapper::toDto).orElseThrow(GameOnException::RatingNotFound);
    }

    @Override
    public RatingRestDto createRating(RatingDto ratingDto) {
        User user = userRepository.findById(ratingDto.getUserId()).orElseThrow(GameOnException::UserNotFound);
        Game game = gameRepository.findById(ratingDto.getGameId()).orElseThrow(GameOnException::GameNotFound);
        if (ratingDto.getRating() > 5 || ratingDto.getRating() < 1) {
            throw GameOnException.badRequest("InvalidRating", "Rating must be an integer between 1 and 5.");
        }
        Rating rating = Rating.builder()
                .user(user)
                .game(game)
                .rating(ratingDto.getRating())
                .build();
        rating = ratingRepository.save(rating);

        return ratingMapper.toDto(rating);
    }

    @Override
    public RatingRestDto updateRating(Integer ratingId, RatingDto ratingDto) {
        Rating rating = ratingRepository.findById(ratingId).orElseThrow(GameOnException::RatingNotFound);
        User user = userRepository.findById(ratingDto.getUserId()).orElseThrow(GameOnException::UserNotFound);
        Game game = gameRepository.findById(ratingDto.getGameId()).orElseThrow(GameOnException::GameNotFound);
        if (ratingDto.getRating() > 5 || ratingDto.getRating() < 1) {
            throw GameOnException.badRequest("InvalidRating", "Rating must be an integer between 1 and 5.");
        }
        rating.setUser(user);
        rating.setGame(game);
        rating = ratingRepository.save(rating);
        return ratingMapper.toDto(rating);
    }

    @Override
    public void deleteRating(Integer ratingId) {
        ratingRepository.deleteById(ratingId);
    }
}
