package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.Receipt;
import com.nonIt.GameOn.entity.ReceiptDetails;
import com.nonIt.GameOn.service.customDto.RevenuePerDateDto;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReceiptDetailsRepository extends JpaRepository<ReceiptDetails, Integer> {
//    List<ReceiptDetails> findByReceiptReceiptDateBetween

//    @Query("SELECT new com.nonIt.GameOn.service.customDto.RevenuePerDateDto(r.receiptDate, count(g.id), sum(g.price)) " +
//            "FROM Game g join ReceiptDetails rd ON g.id = rd.game.id " +
//            "JOIN Receipt r on r.id = rd.receipt.id " +
//            "GROUP BY r.receiptDate " +
//            "HAVING r.receiptDate between :date1 and :date2")
//    List<RevenuePerDateDto> getRevenuePerDateBetweenDates(@Param("date1")LocalDate date1, @Param("date2")LocalDate date2);

    List<ReceiptDetails> findByReceiptUserId(@Param("userId") Integer userId);
}

