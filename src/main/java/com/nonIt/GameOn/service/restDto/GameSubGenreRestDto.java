package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.SubGenre;
import jakarta.persistence.*;

public class GameSubGenreRestDto {
    private Integer id;

    private Game game;

    private SubGenre subGenre;
}
