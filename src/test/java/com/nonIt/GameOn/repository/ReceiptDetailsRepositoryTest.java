package com.nonIt.GameOn.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ReceiptDetailsRepositoryTest {
    @Autowired
    private ReceiptDetailsRepository receiptDetailsRepository;
<<<<<<< HEAD
    @Test
    void findByReceiptReceiptDate() {
        LocalDate startDate = LocalDate.parse("2023-06-15");
        LocalDate endDate = LocalDate.parse("2023-06-19");
        assertTrue(receiptDetailsRepository.findByReceiptReceiptDateBetween(startDate, endDate).size()>0);
    }
=======
//    @Test
//    void findByReceiptReceiptDate() {
//        LocalDate startDate = LocalDate.parse("2023-06-15");
//        LocalDate endDate = LocalDate.parse("2023-06-19");
//        assertTrue(receiptDetailsRepository.findByReceiptReceiptDate(startDate, endDate).size()>0);
//    }
>>>>>>> 7cd61c815d16499d3520b246a521429059b5a3eb
    @Test
    void findReceiptDetailsListPerMonth(){
        System.out.println(receiptDetailsRepository.getRevenuePerMonthInYear(6,2023));

    }

    @Test
    void getGameStatisticsPerMonth() {
        receiptDetailsRepository.getGameStatisticsPerMonth(6,2023).forEach(gs ->{
            System.out.println(gs.getGame().getName() + gs.getGameCodeList() + gs.getRevenue());
        });
    }
}