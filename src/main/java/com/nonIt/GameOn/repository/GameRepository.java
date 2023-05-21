package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findByNameContaining(String name);
    List<Game> findByReleasedDateAfter(LocalDate date);
    List<Game> findByReleasedDateBefore(LocalDate date);
    List<Game> findByPriceGreaterThan(Double price);
    List<Game> findByPriceLessThan(Double price);
    @Query(value = "SELECT g from Game g join Developer d on g.developer.id = d.id where d.id = :developerId")
    List<Game> getByDeveloperId(@Param("developerId") Integer developerId);

    @Query(value = "SELECT g from Game g join Publisher p on g.publisher.id = p.id where p.id = :publisherId")
    List<Game> getByPublisherId(@Param("publisherId") Integer publisherId);
}
