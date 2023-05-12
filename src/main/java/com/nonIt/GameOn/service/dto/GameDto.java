package com.nonIt.GameOn.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {
    private String name;

    private String thumbnail;

    private String description;

    private String trailer;

    private LocalDate releasedDate;

    private String systemReq;

    private Double price;

    @NotNull
    private Integer developerId;

    @NotNull
    private Integer publisherId;
}
