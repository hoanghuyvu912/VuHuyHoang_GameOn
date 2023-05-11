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
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "game_name")
    private String name;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "description")
    private String description;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "released_date")
    private LocalDate releasedDate;

    @Column(name = "system_req")
    private String systemReq;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Developer publisher;
}
