package com.nonIt.GameOn.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "thumbnail", length = 1000)
    private String thumbnail;

    @Column(name = "cover_photo", length = 1000)
    private String coverPhoto;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "established_date")
    private LocalDate establishedDate;
}
