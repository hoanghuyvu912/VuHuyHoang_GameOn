package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.dto.GameDto;
import com.nonIt.GameOn.service.dto.UserDto;
import com.nonIt.GameOn.service.restDto.GameRestDto;
//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/games")
public class GameResources {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameRestDto>> getAllGame() {
        return ResponseEntity.ok(gameService.getAll());
    }

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
