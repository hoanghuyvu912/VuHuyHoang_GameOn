package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    @Query(value = "SELECT r from Receipt r join User u on r.user.id = u.id where u.id = :id")
    List<Receipt> getReceiptByUserId(@Param("id") Integer userId);

    List<Receipt> findByReceiptDateAfter(LocalDate date);

    List<Receipt> findByReceiptDateBefore(LocalDate date);
}
