package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.GameCodeService;
import com.nonIt.GameOn.service.dto.GameCodeDto;
import com.nonIt.GameOn.service.restDto.DeveloperRestDto;
import com.nonIt.GameOn.service.restDto.GameCodeRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<GameCodeRestDto> createGameCodeForGame(@RequestBody GameCodeDto gameCodeDto){
        return ResponseEntity.ok(gameCodeService.createGameCodeForGame(gameCodeDto));
    }

}
