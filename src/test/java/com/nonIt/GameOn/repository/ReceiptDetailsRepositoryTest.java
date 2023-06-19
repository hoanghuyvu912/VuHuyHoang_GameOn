package com.nonIt.GameOn.repository;

import com.nonIt.GameOn.entity.ReceiptDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ReceiptDetailsRepositoryTest {
    @Autowired
    private ReceiptDetailsRepository receiptDetailsRepository;
    @Test
    void findByReceiptReceiptDate() {
        LocalDate startDate = LocalDate.parse("2023-06-15");
        LocalDate endDate = LocalDate.parse("2023-06-19");
        assertTrue(receiptDetailsRepository.findByReceiptReceiptDate(startDate, endDate).size()>0);
    }
}