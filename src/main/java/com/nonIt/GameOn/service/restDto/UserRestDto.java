package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.entity.Role;

import java.time.LocalDate;

public class UserRestDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String tel;

    private String address;

    private LocalDate dob;

    private Gender gender;

    private String profileImg;

    private Double balance;

    private Role role;

    private boolean active;
}
