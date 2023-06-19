package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Comment;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedCommentDto;
import com.nonIt.GameOn.service.createdto.CommentDto;
import com.nonIt.GameOn.service.restdto.CommentRestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper  extends EntityMapper<CommentRestDto, Comment, CommentDto>{
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    SimplifiedCommentDto toSimplifiedDto(Comment comment);
//    CommentDto toDto(Comment comment);
//
//    List<CommentDto> toDtos(List<Comment> comments);
//
//    CommentRestDto toRestDto(Comment comment);
//
//    List<CommentRestDto> toRestDtos(List<Comment> comments);
}
