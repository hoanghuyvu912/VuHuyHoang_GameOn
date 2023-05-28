package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.restDto.GameRestDto;
//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/games")
public class GameResources {
    private final GameService gameService;


    //Find by name
    @GetMapping(value = "/name-containing")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContaining(@RequestParam("name") String name) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContaining(name));
    }


    //Find by name and released date
    @GetMapping(value = "/name-containing-released-date-after")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateAfter(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateAfter(name, date));
    }

    @GetMapping(value = "/name-containing-released-date-before")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBefore(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBefore(name, date));
    }

    @GetMapping(value = "/name-containing-released-date-between")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBetween(@RequestParam("name") String name, @RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBetween(name, date1, date2));
    }


    //Find by name and released date and req
    @GetMapping(value = "/name-containing-released-date-after-req")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateAfterAndReqContaining(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContaining(name, date, req));
    }

    @GetMapping(value = "/name-containing-released-date-before-req")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBefore(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContaining(name, date, req));
    }

    @GetMapping(value = "/name-containing-released-date-between-req")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBetween(@RequestParam("name") String name, @RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2, @RequestParam("req") String req) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContaining(name, date1, date2, req));
    }


    //Find by name and released date and req and price
    @GetMapping(value = "/name-containing-released-date-after-req-price-less-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateAfterAndReqIgnoreCaseContainingAndPriceLessThanEqual(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(name, date, req, price));
    }

    @GetMapping(value = "/name-containing-released-date-after-req-price-greater-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateAfterAndReqIgnoreCaseContainingAndPriceGreaterThanEqual(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(name, date, req, price));
    }

    @GetMapping(value = "/name-containing-released-date-after-req-price-between")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateAfterAndReqIgnoreCaseContainingAndPriceBetween(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price1") Double price1, @RequestParam("price2") Double price2) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(name, date, req, price1, price2));
    }

    @GetMapping(value = "/name-containing-released-date-before-req-price-less-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndReqIgnoreCaseContainingAndPriceLessThanEqual(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(name, date, req, price));
    }

    @GetMapping(value = "/name-containing-released-date-before-req-price-greater-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndReqIgnoreCaseContainingAndPriceGreaterThanEqual(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(name, date, req, price));
    }

    @GetMapping(value = "/name-containing-released-date-before-req-price-between")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndReqIgnoreCaseContainingAndPriceBetween(@RequestParam("name") String name, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price1") Double price1, @RequestParam("price2") Double price2) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(name, date, req, price1, price2));
    }

    @GetMapping(value = "/name-containing-released-date-between-req-price-less-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndReqIgnoreCaseContainingAndPriceLessThanEqual(@RequestParam("name") String name, @RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(name, date1, date2, req, price));
    }

    @GetMapping(value = "/name-containing-released-date-between-req-price-greater-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndReqIgnoreCaseContainingAndPriceGreaterThanEqual(@RequestParam("name") String name, @RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(name, date1, date2, req, price));
    }

    @GetMapping(value = "/name-containing-released-date-between-req-price-between")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndReqIgnoreCaseContainingAndPriceBetween(@RequestParam("name") String name, @RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2, @RequestParam("req") String req, @RequestParam("price1") Double price1, @RequestParam("price2") Double price2) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(name, date1, date2, req, price1, price2));
    }


    //Find by name and req
    @GetMapping(value = "/name-containing-req-containing")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContaining(@RequestParam("name") String name, @RequestParam("req") String req) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContaining(name, req));
    }


    //Find by name and req and price
    @GetMapping(value = "/name-containing-req-containing-price-less-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(@RequestParam("name") String name, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(name, req, price));
    }

    @GetMapping(value = "/name-containing-req-containing-price-greater-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(@RequestParam("name") String name, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(name, req, price));
    }

    @GetMapping(value = "/name-containing-req-containing-price-between")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceBetween(@RequestParam("name") String name, @RequestParam("req") String req, @RequestParam("price1") Double price1, @RequestParam("price2") Double price2) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceBetween(name, req, price1, price2));
    }


    //Find by name and price
    @GetMapping(value = "/name-containing-price-less-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseAndPriceLessThanEqual(@RequestParam("name") String name, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndPriceLessThanEqual(name, price));
    }

    @GetMapping(value = "/name-containing-price-greater-equal")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseAndPriceGreaterThanEqual(@RequestParam("name") String name, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndPriceGreaterThanEqual(name, price));
    }

    @GetMapping(value = "/name-containing-price-between")
    public ResponseEntity<List<GameRestDto>> findByNameIgnoreCaseAndPriceBetween(@RequestParam("name") String name, @RequestParam("price1") Double price1, @RequestParam("price2") Double price2) {
        return ResponseEntity.ok(gameService.findByNameIgnoreCaseContainingAndPriceBetween(name, price1, price2));
    }


    //Find by released date
    @GetMapping(value = "/released-date-after")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateAfter(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(gameService.findByReleasedDateAfter(date));
    }

    @GetMapping(value = "/released-date-before")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateBefore(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(gameService.findByReleasedDateBefore(date));
    }

    @GetMapping(value = "/released-date-between")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateBetween(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2) {
        return ResponseEntity.ok(gameService.findByReleasedDateBetween(date1, date2));
    }


    //Find by released date and system req
    @GetMapping(value = "/released-date-after-req")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateAfterAndSystemReqIgnoreCaseContaining(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req) {
        return ResponseEntity.ok(gameService.findByReleasedDateAfterAndSystemReqIgnoreCaseContaining(date, req));
    }

    @GetMapping(value = "/released-date-before-req")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateBeforeAndSystemReqIgnoreCaseContaining(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req) {
        return ResponseEntity.ok(gameService.findByReleasedDateBeforeAndSystemReqIgnoreCaseContaining(date, req));
    }

    @GetMapping(value = "/released-date-between-req")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateBetweenAndSystemReqIgnoreCaseContaining(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2, @RequestParam("req") String req) {
        return ResponseEntity.ok(gameService.findByReleasedDateBetweenAndSystemReqIgnoreCaseContaining(date1, date2, req));
    }


    //Find by released date and system req and price
    @GetMapping(value = "/released-date-after-req-price-less-equal")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(date, req, price));
    }

    @GetMapping(value = "/released-date-after-req-price-greater-equal")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(date, req, price));
    }

    @GetMapping(value = "/released-date-after-req-price-between")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price1") Double price1, @RequestParam("price2") Double price2) {
        return ResponseEntity.ok(gameService.findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(date, req, price1, price2));
    }

    @GetMapping(value = "/released-date-before-req-price-less-equal")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(date, req, price));
    }

    @GetMapping(value = "/released-date-before-req-price-greater-equal")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(date, req, price));
    }

    @GetMapping(value = "/released-date-before-req-price-between")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam("req") String req, @RequestParam("price1") Double price1, @RequestParam("price2") Double price2) {
        return ResponseEntity.ok(gameService.findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(date, req, price1, price2));
    }

    @GetMapping(value = "/released-date-between-req-price-less-equal")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(date1, date2, req, price));
    }

    @GetMapping(value = "/released-date-between-req-price-greater-equal")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2, @RequestParam("req") String req, @RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(date1, date2, req, price));
    }

    @GetMapping(value = "/released-date-between-req-price-between")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(@RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2, @RequestParam("req") String req, @RequestParam("price1") Double price1, @RequestParam("price2") Double price2) {
        return ResponseEntity.ok(gameService.findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(date1, date2, req, price1, price2));
    }


    @GetMapping(value = "/price-greater-than")
    public ResponseEntity<List<GameRestDto>> findByPriceGreaterThan(@RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByPriceGreaterThan(price));
    }

    @GetMapping(value = "/price-less-than")
    public ResponseEntity<List<GameRestDto>> findByPriceLessThan(@RequestParam("price") Double price) {
        return ResponseEntity.ok(gameService.findByPriceLessThan(price));
    }


    @GetMapping(value = "/by-developer-id")
    public ResponseEntity<List<GameRestDto>> getByDeveloperId(@RequestParam("developerId") Integer developerId) {
        return ResponseEntity.ok(gameService.getByDeveloperId(developerId));
    }

    @GetMapping(value = "/by-publisher-id")
    public ResponseEntity<List<GameRestDto>> getByPublisherId(@RequestParam("publisherId") Integer publisherId) {
        return ResponseEntity.ok(gameService.getByPublisherId(publisherId));
    }

    @GetMapping(value = "/by-user-id")
    public ResponseEntity<List<GameRestDto>> getByUserId(@RequestParam("userId") Integer userId) {
        return ResponseEntity.ok(gameService.getByUserId(userId));
    }

    @GetMapping(value = "/by-username")
    public ResponseEntity<List<GameRestDto>> getByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok(gameService.getByUsername("%" + username + "%"));
    }

    @GetMapping(value = "/by-genre-id")
    public ResponseEntity<List<GameRestDto>> getByGenreId(@RequestParam("genreId") Integer genreId) {
        return ResponseEntity.ok(gameService.getByGenreId(genreId));
    }

    @GetMapping(value = "/by-genre-name")
    public ResponseEntity<List<GameRestDto>> getByGenreName(@RequestParam("genreName") String genreName) {
        return ResponseEntity.ok(gameService.getByGenreName("%" + genreName + "%"));
    }

    @GetMapping(value = "/by-sub-genre-id")
    public ResponseEntity<List<GameRestDto>> getBySubGenreId(@RequestParam("subGenreId") Integer subGenreId) {
        return ResponseEntity.ok(gameService.getBySubGenreId(subGenreId));
    }

    @GetMapping(value = "/by-sub-genre-name")
    public ResponseEntity<List<GameRestDto>> getBySubGenreName(@RequestParam("subGenreName") String subGenreName) {
        return ResponseEntity.ok(gameService.getBySubGenreName("%" + subGenreName + "%"));
    }

