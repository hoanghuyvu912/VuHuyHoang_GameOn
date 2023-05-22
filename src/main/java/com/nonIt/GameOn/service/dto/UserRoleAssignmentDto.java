package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Role;
import com.nonIt.GameOn.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleAssignmentDto {
    private LocalDate assignedDate;
    private Role role;
    private LocalDate updatedDate;
    private Integer userId;
}
