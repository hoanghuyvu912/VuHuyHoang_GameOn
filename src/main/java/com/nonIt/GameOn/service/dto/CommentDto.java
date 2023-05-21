package com.nonIt.GameOn.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
//    @NotNull
    private Integer userId;
//    @NotNull
    private Integer gameId;
    private String commentContent;
}
