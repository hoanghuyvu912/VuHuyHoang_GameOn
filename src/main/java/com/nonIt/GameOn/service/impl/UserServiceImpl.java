package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.service.UserService;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public List<UserRestDto> getAll() {
        return null;
    }

    @Override
    public UserRestDto findById(Integer userId) {
        return null;
    }
}
