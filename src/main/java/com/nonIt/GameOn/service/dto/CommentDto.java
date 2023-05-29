package com.nonIt.GameOn.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
//    @NotNull
    private Integer userId;
//    @NotNull
    private Integer gameId;
    private String commentContent;
    private LocalDate commentDate = LocalDate.now();
}
