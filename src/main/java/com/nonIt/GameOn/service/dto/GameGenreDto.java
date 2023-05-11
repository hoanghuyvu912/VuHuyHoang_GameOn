package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Genre;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class GameGenreDto {
    private Integer gameId;

    private Integer genreId;
}
