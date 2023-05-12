package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.service.dto.UserDto;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserRestDto, User, UserDto>{
//    UserDto toDto(User user);
//
//    List<UserDto> toDtos(List<User> users);
//
//    UserRestDto toRestDto(User user);
//
//    List<UserRestDto> toRestDtos(List<User> users);
}
