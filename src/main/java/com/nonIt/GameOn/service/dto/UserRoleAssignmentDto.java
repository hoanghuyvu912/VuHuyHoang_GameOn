package com.nonIt.GameOn.service.dto;

import com.nonIt.GameOn.entity.Role;
import com.nonIt.GameOn.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleAssignmentDto {
    private LocalDateTime assignedDate;
    private Role role;
    private LocalDateTime updatedDate;
    private Integer userId;
}
