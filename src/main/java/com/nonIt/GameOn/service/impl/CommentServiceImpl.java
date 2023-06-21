package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Comment;
import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.CommentRepository;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedCommentDto;
import com.nonIt.GameOn.service.CommentService;
import com.nonIt.GameOn.service.createdto.CommentDto;
import com.nonIt.GameOn.service.mapper.CommentMapper;
import com.nonIt.GameOn.service.restdto.CommentRestDto;
import com.nonIt.GameOn.utils.NullChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Base64;
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
    public List<SimplifiedCommentDto> getByUserId(Integer userId) {
        userRepository.findById(userId).orElseThrow(GameOnException::UserNotFound);
        return commentRepository.getCommentByUserId(userId).stream().map(commentMapper::toSimplifiedDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentRestDto> getByUsername(String username) {
        if (username == null || username.trim().isBlank() || username.isEmpty()) {
            throw GameOnException.badRequest("UsernameNotFound", "Username search query is missing.");
        }
        return commentRepository.getCommentByUsername(username).stream().map(commentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SimplifiedCommentDto> getByGameId(Integer gameId) {
        gameRepository.findById(gameId).orElseThrow(GameOnException::GameNotFound);
        return commentRepository.getCommentByGameId(gameId).stream().map(commentMapper::toSimplifiedDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentRestDto> getByGameName(String gameName) {
        if (gameName == null || gameName.trim().isBlank() || gameName.isEmpty()) {
            throw GameOnException.badRequest("UsernameNotFound", "Username search query is missing.");
        }
        return commentRepository.getCommentByGameName(gameName).stream().map(commentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentRestDto> findByCommentDateAfter(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidDate", "Comment date cannot be after current date.");
        }
        return commentRepository.findByCommentDateAfter(date).stream().map(commentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CommentRestDto> findByCommentDateBefore(LocalDate date) {
        return commentRepository.findByCommentDateBefore(date).stream().map(commentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CommentRestDto findById(Integer commentId) {
        boolean isCommentIdNull = NullChecker.allNull(commentId);
        if(isCommentIdNull) {
            throw GameOnException.badRequest("InvalidCommentId", "Invalid comment ID!");
        }
        if (commentId < 0) {
            throw GameOnException.badRequest("InvalidCommentId", "Comment ID search query must be a positive number.");
        }
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
                .commentDate(LocalDate.now())
                .build();

        comment = commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    @Override
    public CommentRestDto updateComment(Integer commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(GameOnException::CommentNotFound);
        if (commentDto.getGameId() != null) {
            Game game = gameRepository.findById(commentDto.getGameId()).orElseThrow(GameOnException::GameNotFound);
            comment.setGame(game);
        }
        if (commentDto.getUserId() != null) {
            User user = userRepository.findById(commentDto.getUserId()).orElseThrow(GameOnException::UserNotFound);
            comment.setUser(user);
        }
        if (commentDto.getCommentContent() != null) {
            if (commentDto.getCommentContent().trim().isBlank() || commentDto.getCommentContent().isEmpty()) {
                throw GameOnException.badRequest("CommentContentNotFound", "Comment content is missing.");
            }
        }
        commentMapper.mapFromDto(commentDto, comment);
        comment = commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    @Override
    public void deleteComment(Integer commentId, String authorization) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(GameOnException::CommentNotFound);
        System.out.println("%" + authorization + "%");
        String[] chunks = authorization.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        String[] body = payload.split(",");
        String idStr = body[2].split(":")[1].replaceAll("\"", "");
        System.out.println(idStr);
//        System.out.println("%" + id);
        int id = Integer.parseInt(idStr);
        System.out.println(id);
        if(id != (comment.getUser().getId())) {
            System.out.println("Comment does not belong to the active user!");
            throw GameOnException.badRequest("CannotDeleteComment", "Comment does not belong to the active user!");
        }
        System.out.println("%" + header + ", " + payload);
//        var auth = SecurityContextHolder.getContext().getAuthentication();
//        var comment = commentRepository.findById(commentId).orElseThrow(GameOnException::CommentNotFound);
//        if (!comment.getUser().getUsername().equalsIgnoreCase(auth.getName())) {
//            throw new RuntimeException();
//        }
        commentRepository.deleteById(commentId);
    }
}
