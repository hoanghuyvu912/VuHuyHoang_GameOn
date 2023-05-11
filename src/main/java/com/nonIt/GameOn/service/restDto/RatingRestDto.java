package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.User;
import jakarta.persistence.*;

public class RatingRestDto {
    private Integer id;

    private User user;

    private Game game;

    private String rating;
}
