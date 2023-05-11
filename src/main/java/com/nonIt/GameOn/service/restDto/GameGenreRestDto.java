package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Genre;
import jakarta.persistence.*;

public class GameGenreRestDto {
    private Integer id;

    private Game game;

    private Genre genre;
}
