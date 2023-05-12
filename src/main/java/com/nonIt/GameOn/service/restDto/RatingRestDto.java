package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingRestDto {
    private Integer id;

    private User user;

    private Game game;

    private String rating;
}
