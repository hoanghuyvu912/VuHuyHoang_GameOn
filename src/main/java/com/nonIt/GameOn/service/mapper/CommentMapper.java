package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Comment;
import com.nonIt.GameOn.service.dto.CommentDto;
import com.nonIt.GameOn.service.restDto.CommentRestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper  extends EntityMapper<CommentRestDto, Comment, CommentDto>{
//    CommentDto toDto(Comment comment);
//
//    List<CommentDto> toDtos(List<Comment> comments);
//
//    CommentRestDto toRestDto(Comment comment);
//
//    List<CommentRestDto> toRestDtos(List<Comment> comments);
}
