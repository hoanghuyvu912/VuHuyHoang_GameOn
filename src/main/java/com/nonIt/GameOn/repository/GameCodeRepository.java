package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.entity.GameCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameCodeRepository extends JpaRepository<GameCode, Integer> {
    List<GameCode> findByGameId(@Param("gameId") Integer gameId);
}
