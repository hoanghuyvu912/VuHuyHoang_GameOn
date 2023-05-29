package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.repository.CustomRepository.GameCustomRespository.CustomGameRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>, CustomGameRepository {

    //Find by name
    List<Game> findByNameIgnoreCaseContaining(String name);


    //Find by name and released date
    List<Game> findByNameIgnoreCaseContainingAndReleasedDateAfter(String gameName, LocalDate date);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBefore(String gameName, LocalDate date);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBetween(String gameName, LocalDate date1, LocalDate date2);


    //Find by name and released date and system req
    List<Game> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContaining(String gameName, LocalDate date, String req);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContaining(String gameName, LocalDate date, String req);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContaining(String gameName, LocalDate date1, LocalDate date2, String req);


    //Find by name and released date and system req and price
    List<Game> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, LocalDate date, String req, Double price);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, LocalDate date, String req, Double price);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, LocalDate date, String req, Double price1, Double price2);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, LocalDate date, String req, Double price);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, LocalDate date, String req, Double price);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, LocalDate date, String req, Double price1, Double price2);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, LocalDate date1, LocalDate date2, String req, Double price);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, LocalDate date1, LocalDate date2, String req, Double price);

    List<Game> findByNameIgnoreCaseContainingAndReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, LocalDate date1, LocalDate date2, String req, Double price1, double price2);


    //Find by name and system req
    List<Game> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContaining(String name, String req);


    //Find by name and system req and price
    List<Game> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(String gameName, String req, Double price);

    List<Game> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String gameName, String req, Double price);

    List<Game> findByNameIgnoreCaseContainingAndSystemReqIgnoreCaseContainingAndPriceBetween(String gameName, String req, Double price1, double price2);


    //Find by name and price
    List<Game> findByNameIgnoreCaseContainingAndPriceLessThanEqual(String name, Double price);

    List<Game> findByNameIgnoreCaseContainingAndPriceGreaterThanEqual(String name, Double price);

    List<Game> findByNameIgnoreCaseContainingAndPriceBetween(String name, Double price1, Double price2);


    List<Game> findByNameContainingAndDeveloperNameContaining(String gameName, String developerName);

    List<Game> findByNameContainingAndPublisherNameContaining(String gameName, String publisherName);


    //Find by released date
    List<Game> findByReleasedDateAfter(LocalDate date);

    List<Game> findByReleasedDateBefore(LocalDate date);

    List<Game> findByReleasedDateBetween(LocalDate date1, LocalDate date2);


    //Find by released date and system req
    List<Game> findByReleasedDateAfterAndSystemReqIgnoreCaseContaining(LocalDate date, String systemReq);

    List<Game> findByReleasedDateBeforeAndSystemReqIgnoreCaseContaining(LocalDate date, String systemReq);

    List<Game> findByReleasedDateBetweenAndSystemReqIgnoreCaseContaining(LocalDate date1, LocalDate date2, String systemReq);


    //Find by released date and system req and price
    List<Game> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(LocalDate date, String systemReq, Double price);

    List<Game> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(LocalDate date, String systemReq, Double price);

    List<Game> findByReleasedDateAfterAndSystemReqIgnoreCaseContainingAndPriceBetween(LocalDate date, String systemReq, Double price1, Double price2);

    List<Game> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(LocalDate date, String systemReq, Double price);

    List<Game> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(LocalDate date, String systemReq, Double price);

    List<Game> findByReleasedDateBeforeAndSystemReqIgnoreCaseContainingAndPriceBetween(LocalDate date, String systemReq, Double price1, Double price2);

    List<Game> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceLessThanEqual(LocalDate date1, LocalDate date2, String systemReq, Double price);

    List<Game> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(LocalDate date1, LocalDate date2, String systemReq, Double price);

    List<Game> findByReleasedDateBetweenAndSystemReqIgnoreCaseContainingAndPriceBetween(LocalDate date1, LocalDate date2, String systemReq, Double price1, Double price2);


    //Find by released date and price
    List<Game> findByReleasedDateAfterAndPriceLessThanEqual(LocalDate date, Double price);

    List<Game> findByReleasedDateAfterAndPriceGreaterThanEqual(LocalDate date, Double price);

    List<Game> findByReleasedDateAfterAndPriceBetween(LocalDate date, Double price1, Double price2);

    List<Game> findByReleasedDateBeforeAndPriceLessThanEqual(LocalDate date, Double price);

    List<Game> findByReleasedDateBeforeAndPriceGreaterThanEqual(LocalDate date, Double price);

    List<Game> findByReleasedDateBeforeAndPriceBetween(LocalDate date, Double price1, Double price2);

    List<Game> findByReleasedDateBetweenAndPriceLessThanEqual(LocalDate date1, LocalDate date2, Double price);

    List<Game> findByReleasedDateBetweenAndPriceGreaterThanEqual(LocalDate date1, LocalDate date2, Double price);

    List<Game> findByReleasedDateBetweenAndPriceBetween(LocalDate date1, LocalDate date2, Double price1, Double price2);


    //Find by system req
    List<Game> findBySystemReqIgnoreCaseContaining(String req);


    //Find by system req and price
    List<Game> findBySystemReqIgnoreCaseContainingAndPriceGreaterThanEqual(String req, Double price);

    List<Game> findBySystemReqIgnoreCaseContainingAndPriceLessThanEqual(String req, Double price);

    List<Game> findBySystemReqIgnoreCaseContainingAndPriceBetween(String req, Double price1, Double price2);


    //Find by price
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


    //Combined queries


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
