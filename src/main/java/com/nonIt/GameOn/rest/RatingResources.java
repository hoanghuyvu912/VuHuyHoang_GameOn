package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.RatingService;
import com.nonIt.GameOn.service.dto.RatingDto;
import com.nonIt.GameOn.service.restDto.RatingRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")
public class RatingResources {
    private final RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<RatingRestDto>> getAllRating() {
        return ResponseEntity.ok(ratingService.getAll());
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingRestDto> getRatingById(@PathVariable("ratingId") Integer ratingId) {
        return ResponseEntity.ok(ratingService.findById(ratingId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<RatingRestDto> createRating(@RequestBody RatingDto ratingDto) {
        return ResponseEntity.ok(ratingService.createRating(ratingDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{ratingId}")
    public ResponseEntity<RatingRestDto> updateRatingById(@PathVariable("ratingId") Integer ratingId, @RequestBody RatingDto ratingDto) {
        return ResponseEntity.ok(ratingService.updateRating(ratingId, ratingDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{ratingId}")
    public ResponseEntity<Void> deleteRatingById(@PathVariable("ratingId") Integer ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.noContent().build();
    }
}
