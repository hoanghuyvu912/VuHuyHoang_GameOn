package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.GameGenre;
import com.nonIt.GameOn.entity.GameSubGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSubGenreRepository extends JpaRepository<GameSubGenre, Integer> {
}
