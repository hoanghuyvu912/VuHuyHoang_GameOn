package com.nonIt.GameOn.entity;

//import jakarta.persistence.*;
import lombok.*;
import javax.persistence.*;


import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "game_name", length = 2000)
    private String name;

    @Column(name = "thumbnail", length = 2000)
    private String thumbnail;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "trailer", length = 3000)
    private String trailer;

    @Column(name = "released_date")
    private LocalDate releasedDate;

    @Column(name = "system_req", length = 5000)
    private String systemReq;

    @Column(name = "price", columnDefinition="Decimal(4,2)")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
