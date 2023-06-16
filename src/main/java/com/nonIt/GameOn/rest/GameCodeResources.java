package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.entity.GameCodeStatus;
import com.nonIt.GameOn.service.GameCodeService;
import com.nonIt.GameOn.service.dto.GameCodeDto;
import com.nonIt.GameOn.service.restDto.DeveloperRestDto;
import com.nonIt.GameOn.service.restDto.GameCodeRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/gamecodes")
public class GameCodeResources {
    private final GameCodeService gameCodeService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<GameCodeRestDto>> getAllGameCodes() {
        return ResponseEntity.ok(gameCodeService.getAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<GameCodeRestDto> createGameCodeForGame(@RequestBody GameCodeDto gameCodeDto) {
        return ResponseEntity.ok(gameCodeService.createGameCodeForGame(gameCodeDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{gameCodeId}")
    public ResponseEntity<GameCodeRestDto> updateGameCode(@PathVariable("gameCodeId") Integer gameCodeId ,@RequestBody GameCodeDto gameCodeDto){
        return ResponseEntity.ok(gameCodeService.updateGameCode(gameCodeId,gameCodeDto));
    }

    @DeleteMapping("/{gameCodeId}")
    public ResponseEntity<Void> deleteGameCode(@PathVariable("gameCodeId") Integer gameCodeId){
        gameCodeService.deleteGameCode(gameCodeId);
        return ResponseEntity.noContent().build();
    }
}
