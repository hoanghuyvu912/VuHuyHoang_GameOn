package com.nonIt.GameOn.service.restDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperRestDto {
    private Integer id;

    private String name;

    private String thumbnail;

    private String coverPhoto;

    private String description;

    private LocalDate establishedDate;
}
