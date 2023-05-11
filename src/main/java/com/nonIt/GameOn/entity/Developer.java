package com.nonIt.GameOn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "developer")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "developer_name")
    private String name;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "cover_photo")
    private String coverPhoto;

    @Column(name = "description")
    private String description;

    @Column(name = "established_date")
    private LocalDate establishedDate;
}
