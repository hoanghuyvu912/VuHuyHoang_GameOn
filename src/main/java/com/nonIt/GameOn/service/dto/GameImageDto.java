package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Game;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameImageDto {
    private Integer gameId;
    private String imageLink;
}
