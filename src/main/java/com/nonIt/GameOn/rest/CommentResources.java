package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.entity.Comment;
import com.nonIt.GameOn.service.CommentService;
import com.nonIt.GameOn.service.dto.CommentDto;
import com.nonIt.GameOn.service.restDto.CommentRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/comments")
public class CommentResources {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentRestDto>> getAllComment() {
        return ResponseEntity.ok(commentService.getAll());
    }

    @GetMapping(value = "/{commentId}")
    public ResponseEntity<CommentRestDto> getCommentById(@PathVariable("commentId") Integer commentId) {
        return ResponseEntity.ok(commentService.findById(commentId));
    }

    @PostMapping
    public ResponseEntity<CommentRestDto> createComment(CommentDto commentDto) {
        return ResponseEntity.ok(commentService.createComment(commentDto));
    }

    @PutMapping(value = "/{commentId}")
    public ResponseEntity<CommentRestDto> updateCommentById(@PathVariable("commentId") Integer commentId, @RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.updateComment(commentId, commentDto));
    }

    @DeleteMapping(value = "/{commentId}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("commentId") Integer commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/by-user/{userId}")
    public ResponseEntity<List<CommentRestDto>> getCommentByUserId(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(commentService.getByUserId(userId));
    }
}
