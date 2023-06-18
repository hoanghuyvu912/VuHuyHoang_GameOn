package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.entity.GameCode;
import com.nonIt.GameOn.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRestDto {
    private Integer id;

    private String name;

    private String thumbnail;

    private String description;

    private String trailer;

    private LocalDate releasedDate;

    private String systemReq;

    private Double price;

    private Developer developer;

    private Publisher publisher;
}
