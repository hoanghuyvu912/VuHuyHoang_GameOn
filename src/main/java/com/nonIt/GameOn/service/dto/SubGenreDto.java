package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubGenreDto {
    private Integer genreId;
    private String name;
}
