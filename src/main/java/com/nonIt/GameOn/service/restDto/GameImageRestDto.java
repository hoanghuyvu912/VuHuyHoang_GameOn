package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Game;
import jakarta.persistence.*;

public class GameImageRestDto {
    private Integer id;

    private String imageLink;

    private Game game;
}
