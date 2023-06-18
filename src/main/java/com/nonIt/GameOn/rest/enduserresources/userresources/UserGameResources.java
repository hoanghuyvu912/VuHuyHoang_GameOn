package com.nonIt.GameOn.rest.enduserresources.userresources;

import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedGameDto;
import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.customDto.GameSearchDto;
import com.nonIt.GameOn.service.restdto.GameRestDto;
import com.nonIt.GameOn.utils.NullChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class UserGameResources {
    private final GameService gameService;

    //Games
    @GetMapping
    public ResponseEntity<List<GameRestDto>> getAllGame() {
        return ResponseEntity.ok(gameService.getAll());
    }

    @GetMapping(value = "/{gameId}")
    public ResponseEntity<SimplifiedGameDto> getGameById(@PathVariable("gameId") Integer userId) {
        return ResponseEntity.ok(gameService.findById(userId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<GameRestDto>> searchByDto(@RequestBody GameSearchDto gameSearchDto) {
        boolean isGameSearchDtoNull = NullChecker.allNull(gameSearchDto);
        if (isGameSearchDtoNull) {
            throw GameOnException.badRequest("MissingSearchCriteria", "Search criteria not found.");
        }
        return ResponseEntity.ok(gameService.getGamesByGameSearchDto(gameSearchDto));
    }


}
