package com.nonIt.GameOn.service.restDto;

import com.nonIt.GameOn.entity.Role;
import com.nonIt.GameOn.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleAssignmentRestDto {
    private Integer id;

    private Role role;

    private User users;

    private LocalDateTime assignedDate;

    private LocalDateTime updatedDate;
}