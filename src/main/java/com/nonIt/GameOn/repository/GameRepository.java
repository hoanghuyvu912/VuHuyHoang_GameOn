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

    @Query(value = "SELECT g from Game g join ReceiptDetails rd on g.id = rd.game.id join Receipt r on rd.receipt.id = r.id join User u on u.id = r.user.id where u.id = :userId")
    List<Game> getByUserId(@Param("userId") Integer userId);

    @Query(value = "SELECT g from Game g join ReceiptDetails rd on g.id = rd.game.id join Receipt r on rd.receipt.id = r.id join User u on u.id = r.user.id where UPPER(u.username) LIKE UPPER(:username)")
    List<Game> getByUsername(@Param("username") String username);

    @Query(value = "SELECT g from Game g join GameGenre gg on g.id = gg.game.id join Genre g2 on gg.genre.id = g2.id where g2.id = :genreId")
    List<Game> getByGenreId(@Param("genreId") Integer genreId);

    @Query(value = "SELECT g from Game g join GameGenre gg on g.id = gg.game.id join Genre g2 on gg.genre.id = g2.id where g2.name LIKE :genreName")
    List<Game> getByGenreName(@Param("genreName") String genreName);

    @Query(value = "SELECT g from Game g join GameSubGenre gsg on g.id = gsg.game.id join SubGenre sg on gsg.subGenre.id = sg.id where sg.id = :subGenreId")
    List<Game> getBySubGenreId(@Param("subGenreId") Integer subGenreId);

    @Query(value = "SELECT g from Game g join GameSubGenre gsg on g.id = gsg.game.id join SubGenre sg on gsg.subGenre.id = sg.id where sg.name LIKE :subGenreName")
    List<Game> getBySubGenreName(@Param("subGenreName") String subGenreName);
}
