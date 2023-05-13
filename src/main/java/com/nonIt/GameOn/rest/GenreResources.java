package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.GenreService;
import com.nonIt.GameOn.service.dto.GenreDto;
import com.nonIt.GameOn.service.restDto.GenreRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/genres")
public class GenreResources {
    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreRestDto>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAll());
    }

    @GetMapping(value = "/{genreId}")
    public ResponseEntity<GenreRestDto> getGenreById(@PathVariable("genreId") Integer genreId) {
        return ResponseEntity.ok(genreService.findById(genreId));
    }

    @PostMapping
    public ResponseEntity<GenreRestDto> createGenre(@RequestBody GenreDto genreDto) {
        return ResponseEntity.ok(genreService.createGenre(genreDto));
    }

    @PutMapping(value = "/{genreId}")
    public ResponseEntity<GenreRestDto> updateGenreById(@PathVariable("genreId") Integer genreId, @RequestBody GenreDto genreDto) {
        return ResponseEntity.ok(genreService.updateGenre(genreId, genreDto));
    }

    @DeleteMapping(value = "/{genreId}")
    public ResponseEntity<Void> deleteGenreById(@PathVariable("genreId") Integer genreId) {
        genreService.deleteGenre(genreId);
        return ResponseEntity.noContent().build();
    }
}
