package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Genre;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameGenreDto {
    private Integer gameId;

    private Integer genreId;
}
