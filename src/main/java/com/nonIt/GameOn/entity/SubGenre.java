package com.nonIt.GameOn.entity;

//import jakarta.persistence.*;
import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sub_genre")
public class SubGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sub_genre_name", length = 500)
    private String name;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
