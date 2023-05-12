package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.PublisherService;
import com.nonIt.GameOn.service.dto.PublisherDto;
import com.nonIt.GameOn.service.restDto.PublisherRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/publishers")
public class PublisherResources {
    private final PublisherService PublisherService;

    @GetMapping
    public ResponseEntity<List<PublisherRestDto>> getAllPublisher() {
        return ResponseEntity.ok(PublisherService.getAll());
    }

    @GetMapping(value = "/{publisherId}")
    public ResponseEntity<PublisherRestDto> getPublisherById(@PathVariable("publisherId") Integer publisherId) {
        return ResponseEntity.ok(PublisherService.findById(publisherId));
    }

    @PostMapping
    public ResponseEntity<PublisherRestDto> createPublisher(@RequestBody PublisherDto PublisherDto) {
        return ResponseEntity.ok(PublisherService.createPublisher(PublisherDto));
    }

    @PutMapping(value = "/{publisherId}")
    public ResponseEntity<PublisherRestDto> updatePublisherById(@PathVariable("publisherId") Integer publisherId, @RequestBody PublisherDto PublisherDto) {
        return ResponseEntity.ok(PublisherService.updatePublisher(publisherId, PublisherDto));
    }

    @DeleteMapping(value = "/{publisherId}")
    public ResponseEntity<Void> deletePublisherById(@PathVariable("publisherId") Integer publisherId) {
        PublisherService.deletePublisher(publisherId);
        return ResponseEntity.noContent().build();
    }
}
