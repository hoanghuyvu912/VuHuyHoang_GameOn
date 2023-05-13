package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Comment;
import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.CommentRepository;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.service.CommentService;
import com.nonIt.GameOn.service.dto.CommentDto;
import com.nonIt.GameOn.service.mapper.CommentMapper;
import com.nonIt.GameOn.service.restDto.CommentRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<CommentRestDto> getAll() {
        return commentRepository.findAll().stream().map(commentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CommentRestDto findById(Integer commentId) {
        return commentRepository.findById(commentId).map(commentMapper::toDto).orElseThrow(GameOnException::CommentNotFound);
    }

    @Override
    public CommentRestDto createComment(CommentDto commentDto) {
        User user = userRepository.findById(commentDto.getUserId()).orElseThrow(GameOnException::UserNotFound);
        Game game = gameRepository.findById(commentDto.getGameId()).orElseThrow(GameOnException::GameNotFound);

        if (commentDto.getCommentContent() == null || commentDto.getCommentContent().trim().isBlank() || commentDto.getCommentContent().isEmpty()) {
            throw GameOnException.badRequest("CommentContentNotFound", "Comment content is missing.");
        }

        Comment comment = Comment.builder()
                .commentContent(commentDto.getCommentContent())
                .user(user)
                .game(game)
                .build();

        comment = commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    @Override
    public CommentRestDto updateComment(Integer commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(GameOnException::CommentNotFound);
        if (commentDto.getCommentContent().trim().isBlank() || commentDto.getCommentContent().isEmpty()) {
            throw GameOnException.badRequest("CommentContentNotFound", "Comment content is missing.");
        }
        commentMapper.updateFromDto(commentDto, comment);
        comment = commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
