package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.CommentDto;
import com.nonIt.GameOn.service.restDto.CommentRestDto;

import java.util.List;

public interface CommentService {
    List<CommentRestDto> getAll();

    CommentRestDto findById(Integer commentId);

    CommentRestDto createComment(CommentDto commentDto);

    CommentRestDto updateComment(Integer commentId, CommentDto commentDto);

    void deleteComment(Integer commentId);
}
