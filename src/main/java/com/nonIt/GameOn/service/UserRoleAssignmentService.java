package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.createdto.UserRoleAssignmentDto;
import com.nonIt.GameOn.service.restdto.UserRoleAssignmentRestDto;

public interface UserRoleAssignmentService {
    UserRoleAssignmentRestDto createUserRoleAssignment(UserRoleAssignmentDto userRoleAssignmentDto);

    UserRoleAssignmentRestDto updateUserRoleAssignment(UserRoleAssignmentDto userRoleAssignmentDto, Integer userRoleAssignmentId);
}
