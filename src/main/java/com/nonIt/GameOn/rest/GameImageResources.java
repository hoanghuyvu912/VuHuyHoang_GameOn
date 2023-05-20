package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.GameImageService;
import com.nonIt.GameOn.service.dto.GameImageDto;
import com.nonIt.GameOn.service.restDto.GameImageRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/game-images")
public class GameImageResources {
    private final GameImageService gameImageService;

    @GetMapping
    public ResponseEntity<List<GameImageRestDto>> getAllGameImage() {
        return ResponseEntity.ok(gameImageService.getAll());
    }

    @GetMapping(value = "/{gameImageId}")
    public ResponseEntity<GameImageRestDto> getGameImageById(@PathVariable("gameImageId") Integer gameImageId) {
        return ResponseEntity.ok(gameImageService.findById(gameImageId));
    }

    @PostMapping
    public ResponseEntity<GameImageRestDto> createGameImage(@RequestBody GameImageDto gameImageDto) {
        return ResponseEntity.ok(gameImageService.createGameImage(gameImageDto));
    }

    @PutMapping(value = "/{gameImageId}")
    public ResponseEntity<GameImageRestDto> updateGameImage(@PathVariable("gameImageId") Integer gameImageId, @RequestBody GameImageDto gameImageDto) {
        return ResponseEntity.ok(gameImageService.updateGameImage(gameImageId, gameImageDto));
    }

    @DeleteMapping(value = "/{gameImageId}")
    public ResponseEntity<Void> deleteGameImageById(@PathVariable("gameImageId") Integer gameImageId) {
        gameImageService.deleteGameImage(gameImageId);
        return ResponseEntity.noContent().build();
    }
}