//    @GetMapping(value = "/by-rating-and-released-date-between")
//    public ResponseEntity<List<GameRestDto>> getByRatingAndReleasedDateBetween(@RequestParam("rating1") Integer rating1, @RequestParam("rating2") Integer rating2, @RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1, @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2) {
//        return ResponseEntity.ok(gameService.getByRatingAndReleasedDateBetween(rating1, rating2, date1, date2));
//    }


    //CRUD APIs
    @GetMapping
    public ResponseEntity<List<GameRestDto>> getAllGame() {
        return ResponseEntity.ok(gameService.getAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<GameRestDto> createGame(@Valid @RequestBody GameDto gameDto) {
        return ResponseEntity.ok(gameService.createGame(gameDto));
    }

    @GetMapping(value = "/{gameId}")
    public ResponseEntity<GameRestDto> getGameById(@PathVariable("gameId") Integer userId) {
        return ResponseEntity.ok(gameService.findById(userId));
    }

    @PutMapping(value = "/{gameId}")
    public ResponseEntity<GameRestDto> updateGameById(@PathVariable("gameId") Integer gameId, @RequestBody GameDto gameDto) {
        return ResponseEntity.ok(gameService.updateGame(gameId, gameDto));
    }

    @DeleteMapping(value = "/{gameId}")
    public ResponseEntity<Void> deleteGameById(@PathVariable("gameId") Integer gameId) {
        gameService.deleteGame(gameId);
        return ResponseEntity.noContent().build();
    }
}
