package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.UserRoleAssignment;
import com.nonIt.GameOn.service.createdto.UserRoleAssignmentDto;
import com.nonIt.GameOn.service.restdto.UserRoleAssignmentRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleAssignmentMapper extends EntityMapper<UserRoleAssignmentRestDto, UserRoleAssignment, UserRoleAssignmentDto> {
}
