package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.*;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.DeveloperRepository;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.PublisherRepository;
import com.nonIt.GameOn.repository.RatingRepository;
import com.nonIt.GameOn.rest.resourcesdto.*;
import com.nonIt.GameOn.security.jwt.JwtUtils;
import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.customDto.GameLibraryDto;
import com.nonIt.GameOn.service.customDto.GameSearchDto;
import com.nonIt.GameOn.service.createdto.GameDto;
import com.nonIt.GameOn.service.customDto.GameWithUsedGameCodeListDto;
import com.nonIt.GameOn.service.mapper.*;
import com.nonIt.GameOn.repository.*;
import com.nonIt.GameOn.service.restdto.GameRestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    @Autowired
    private final JwtUtils jwtUtils;
    private final GameRepository gameRepository;
    private final DeveloperRepository developerRepository;
    private final PublisherRepository publisherRepository;
    private final GameCodeRepository gameCodeRepository;
    private final RatingRepository ratingRepository;
    private final ReceiptDetailsRepository receiptDetailsRepository;
    private final GameMapper gameMapper;
    private final RatingMapper ratingMapper;
    private final CommentMapper commentMapper;
    private final UserRepository userRepository;
    private final GameImageMapper gameImageMapper;
    private final GameSubGenreMapper gameSubGenreMapper;
    private final GameGenreMapper gameGenreMapper;

    //CRUD Services
    @Override
    public List<SimplifiedGameDto> getAll() {
//        return gameRepository.findAllByOrderByIdAsc().stream().map(gameMapper::toSimplifiedDto).collect(Collectors.toList());
        List<Game> gameList = gameRepository.findAllByOrderByIdAsc();
        List<SimplifiedGameDto> simplifiedGameDtoList = new ArrayList<>();
        for (Game game : gameList) {
            simplifiedGameDtoList.add(convertGameEntityToSimplifiedDto(game));
        }
        return simplifiedGameDtoList;
    }

    @Override
    public SimplifiedGameDto createGame(GameDto gameDto) {
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

        return convertGameEntityToSimplifiedDto(game);
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

        if (gameDto.getDeveloperId() != null) {
            Developer developer = developerRepository.findById(gameDto.getDeveloperId()).orElseThrow(GameOnException::DeveloperNotFound);
            game.setDeveloper(developer);
        }

        if (gameDto.getPublisherId() != null) {
            Publisher publisher = publisherRepository.findById(gameDto.getPublisherId()).orElseThrow(GameOnException::PublisherNotFound);
            game.setPublisher(publisher);
        }

        gameMapper.mapFromDto(gameDto, game);
        game = gameRepository.save(game);
        return gameMapper.toDto(game);
    }

    @Override
    public void deleteGame(Integer gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameOnException::GameNotFound);
        gameRepository.deleteById(gameId);
    }

    // Find featured games
    @Override
    public List<SimplifiedGameDto> getFeaturedGame() {
        return gameRepository.findByReleasedDateBetween(LocalDate.now().minusMonths(6), LocalDate.now()).stream().map(gameMapper::toSimplifiedDto).collect(Collectors.toList());
    }

    @Override
    public List<GameWithUsedGameCodeListDto> getRecentBestSellerGames() {
        List<SimplifiedGameDto> recentSoldGames = receiptDetailsRepository.findByReceiptReceiptDateBetween(LocalDate.now().minusYears(2), LocalDate.now())
                .stream()
                .map(ReceiptDetails::getGameCode)
                .map(GameCode::getGame)
                .map(this::convertGameEntityToSimplifiedDto)
                .collect(Collectors.toList());
        Map<SimplifiedGameDto, Long> gamesWithUsedGameCodeList = new HashMap<>();
        for (SimplifiedGameDto simplifiedGameDto : recentSoldGames) {
            gamesWithUsedGameCodeList.put(simplifiedGameDto, 0L);
        }

        for (Map.Entry<SimplifiedGameDto, Long> entry : gamesWithUsedGameCodeList.entrySet()) {
            SimplifiedGameDto key = entry.getKey();
            Long value = entry.getValue();

            for (SimplifiedGameDto simplifiedGameDto : recentSoldGames) {
                if (simplifiedGameDto.getId().equals(key.getId())) {
                    value++;
                    entry.setValue(value);
                }
            }
        }
        return gamesWithUsedGameCodeList.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<SimplifiedGameDto, Long>::getValue).reversed())
                .limit(5)
                .map(entry -> new GameWithUsedGameCodeListDto(entry.getKey(), entry.getValue().intValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWithUsedGameCodeListDto> getRecentWorstSellerGames() {
        List<SimplifiedGameDto> recentSoldGames = receiptDetailsRepository.findByReceiptReceiptDateBetween(LocalDate.now().minusYears(2), LocalDate.now())
                .stream()
                .map(ReceiptDetails::getGameCode)
                .map(GameCode::getGame)
                .map(this::convertGameEntityToSimplifiedDto)
                .collect(Collectors.toList());
        Map<SimplifiedGameDto, Long> gamesWithUsedGameCodeList = new HashMap<>();
        for (SimplifiedGameDto simplifiedGameDto : recentSoldGames) {
            gamesWithUsedGameCodeList.put(simplifiedGameDto, 0L);
        }

        for (Map.Entry<SimplifiedGameDto, Long> entry : gamesWithUsedGameCodeList.entrySet()) {
            SimplifiedGameDto key = entry.getKey();
            Long value = entry.getValue();

            for (SimplifiedGameDto simplifiedGameDto : recentSoldGames) {
                if (simplifiedGameDto.getId().equals(key.getId())) {
                    value++;
                    entry.setValue(value);
                }
            }
        }
        return gamesWithUsedGameCodeList.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<SimplifiedGameDto, Long>::getValue))
                .limit(5)
                .map(entry -> new GameWithUsedGameCodeListDto(entry.getKey(), entry.getValue().intValue()))
                .collect(Collectors.toList());
    }

    // Find best-seller games between period
