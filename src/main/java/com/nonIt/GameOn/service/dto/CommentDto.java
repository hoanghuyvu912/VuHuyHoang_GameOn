package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CommentDto {
    private String commentContent;
}
