package com.nonIt.GameOn.service.dto;

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
