package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.entity.Comment;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.service.CommentService;
import com.nonIt.GameOn.service.dto.CommentDto;
import com.nonIt.GameOn.service.restDto.CommentRestDto;
import com.nonIt.GameOn.service.restDto.DeveloperRestDto;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/comments")
public class CommentResources {
    private final CommentService commentService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<CommentRestDto>> getAllComment() {
        return ResponseEntity.ok(commentService.getAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/{commentId}")
    public ResponseEntity<CommentRestDto> getCommentById(@PathVariable("commentId") Integer commentId) {
//        boolean valid = true;
//        int commentIdInt = 0;
//        if (commentId == null || commentId.trim().isBlank() || commentId.isEmpty()) {
//            valid = false;
//        } else {
//            try {
//                commentIdInt = Integer.parseInt(commentId);
//            } catch (Exception e) {
//                valid = false;
//                throw GameOnException.badRequest("MissingCommentId", "Comment Id search query not found.");
//            }
//        }
//        if (valid) {
//            return ResponseEntity.ok(commentService.findById(commentIdInt));
//        } else {
//            throw GameOnException.badRequest("InvalidCommentId", "Invalid comment ID!");
//        }
        try {
            return ResponseEntity.ok(commentService.findById(commentId));
        } catch (Exception e) {
            throw GameOnException.badRequest("InvalidCommentId", "Invalid comment ID!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/date-after")
    public ResponseEntity<List<CommentRestDto>> findByCommentDateAfter(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(commentService.findByCommentDateAfter(date));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/date-before")
    public ResponseEntity<List<CommentRestDto>> findByCommentDateBefore(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(commentService.findByCommentDateBefore(date));
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping
    public ResponseEntity<CommentRestDto> createComment(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.createComment(commentDto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{commentId}")
    public ResponseEntity<CommentRestDto> updateCommentById(@PathVariable("commentId") Integer commentId, @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.updateComment(commentId, commentDto));
    }

    //    @PreAuthorize("hasRole( 'ADMIN')")
    @DeleteMapping(value = "/{commentId}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("commentId") Integer commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/by-user-id/{userId}")
    public ResponseEntity<List<CommentRestDto>> getCommentByUserId(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(commentService.getByUserId(userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/by-username")
    public ResponseEntity<List<CommentRestDto>> getCommentByUsername(@RequestParam("username") String username) {
        if (username == null || username.trim().isBlank() || username.isEmpty()) {
            throw GameOnException.badRequest("UsernameNotFound", "Username search query is missing.");
        }
        return ResponseEntity.ok(commentService.getByUsername("%" + username + "%"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/by-game-id/{gameId}")
    public ResponseEntity<List<CommentRestDto>> getCommentByGameId(@PathVariable("gameId") String gameId) {
        boolean valid = true;
        int gameIdInt = 0;
        if (gameId == null || gameId.trim().isBlank() || gameId.isEmpty()) {
            valid = false;
        } else {
            try {
                gameIdInt = Integer.parseInt(gameId);
            } catch (Exception e) {
                valid = false;
                throw GameOnException.badRequest("MissingGameId", "Game Id search query not found.");
            }
        }
        if (valid) {
            return ResponseEntity.ok(commentService.getByGameId(gameIdInt));
        } else {
            throw GameOnException.badRequest("InvalidCommentId", "Invalid comment ID!");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/by-game-name")
    public ResponseEntity<List<CommentRestDto>> getCommentByGameName(@RequestParam("gameName") String gameName) {
        if (gameName == null || gameName.trim().isBlank() || gameName.isEmpty()) {
            throw GameOnException.badRequest("UsernameNotFound", "Username search query is missing.");
        }
        return ResponseEntity.ok(commentService.getByGameName("%" + gameName + "%"));
    }
}
