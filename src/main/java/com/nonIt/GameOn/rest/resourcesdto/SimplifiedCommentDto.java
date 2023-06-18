package com.nonIt.GameOn.rest.resourcesdto;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedCommentDto {
    private Integer id;
    private Integer userId;
    private String username;
    private Integer gameId;
    private String commentContent;
    private LocalDate commentDate;
}
