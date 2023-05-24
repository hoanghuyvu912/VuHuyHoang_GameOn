package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Publisher;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.DeveloperRepository;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.PublisherRepository;
import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.mapper.GameMapper;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final DeveloperRepository developerRepository;
    private final PublisherRepository publisherRepository;
    private final GameMapper gameMapper;

    @Override
    public List<GameRestDto> getAll() {
//        return gameMapper.toDtos(gameRepository.findAll());
        return gameRepository.findAll().stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameContaining(String name) {
        return gameRepository.findByNameContaining(name).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateAfter(LocalDate date) {
        return gameRepository.findByReleasedDateAfter(date).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBefore(LocalDate date) {
        return gameRepository.findByReleasedDateBefore(date).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByPriceGreaterThan(Double price) {
        return gameRepository.findByPriceGreaterThan(price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByPriceLessThan(Double price) {
        return gameRepository.findByPriceLessThan(price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> getByDeveloperId(Integer developerId) {
        return gameRepository.getByDeveloperId(developerId).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> getByPublisherId(Integer publisherId) {
        return gameRepository.getByPublisherId(publisherId).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> getByUserId(Integer userId) {
        return gameRepository.getByUserId(userId).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> getByUsername(String username) {
        return gameRepository.getByUsername(username).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> getByGenreId(Integer genreId) {
        return gameRepository.getByGenreId(genreId).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> getByGenreName(String genreName) {
        return gameRepository.getByGenreName(genreName).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> getBySubGenreId(Integer subGenreId) {
        return gameRepository.getBySubGenreId(subGenreId).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> getBySubGenreName(String subGenreName) {
        return gameRepository.getBySubGenreName(subGenreName).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public GameRestDto findById(Integer gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameOnException::GameNotFound);
        return gameMapper.toDto(game);
    }

    @Override
    public GameRestDto createGame(GameDto gameDto) {
        Developer developer = developerRepository.findById(gameDto.getDeveloperId()).orElseThrow(GameOnException::DeveloperNotFound);
        Publisher publisher = publisherRepository.findById(gameDto.getPublisherId()).orElseThrow(GameOnException::PublisherNotFound);

        if (gameDto.getName() == null || gameDto.getName().trim().isBlank() || gameDto.getName().isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name is missing");
        }
        if (gameDto.getThumbnail() == null || gameDto.getThumbnail().trim().isBlank() || gameDto.getThumbnail().isEmpty()) {
            throw GameOnException.badRequest("GameThumbnailNotFound", "Game's thumbnail is missing");
        }
        if (gameDto.getDescription() == null || gameDto.getDescription().trim().isBlank() || gameDto.getDescription().isEmpty()) {
            throw GameOnException.badRequest("GameDescriptionNotFound", "Game's description is missing");
        }
        if (gameDto.getTrailer() == null || gameDto.getTrailer().trim().isBlank() || gameDto.getTrailer().isEmpty()) {
            throw GameOnException.badRequest("GameTrailerNotFound", "Game's trailer is missing");
        }
        if (gameDto.getReleasedDate().isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }
        if (gameDto.getReleasedDate().isBefore(developer.getEstablishedDate())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be before developer's established date.");
        }
        if (gameDto.getReleasedDate().isBefore(publisher.getEstablishedDate())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be before publisher's established date.");
        }
        if (gameDto.getSystemReq() == null || gameDto.getSystemReq().trim().isBlank() || gameDto.getSystemReq().isEmpty()) {
            throw GameOnException.badRequest("GameSystemReqNotFound", "Game's system requirement is missing");
        }
        if (gameDto.getPrice() < 0) {
            throw GameOnException.badRequest("InvalidPrice", "Game's price must be a positive number.");
        }

        Game game = Game.builder()
                .name(gameDto.getName())
                .thumbnail(gameDto.getThumbnail())
                .description(gameDto.getDescription())
                .trailer(gameDto.getTrailer())
                .releasedDate(gameDto.getReleasedDate())
                .systemReq(gameDto.getSystemReq())
                .price(gameDto.getPrice())
                .developer(developer)
                .publisher(publisher)
                .build();

        game = gameRepository.save(game);
        return gameMapper.toDto(game);
    }

    @Override
    public GameRestDto updateGame(Integer gameId, GameDto gameDto) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameOnException::GameNotFound);

        if (gameDto.getName() != null) {
            if (gameDto.getName().trim().isBlank() || gameDto.getName().isEmpty()) {
                throw GameOnException.badRequest("GameNameNotFound", "Game's name is missing");
            }
        }
        if (gameDto.getThumbnail() != null) {
            if (gameDto.getThumbnail().trim().isBlank() || gameDto.getThumbnail().isEmpty()) {
                throw GameOnException.badRequest("GameThumbnailNotFound", "Game's thumbnail is missing");
            }
        }
        if (gameDto.getDescription() != null) {
            if (gameDto.getDescription().trim().isBlank() || gameDto.getDescription().isEmpty()) {
                throw GameOnException.badRequest("GameDescriptionNotFound", "Game's description is missing");
            }
        }
        if (gameDto.getTrailer() != null) {
            if (gameDto.getTrailer().trim().isBlank() || gameDto.getTrailer().isEmpty()) {
                throw GameOnException.badRequest("GameTrailerNotFound", "Game's trailer is missing");
            }
        }
        if (gameDto.getReleasedDate() != null) {
            if (gameDto.getReleasedDate().isAfter(LocalDate.now())) {
                throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
            }
            if (gameDto.getReleasedDate().isBefore(game.getDeveloper().getEstablishedDate())) {
                throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be before developer's established date.");
            }
            if (gameDto.getReleasedDate().isBefore(game.getPublisher().getEstablishedDate())) {
                throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be before publisher's established date.");
            }
        }
        if (gameDto.getSystemReq() != null) {
            if (gameDto.getSystemReq().trim().isBlank() || gameDto.getSystemReq().isEmpty()) {
                throw GameOnException.badRequest("GameSystemReqNotFound", "Game's system requirement is missing");
            }
        }
        if (gameDto.getPrice() != null) {
            if (gameDto.getPrice() < 0) {
                throw GameOnException.badRequest("InvalidPrice", "Game's price must be a positive number.");
            }
        }
        gameMapper.mapFromDto(gameDto, game);
        game = gameRepository.save(game);
        return gameMapper.toDto(game);
    }

//    @Override
//    public List<GameRestDto> getByRatingAndReleasedDateBetween() {
//        return gameRepository.getByRatingAndReleasedDateBetween().stream().map(gameMapper::toDto).collect(Collectors.toList());
//    }

    @Override
    public void deleteGame(Integer gameId) {
        gameRepository.deleteById(gameId);
    }
}
