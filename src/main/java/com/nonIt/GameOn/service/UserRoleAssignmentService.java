package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.UserRoleAssignmentDto;
import com.nonIt.GameOn.service.restDto.UserRoleAssignmentRestDto;

public interface UserRoleAssignmentService {
    UserRoleAssignmentRestDto createUserRoleAssignment(UserRoleAssignmentDto userRoleAssignmentDto);
}
