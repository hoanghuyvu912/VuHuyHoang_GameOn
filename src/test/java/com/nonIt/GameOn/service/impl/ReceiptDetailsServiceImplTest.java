package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.ReceiptDetails;
import com.nonIt.GameOn.rest.resources_dto.SimplifiedReceiptDetailsDto;
import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.ReceiptDetailsService;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ReceiptDetailsServiceImplTest {
    @Autowired
    private ReceiptDetailsService receiptDetailsService;

//    @Test
//    void getBestSellerGamesBetweenDates() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        String date1Str = "2020/01/01";
//        String date2Str = "2023/01/01";
//
//        LocalDate date1 = LocalDate.parse(date1Str, formatter);
//        LocalDate date2 = LocalDate.parse(date2Str, formatter);
//        Map<Game, Long> tempMap = receiptDetailsService.getBestSellerGamesBetweenDates(date1, date2);
//        for(Map.Entry<Game, Long> entry : tempMap.entrySet()) {
//            Game key = entry.getKey();
//            Long value = entry.getValue();
//
//            System.out.println(key.getName());
//            System.out.println(value);
//        }
//    }

//    @Test
//    void getWorstSellerGamesBetweenDates() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        String date1Str = "2020/01/01";
//        String date2Str = "2023/01/01";
//
//        LocalDate date1 = LocalDate.parse(date1Str, formatter);
//        LocalDate date2 = LocalDate.parse(date2Str, formatter);
//        Map<Game, Long> tempMap = receiptDetailsService.getWorstSellerGamesBetweenDates(date1, date2);
//        for(Map.Entry<Game, Long> entry : tempMap.entrySet()) {
//            Game key = entry.getKey();
//            Long value = entry.getValue();
//
//            System.out.println(key.getName());
//            System.out.println(value);
//        }
//    }

    @Test
    void findByReceiptUserId() {
        List<SimplifiedReceiptDetailsDto> listOfReceiptDetailsOfUser = receiptDetailsService.findByReceiptUserId(2);
        listOfReceiptDetailsOfUser.forEach(System.out::println);
    }

    @Test
    void testGetBestSellerGamesBetweenDates() {
        LocalDate startDate = LocalDate.parse("2023-06-15");
        System.out.println(startDate);
        LocalDate endDate = LocalDate.parse("2023-06-18");

        System.out.println( receiptDetailsService.getBestSellerGamesBetweenDates(startDate,endDate));
    }

    @Test
    void getReceiptDetailListBetweenDates() {
        LocalDate dateOne = LocalDate.parse("2023-06-15");
        LocalDate dateTwo = LocalDate.parse("2023-06-19");
        receiptDetailsService.getReceiptDetailListBetweenDates(dateOne,dateTwo);
    }

}