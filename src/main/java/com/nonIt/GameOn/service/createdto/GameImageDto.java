package com.nonIt.GameOn.service.createdto;

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
