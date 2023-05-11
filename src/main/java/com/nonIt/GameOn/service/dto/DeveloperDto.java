package com.nonIt.GameOn.service.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class DeveloperDto {
    private String name;

    private String thumbnail;

    private String coverPhoto;

    private String description;

    private LocalDate establishedDate;
}
