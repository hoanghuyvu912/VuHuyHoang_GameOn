package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Comment;
import com.nonIt.GameOn.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    @Query(value = "SELECT r from Rating r join User u on r.user.id = u.id where u.id = :id")
    List<Rating> getRatingByUserId(@Param("id") Integer userId);
}
