package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.entity.GameCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameCodeRepository extends JpaRepository<GameCode, Integer> {
}