//    @Override
//    public List<GameRestDto> getBestSellerGamesBetweenAPeriod() {
//        return gameRepository.findByReleasedDateBetween(LocalDate.now().minusMonths(6), LocalDate.now()).stream()
//                .filter(g -> g.getRatingList().stream().map(rating -> rating.getRating()).anyMatch(g.getRatingList().stream().filter(rating -> rating.getRating() >= 4)))
//                .map(gameMapper::toDto)
//                .collect(Collectors.toList());
//    }

    //Find by name
    @Override
    public List<GameRestDto> findByNameIgnoreCaseContaining(String name) {
        log.info("Search for a game that name contains {}", name);
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }
        return gameRepository.findByNameIgnoreCaseContaining(name).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by name and released date
    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfter(String name, LocalDate date) {
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }
        if (date.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateAfter(name, date).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBefore(String name, LocalDate date) {
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }
        if (date.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBefore(name, date).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetween(String name, LocalDate date1, LocalDate date2) {
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }
        if (date1.isAfter(LocalDate.now()) || date2.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }

        if (date1.isAfter(date2)) {
            throw GameOnException.badRequest("InvalidComparingDates", "Begin date cannot be after end date.");
        }
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBetween(name, date1, date2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by name and released date and system req
    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContaining(String name, LocalDate date, String req) {
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }
        if (date.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }
        if (req == null || req.trim().isBlank() || req.isEmpty()) {
            throw GameOnException.badRequest("SystemRequirementNotFound", "System requirement search input is missing");
        }
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContaining(name, date, req).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContaining(String name, LocalDate date, String req) {
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }
        if (date.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }
        if (req == null || req.trim().isBlank() || req.isEmpty()) {
            throw GameOnException.badRequest("SystemRequirementNotFound", "System requirement search input is missing");
        }
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContaining(name, date, req).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContaining(String name, LocalDate date1, LocalDate date2, String req) {
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }

        if (date1.isAfter(LocalDate.now()) || date2.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }

        if (date1.isAfter(date2)) {
            throw GameOnException.badRequest("InvalidComparingDates", "Begin date cannot be after end date.");
        }

        if (req == null || req.trim().isBlank() || req.isEmpty()) {
            throw GameOnException.badRequest("SystemRequirementNotFound", "System requirement search input is missing");
        }
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContaining(name, date1, date2, req).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by name and released date and system req and price
    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String name, LocalDate date, String req, Double price) {
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }

        if (date.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }

        if (req == null || req.trim().isBlank() || req.isEmpty()) {
            throw GameOnException.badRequest("SystemRequirementNotFound", "System requirement search input is missing.");
        }

        if (price < 0) {
            throw GameOnException.badRequest("InvalidPriceNumber", "Price searching input must be a positive number.");
        }
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(name, date, req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String name, LocalDate date, String req, Double price) {
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }

        if (date.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }

        if (req == null || req.trim().isBlank() || req.isEmpty()) {
            throw GameOnException.badRequest("SystemRequirementNotFound", "System requirement search input is missing.");
        }

        if (price < 0) {
            throw GameOnException.badRequest("InvalidPriceNumber", "Price searching input must be a positive number.");
        }
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(name, date, req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(String name, LocalDate date, String req, Double price1, Double price2) {
        if (name == null || name.trim().isBlank() || name.isEmpty()) {
            throw GameOnException.badRequest("GameNameNotFound", "Game's name search input is missing");
        }

        if (date.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReleasedDate", "Released date cannot be after current date.");
        }

        if (req == null || req.trim().isBlank() || req.isEmpty()) {
            throw GameOnException.badRequest("SystemRequirementNotFound", "System requirement search input is missing.");
        }

        if (price1 < 0 || price2 < 0) {
            throw GameOnException.badRequest("InvalidPriceNumbers", "Price searching inputs must be a positive number.");
        }

        if (price1 > price2) {
            throw GameOnException.badRequest("InvalidPriceNumbers", "Starting price must be smaller than ending price.");
        }
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(name, date, req, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, LocalDate date, String req, Double price) {
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(gameName, date, req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, LocalDate date, String req, Double price) {
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(gameName, date, req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, LocalDate date, String req, Double price1, Double price2) {
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(gameName, date, req, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, LocalDate date1, LocalDate date2, String req, Double price) {
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(gameName, date1, date2, req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, LocalDate date1, LocalDate date2, String req, Double price) {
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(gameName, date1, date2, req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, LocalDate date1, LocalDate date2, String req, Double price1, double price2) {
        return gameRepository.findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(gameName, date1, date2, req, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by name and system req
    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContaining(String name, String req) {
        return gameRepository.findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContaining(name, req).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by name and system req and price
    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String name, String req, Double price) {
        return gameRepository.findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(name, req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String name, String req, Double price) {
        return gameRepository.findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(name, req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceBetween(String name, String req, Double price1, Double price2) {
        return gameRepository.findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceBetween(name, req, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by name and price
    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndPriceLessThanEqual(String name, Double price) {
        return gameRepository.findByNameIgnoreCaseContainingAndPriceLessThanEqual(name, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndPriceGreaterThanEqual(String name, Double price) {
        return gameRepository.findByNameIgnoreCaseContainingAndPriceGreaterThanEqual(name, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameIgnoreCaseContainingAndPriceBetween(String name, Double price1, Double price2) {
        return gameRepository.findByNameIgnoreCaseContainingAndPriceBetween(name, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameContainingAndDeveloperNameContaining(String gameName, String developerName) {
        return gameRepository.findByNameContainingAndDeveloperNameContaining(gameName, developerName).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByNameContainingAndPublisherNameContaining(String gameName, String publisherName) {
        return gameRepository.findByNameContainingAndDeveloperNameContaining(gameName, publisherName).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by released date
    @Override
    public List<GameRestDto> findByReleasedDateAfter(LocalDate date) {
        return gameRepository.findByReleasedDateAfter(date).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBefore(LocalDate date) {
        return gameRepository.findByReleasedDateBefore(date).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBetween(LocalDate date1, LocalDate date2) {
        return gameRepository.findByReleasedDateBetween(date1, date2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by released date and system req
    @Override
    public List<GameRestDto> findByReleasedDateAfterAndSystemReqIgnoreCaseContaining(LocalDate date, String systemReq) {
        return gameRepository.findByReleasedDateAfterAndSystemReqIgnoreCaseContaining(date, systemReq).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBeforeAndSystemReqIgnoreCaseContaining(LocalDate date, String systemReq) {
        return gameRepository.findByReleasedDateBeforeAndSystemReqIgnoreCaseContaining(date, systemReq).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBetweenAndSystemReqIgnoreCaseContaining(LocalDate date1, LocalDate date2, String systemReq) {
        return gameRepository.findByReleasedDateBetweenAndSystemReqIgnoreCaseContaining(date1, date2, systemReq).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by released date and system req and price
    @Override
    public List<GameRestDto> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(LocalDate date, String systemReq, Double price) {
        return gameRepository.findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(date, systemReq, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(LocalDate date, String systemReq, Double price) {
        return gameRepository.findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(date, systemReq, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(LocalDate date, String systemReq, Double price1, Double price2) {
        return gameRepository.findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(date, systemReq, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(LocalDate date, String systemReq, Double price) {
        return gameRepository.findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(date, systemReq, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(LocalDate date, String systemReq, Double price) {
        return gameRepository.findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(date, systemReq, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(LocalDate date, String systemReq, Double price1, Double price2) {
        return gameRepository.findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(date, systemReq, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(LocalDate date1, LocalDate date2, String systemReq, Double price) {
        return gameRepository.findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(date1, date2, systemReq, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(LocalDate date1, LocalDate date2, String systemReq, Double price) {
        return gameRepository.findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(date1, date2, systemReq, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(LocalDate date1, LocalDate date2, String systemReq, Double price1, Double price2) {
        return gameRepository.findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(date1, date2, systemReq, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by released date and price
    @Override
    public List<GameRestDto> findByReleasedDateAfterAndPriceLessThanEqual(LocalDate date, Double price) {
        return gameRepository.findByReleasedDateAfterAndPriceLessThanEqual(date, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateAfterAndPriceGreaterThanEqual(LocalDate date, Double price) {
        return gameRepository.findByReleasedDateAfterAndPriceGreaterThanEqual(date, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateAfterAndPriceBetween(LocalDate date, Double price1, Double price2) {
        return gameRepository.findByReleasedDateAfterAndPriceBetween(date, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBeforeAndPriceLessThanEqual(LocalDate date, Double price) {
        return gameRepository.findByReleasedDateBeforeAndPriceLessThanEqual(date, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBeforeAndPriceGreaterThanEqual(LocalDate date, Double price) {
        return gameRepository.findByReleasedDateBeforeAndPriceGreaterThanEqual(date, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBeforeAndPriceBetween(LocalDate date, Double price1, Double price2) {
        return gameRepository.findByReleasedDateBeforeAndPriceBetween(date, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBetweenAndPriceLessThanEqual(LocalDate date1, LocalDate date2, Double price) {
        return gameRepository.findByReleasedDateBetweenAndPriceLessThanEqual(date1, date2, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBetweenAndPriceGreaterThanEqual(LocalDate date1, LocalDate date2, Double price) {
        return gameRepository.findByReleasedDateBetweenAndPriceGreaterThanEqual(date1, date2, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByReleasedDateBetweenAndPriceBetween(LocalDate date1, LocalDate date2, Double price1, Double price2) {
        return gameRepository.findByReleasedDateBetweenAndPriceBetween(date1, date2, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by system req
    @Override
    public List<GameRestDto> findBySystemReqIgnoreCaseContaining(String req) {
        return gameRepository.findBySystemReqIgnoreCaseContaining(req).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


//    @Override
//    public List<GameRestDto> getBySystemReqIgnoreCaseContainingAndPriceLessThanEqual(String req, Double price) {
//        return null;
//    }


    //Find by system req and price
    @Override
    public List<GameRestDto> findBySystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String req, Double price) {
        return gameRepository.findBySystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findBySystemReqIgnoreCaseContainingAndPriceLessThanEqual(String req, Double price) {
        return gameRepository.findBySystemReqIgnoreCaseContainingAndPriceLessThanEqual(req, price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findBySystemReqIgnoreCaseContainingAndPriceBetween(String req, Double price1, Double price2) {
        return gameRepository.findBySystemReqIgnoreCaseContainingAndPriceBetween(req, price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }


    //Find by price
    @Override
    public List<GameRestDto> findByPriceGreaterThan(Double price) {
        return gameRepository.findByPriceGreaterThan(price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByPriceLessThan(Double price) {
        return gameRepository.findByPriceLessThan(price).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> findByPriceBetween(Double price1, Double price2) {
        return gameRepository.findByPriceBetween(price1, price2).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    //Find by foreign keys
    @Override
    public List<GameRestDto> getByDeveloperId(Integer developerId) {
        return gameRepository.getByDeveloperId(developerId).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<GameRestDto> getByPublisherId(Integer publisherId) {
        return gameRepository.getByPublisherId(publisherId).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    //    @Override
//    public List<GameRestDto> getByUserId(Integer userId) {
//        return gameRepository.getByUserId(userId).stream().map(gameMapper::toDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<GameRestDto> getByUsername(String username) {
//        return gameRepository.getByUsername(username).stream().map(gameMapper::toDto).collect(Collectors.toList());
//    }
    @Override
    public List<GameLibraryDto> getByUser(String authorization) {
        System.out.println(authorization);
        User user = userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(authorization)).orElseThrow(GameOnException::UserNotFound);

        List<GameLibraryDto> gameLibraryDtos = gameRepository.getByUserId(user.getId());

        return gameLibraryDtos;
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
    public SimplifiedGameDto findById(Integer gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(GameOnException::GameNotFound);
        return convertGameEntityToSimplifiedDto(game);
    }


    //Custom queries
    @Override
    public List<GameRestDto> getByRatingAndReleasedDateBetween(Integer rating1, Integer rating2, LocalDate date1, LocalDate date2) {
        return ratingRepository.findAll().stream()
                .filter(r -> r.getRating() > rating1)
                .filter(r -> r.getRating() < rating2)
                .map(Rating::getGame)
                .filter(game -> game.getReleasedDate().isAfter(date1))
                .filter(game -> game.getReleasedDate().isBefore(date2))
                .distinct()
                .map(gameMapper::toDto)
                .collect(Collectors.toList());
    }


    //TEST ADVANCED SEARCH
    public List<GameRestDto> getGamesByGameSearchDto(GameSearchDto gameSearchDto) {
        if (gameSearchDto == null) {
            throw GameOnException.badRequest("MissingSearchCriteria", "Search criteria not found.");
        }
        return gameRepository.findGamesByDto(gameSearchDto).stream().map(gameMapper::toDto).collect(Collectors.toList());
    }

    public Integer getUsedGameCodeListOfGame(Integer gameId) {
        return (Integer) (int) gameCodeRepository.findAll().stream()
                .filter(gameCode -> gameId.equals(gameCode.getGame().getId()))
                .filter(gameCode -> gameCode.getGameCodeStatus().equals(GameCodeStatus.Used)).count();
    }

    public SimplifiedGameDto convertGameEntityToSimplifiedDto(Game game) {

        SimplifiedGameDto simplifiedGameDto = gameMapper.toSimplifiedDto(game);
        List<SimplifiedCommentDto> simplifiedCommentDtoList = game.getCommentList().stream()
                .map(commentMapper::toSimplifiedDto)
                .collect(Collectors.toList());

        List<SimplifiedRatingDto> simplifiedRatingDtoList = game.getRatingList().stream()
                .map(ratingMapper::toSimplifiedDto)
                .collect(Collectors.toList());

        List<SimplifiedGameImageDto> simplifiedGameImageDtoList = game.getGameImageList().stream()
                .map(gameImageMapper::toSimplifiedDto)
                .collect(Collectors.toList());

        List<SimplifiedGameGenreDto> simplifiedGameGenreDtoList = game.getGameGenreList().stream()
                .map(gameGenreMapper::toSimplifiedDto)
                .collect(Collectors.toList());

        List<SimplifiedGameSubGenreDto> simplifiedGameSubGenreDtoList = game.getGameSubGenreList().stream()
                .map(gameSubGenreMapper::toSimplifiedDto)
                .collect(Collectors.toList());


        simplifiedGameDto.setSimplifiedCommentDtoList(simplifiedCommentDtoList);
        simplifiedGameDto.setSimplifiedRatingDtoList(simplifiedRatingDtoList);
        simplifiedGameDto.setSimplifiedGameGenreDtoList(simplifiedGameGenreDtoList);
        simplifiedGameDto.setSimplifiedGameSubGenreDtoList(simplifiedGameSubGenreDtoList);
        simplifiedGameDto.setSimplifiedGameImageDtoList(simplifiedGameImageDtoList);
        return simplifiedGameDto;
    }
}
