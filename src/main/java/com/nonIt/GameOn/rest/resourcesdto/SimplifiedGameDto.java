package com.nonIt.GameOn.rest.resourcesdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedGameDto {
    private Integer id;

    private String name;

    private String thumbnail;

    private String description;

    private String trailer;

    private LocalDate releasedDate;

    private String systemReq;

    private Double price;

    private Integer developerId;

    private Integer publisherId;

    private String developerName;

    private String publisherName;

    private List<SimplifiedCommentDto> simplifiedCommentDtoList;
}
