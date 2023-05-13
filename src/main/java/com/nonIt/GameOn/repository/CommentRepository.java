package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Comment;
import com.nonIt.GameOn.service.restDto.CommentRestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT c from Comment c join User u on c.user.id = u.id where u.id = :id")
    List<Comment> getCommentByUserId(@Param("id") Integer userId);
}
