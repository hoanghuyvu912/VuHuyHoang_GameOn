package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.entity.Role;
import jakarta.persistence.*;

import java.time.LocalDate;

public class UserDto {
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
