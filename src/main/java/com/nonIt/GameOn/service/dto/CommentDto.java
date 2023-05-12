package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Integer userId;
    private Integer gameId;
    private String commentContent;
}
