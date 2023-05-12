package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptRestDto {
    private Integer id;

    private User user;

    private LocalDate receiptDate;
}
