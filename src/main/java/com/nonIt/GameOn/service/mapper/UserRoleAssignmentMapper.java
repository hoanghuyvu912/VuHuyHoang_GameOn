package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.UserRoleAssignment;
import com.nonIt.GameOn.service.dto.UserRoleAssignmentDto;
import com.nonIt.GameOn.service.restDto.UserRoleAssignmentRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleAssignmentMapper extends EntityMapper<UserRoleAssignmentRestDto, UserRoleAssignment, UserRoleAssignmentDto> {
}
