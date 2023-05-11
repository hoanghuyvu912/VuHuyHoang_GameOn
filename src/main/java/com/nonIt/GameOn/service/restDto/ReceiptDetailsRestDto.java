package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Receipt;
import jakarta.persistence.*;

public class ReceiptDetailsRestDto {
    private Integer id;

    private Receipt receipt;

    private Game game;
}
