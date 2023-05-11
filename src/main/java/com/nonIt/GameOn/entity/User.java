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
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone_num")
    private String tel;

    @Column(name = "address")
    private String address;

    @Column(name = "dob")
    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "profile_img")
    private String profileImg;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "active")
    private boolean active;
}
