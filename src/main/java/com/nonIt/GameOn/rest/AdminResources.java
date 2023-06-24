package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.service.restdto.CommentRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/admins-page")
@PreAuthorize("hasRole('ADMIN')")
public class AdminResources {
    @GetMapping
    public ResponseEntity<String> accessAdminPage(@RequestHeader("Authorization") String authorization) {
        return ResponseEntity.ok("This is an admin page");
    }
}
