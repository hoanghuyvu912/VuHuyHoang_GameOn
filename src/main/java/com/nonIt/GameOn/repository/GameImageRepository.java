package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.GameImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameImageRepository extends JpaRepository<GameImage, Integer> {
}
