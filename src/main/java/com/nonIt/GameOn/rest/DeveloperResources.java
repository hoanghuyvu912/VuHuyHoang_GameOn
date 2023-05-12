package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.DeveloperService;
import com.nonIt.GameOn.service.dto.DeveloperDto;
import com.nonIt.GameOn.service.restDto.DeveloperRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/developers")
public class DeveloperResources {
    private final DeveloperService developerService;

    @GetMapping
    public ResponseEntity<List<DeveloperRestDto>> getAllDeveloper() {
        return ResponseEntity.ok(developerService.getAll());
    }

    @GetMapping(value = "/{devId}")
    public ResponseEntity<DeveloperRestDto> getDeveloperById(@PathVariable("devId") Integer devId) {
        return ResponseEntity.ok(developerService.findById(devId));
    }

    @PostMapping
    public ResponseEntity<DeveloperRestDto> createDeveloper(@RequestBody DeveloperDto developerDto) {
        return ResponseEntity.ok(developerService.createDeveloper(developerDto));
    }

    @PutMapping(value = "/{devId}")
    public ResponseEntity<DeveloperRestDto> updateDeveloperById(@PathVariable("devId") Integer devId, @RequestBody DeveloperDto developerDto) {
        return ResponseEntity.ok(developerService.updateDeveloper(devId, developerDto));
    }

    @DeleteMapping(value = "/{devId}")
    public ResponseEntity<Void> deleteDeveloperById(@PathVariable("devId") Integer devId) {
        developerService.deleteDeveloper(devId);
        return ResponseEntity.noContent().build();
    }
}
