package com.nonIt.GameOn.service.restdto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Receipt;
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
