package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.User;
import jakarta.persistence.*;

import java.time.LocalDate;

public class ReceiptRestDto {
    private Integer id;

    private User user;

    private LocalDate receiptDate;
}
