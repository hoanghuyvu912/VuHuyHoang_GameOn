package com.nonIt.GameOn.entity;

//import jakarta.persistence.*;
import lombok.*;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "developer")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "developer_name")
    private String name;

    @Column(name = "thumbnail", length = 1000)
    private String thumbnail;

    @Column(name = "cover_photo", length = 1000)
    private String coverPhoto;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "established_date")
    private LocalDate establishedDate;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.PERSIST)
    private List<Game> gameList = new ArrayList<>();
}
