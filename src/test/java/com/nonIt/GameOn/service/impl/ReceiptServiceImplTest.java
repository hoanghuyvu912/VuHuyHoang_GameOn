package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.rest.resourcesdto.ReceiptCreateDto;
import com.nonIt.GameOn.service.GameService;
import com.nonIt.GameOn.service.ReceiptService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ReceiptServiceImplTest {
    @Autowired
    private ReceiptService receiptService;

    @Test
    void testCreateReceipt() {
        ReceiptCreateDto receiptCreateDto = new ReceiptCreateDto();
        receiptCreateDto.setUserId(25);
        List<Integer> gameIdList = new ArrayList<>();
        gameIdList.add(2);
        gameIdList.add(4);
        gameIdList.add(3);
        receiptCreateDto.setGameIdList(gameIdList);
        receiptService.createReceipt(receiptCreateDto);
    }
}