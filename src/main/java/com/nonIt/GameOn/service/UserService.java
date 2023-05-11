package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.UserDto;
import com.nonIt.GameOn.service.restDto.UserRestDto;

import java.util.List;

public interface UserService {
    List<UserRestDto> getAll();

    UserRestDto findById(Integer userId);
}
