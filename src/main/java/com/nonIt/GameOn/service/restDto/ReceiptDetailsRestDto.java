package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Receipt;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDetailsRestDto {
    private Integer id;

    private Receipt receipt;

    private Game game;
}
