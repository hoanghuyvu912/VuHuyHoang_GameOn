package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    //Find by Game name related
    List<Game> findByNameContaining(String name);

    List<Game> findByNameContainingAndReleasedDateAfter(String gameName, LocalDate date);

    List<Game> findByNameContainingAndReleasedDateBefore(String gameName, LocalDate date);

    List<Game> findByNameContainingAndReleasedDateBetween(String gameName, LocalDate date1, LocalDate date2);

    List<Game> findByNameContainingAndReleasedDateAfterAndSystemReqContaining(String gameName, LocalDate date, String req);

    List<Game> findByNameContainingAndReleasedDateBeforeAndSystemReqContaining(String gameName, LocalDate date, String req);

    List<Game> findByNameContainingAndReleasedDateBetweenAndSystemReqContaining(String gameName, LocalDate date1, LocalDate date2, String req);

    List<Game> findByNameContainingAndReleasedDateAfterAndSystemReqContainingAndPriceLessThanEqual(String gameName, LocalDate date, String req, Double price);

    List<Game> findByNameContainingAndReleasedDateAfterAndSystemReqContainingAndPriceGreaterThanEqual(String gameName, LocalDate date, String req, Double price);

    List<Game> findByNameContainingAndReleasedDateAfterAndSystemReqContainingAndPriceBetween(String gameName, LocalDate date, String req, Double price1, Double price2);

    List<Game> findByNameContainingAndReleasedDateBeforeAndSystemReqContainingAndPriceLessThanEqual(String gameName, LocalDate date, String req, Double price);

    List<Game> findByNameContainingAndReleasedDateBeforeAndSystemReqContainingAndPriceGreaterThanEqual(String gameName, LocalDate date, String req, Double price);

    List<Game> findByNameContainingAndReleasedDateBeforeAndSystemReqContainingAndPriceBetween(String gameName, LocalDate date, String req, Double price1, Double price2);

    List<Game> findByNameContainingAndReleasedDateBetweenAndSystemReqContainingAndPriceLessThanEqual(String gameName, LocalDate date1, LocalDate date2, String req, Double price);

    List<Game> findByNameContainingAndReleasedDateBetweenAndSystemReqContainingAndPriceGreaterThanEqual(String gameName, LocalDate date1, LocalDate date2, String req, Double price);

    List<Game> findByNameContainingAndReleasedDateBetweenAndSystemReqContainingAndPriceBetween(String gameName, LocalDate date1, LocalDate date2, String req, Double price1, double price2);

    List<Game> findByNameContainingAndSystemReqContaining(String name, String req);

    List<Game> findByNameContainingAndSystemReqContainingAndPriceLessThanEqual(String gameName, String req, Double price);

    List<Game> findByNameContainingAndSystemReqContainingAndPriceGreaterThanEqual(String gameName, String req, Double price);

    List<Game> findByNameContainingAndSystemReqContainingAndPriceBetween(String gameName, String req, Double price1, double price2);

    List<Game> findByNameContainingAndPriceLessThanEqual(String name, Double price);

    List<Game> findByNameContainingAndPriceGreaterThanEqual(String name, Double price);

    List<Game> findByNameContainingAndPriceBetween(String name, Double price1, Double price2);

    List<Game> findByNameContainingAndDeveloperNameContaining(String gameName, String developerName);

    List<Game> findByNameContainingAndPublisherNameContaining(String gameName, String publisherName);


    //Find by Game releasedDate related
    List<Game> findByReleasedDateAfter(LocalDate date);

    List<Game> findByReleasedDateBefore(LocalDate date);

    List<Game> findByReleasedDateAfterAndSystemReqContaining(LocalDate date, String systemReq);

    List<Game> findByReleasedDateBeforeAndSystemReqContaining(LocalDate date, String systemReq);

    List<Game> findByReleasedDateBetweenAndSystemReqContaining(LocalDate date1, LocalDate date2, String systemReq);

    List<Game> findByReleasedDateAfterAndPriceLessThanEqual(LocalDate date, Double price);

    List<Game> findByReleasedDateAfterAndPriceGreaterThanEqual(LocalDate date, Double price);

    List<Game> findByReleasedDateAfterAndPriceBetween(LocalDate date, Double price1, Double price2);

    List<Game> findByReleasedDateBeforeAndPriceLessThanEqual(LocalDate date, Double price);

    List<Game> findByReleasedDateBeforeAndPriceGreaterThanEqual(LocalDate date, Double price);

    List<Game> findByReleasedDateBeforeAndPriceBetween(LocalDate date, Double price1, Double price2);

    List<Game> findByReleasedDateBetweenAndPriceBetween(LocalDate date1, LocalDate date2, Double price1, Double price2);


    //Find by Game systemReq related
    List<Game> findBySystemReqContaining(String req);

    List<Game> findBySystemReqContainingAndPriceGreaterThanEqual(String req, Double price);

    List<Game> findBySystemReqContainingAndPriceLessThanEqual(String req, Double price);

    List<Game> findBySystemReqContainingAndPriceBetween(String req, Double price1, Double price2);


    //Find by Game price related
    List<Game> findByPriceGreaterThan(Double price);

    List<Game> findByPriceLessThan(Double price);

    List<Game> findByPriceBetween(Double price1, Double price2);


    //Find by foreign key

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

    @Query(value = "SELECT g from Game g join GameGenre gg on g.id = gg.game.id join Genre g2 on gg.genre.id = g2.id where UPPER(g2.name) LIKE UPPER(:genreName)")
    List<Game> getByGenreName(@Param("genreName") String genreName);

    @Query(value = "SELECT g from Game g join GameSubGenre gsg on g.id = gsg.game.id join SubGenre sg on gsg.subGenre.id = sg.id where sg.id = :subGenreId")
    List<Game> getBySubGenreId(@Param("subGenreId") Integer subGenreId);

    @Query(value = "SELECT g from Game g join GameSubGenre gsg on g.id = gsg.game.id join SubGenre sg on gsg.subGenre.id = sg.id where UPPER(sg.name) LIKE UPPER(:subGenreName)")
    List<Game> getBySubGenreName(@Param("subGenreName") String subGenreName);


//    private Integer id;
//
//    private String name;
//
//    private String thumbnail;
//
//    private String description;
//
//    private String trailer;
//
//    private LocalDate releasedDate;
//
//    private String systemReq;
//
//    private Double price;
//
//    private String developerName;
//
//    private String publisherName;
//
//    private Integer rating;
//    @Query(value = "select tmp.g, max(tmp.rating) from " +
//            "(select g, r.rating " +
//            "from game g join rating r on r.game_id = g.id " +
//            "group by g.id, r.rating " +
//            "HAVING r.rating between :rating1 and :rating2 " +
//            "and g.released_date between :date1 and :date2) tmp " +
//            "group by tmp.g;", nativeQuery = true)
//    List<Game> getByRatingAndReleasedDateBetween(@Param("rating1") Integer rating1, @Param("rating2") Integer rating2, @Param("date1") LocalDate date1, @Param("date2") LocalDate date2);

}
