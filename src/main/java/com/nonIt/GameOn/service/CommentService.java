package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.CommentDto;
import com.nonIt.GameOn.service.restDto.CommentRestDto;

import java.time.LocalDate;
import java.util.List;

public interface CommentService {
    List<CommentRestDto> getAll();

    CommentRestDto findById(Integer commentId);

    CommentRestDto createComment(CommentDto commentDto);

    CommentRestDto updateComment(Integer commentId, CommentDto commentDto);

    void deleteComment(Integer commentId);

    List<CommentRestDto> getByUserId(Integer userId);

    List<CommentRestDto> getByUsername(String username);

    List<CommentRestDto> getByGameId(Integer gameId);

    List<CommentRestDto> getByGameName(String gameName);

    List<CommentRestDto> findByCommentDateAfter(LocalDate date);

    List<CommentRestDto> findByCommentDateBefore(LocalDate date);
}
