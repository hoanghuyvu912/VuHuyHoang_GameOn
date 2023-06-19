package com.nonIt.GameOn.rest.resourcesdto;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.entity.Publisher;
import com.nonIt.GameOn.entity.ReceiptDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private String developerName;
    private Integer publisherId;
    private String publisherName;

    private List<SimplifiedCommentDto> simplifiedCommentDtoList = new ArrayList<>();
}
