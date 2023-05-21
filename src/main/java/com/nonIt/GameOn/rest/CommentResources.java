package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.entity.Comment;
import com.nonIt.GameOn.service.CommentService;
import com.nonIt.GameOn.service.dto.CommentDto;
import com.nonIt.GameOn.service.restDto.CommentRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return ResponseEntity.ok(commentService.findById(commentId));
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping
    public ResponseEntity<CommentRestDto> createComment(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.createComment(commentDto));
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PutMapping(value = "/{commentId}")
    public ResponseEntity<CommentRestDto> updateCommentById(@PathVariable("commentId") Integer commentId, @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.updateComment(commentId, commentDto));
    }
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @DeleteMapping(value = "/{commentId}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("commentId") Integer commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(value = "/by-user/{userId}")
    public ResponseEntity<List<CommentRestDto>> getCommentByUserId(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(commentService.getByUserId(userId));
    }
}
