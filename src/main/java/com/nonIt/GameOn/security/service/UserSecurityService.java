package com.nonIt.GameOn.security.service;

import com.nonIt.GameOn.security.service.dto.UserSecurityDto;

import java.util.List;

public interface UserSecurityService {
    List<UserSecurityDto> getSecurityUsers();
}
