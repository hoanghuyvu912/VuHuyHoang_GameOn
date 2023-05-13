package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.SubGenreService;
import com.nonIt.GameOn.service.dto.SubGenreDto;
import com.nonIt.GameOn.service.restDto.SubGenreRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sub_genres")
public class SubGenreResources {
    private final SubGenreService subGenreService;

    @GetMapping
    public ResponseEntity<List<SubGenreRestDto>> getAllSubGenre() {
        return ResponseEntity.ok(subGenreService.getAll());
    }

    @GetMapping(value = "/{subGenreId}")
    public ResponseEntity<SubGenreRestDto> getSubGenreById(@PathVariable("subGenreId") Integer subGenreId) {
        return ResponseEntity.ok(subGenreService.findById(subGenreId));
    }

    @PostMapping
    public ResponseEntity<SubGenreRestDto> createSubGenre(@RequestBody SubGenreDto subGenreDto) {
        return ResponseEntity.ok(subGenreService.createSubGenre(subGenreDto));
    }

    @PutMapping(value = "/{subGenreId}")
    public ResponseEntity<SubGenreRestDto> updateSubGenreById(@PathVariable("subGenreId") Integer subGenreId, @RequestBody SubGenreDto subGenreDto) {
        return ResponseEntity.ok(subGenreService.updateSubGenre(subGenreId, subGenreDto));
    }

    @DeleteMapping(value = "/{subGenreId}")
    public ResponseEntity<Void> deleteSubGenreById(@PathVariable("subGenreId") Integer subGenreId) {
        subGenreService.deleteSubGenre(subGenreId);
        return ResponseEntity.noContent().build();
    }
}
