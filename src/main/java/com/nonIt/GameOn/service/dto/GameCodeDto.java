package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.GameCodeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCodeDto {
    private List<String> gameCodeList;
    private Integer gameId;
    private GameCodeStatus gameCodeStatus;
}
