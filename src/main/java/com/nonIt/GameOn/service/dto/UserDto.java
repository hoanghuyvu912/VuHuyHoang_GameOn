package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.entity.Role;
import com.nonIt.GameOn.entity.UserRoleAssignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String tel;

    private String address;

    private LocalDate dob;

    private Gender gender;

//    private String profileImg;
    private byte[] profileImg;

    private Double balance;

    private LocalDate registeredDate;

    private List<Role> roles = new ArrayList<>();

//    private UserRoleAssignmentDto userRoleAssignmentDto;

    private boolean active;
}
