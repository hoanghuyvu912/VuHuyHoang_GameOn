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


    @GetMapping(value = "/name-containing")
    public ResponseEntity<List<GameRestDto>> findByNameContaining(@RequestParam("name") String name) {
        return ResponseEntity.ok(gameService.findByNameContaining("%" + name + "%"));
    }

    @GetMapping(value = "/released-date-after")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateAfter(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(gameService.findByReleasedDateAfter(date));
    }

    @GetMapping(value = "/released-date-before")
    public ResponseEntity<List<GameRestDto>> findByReleasedDateBefore(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(gameService.findByReleasedDateBefore(date));
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
