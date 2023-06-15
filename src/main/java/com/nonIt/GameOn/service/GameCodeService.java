package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.GameCodeDto;
import com.nonIt.GameOn.service.restDto.GameCodeRestDto;

import java.util.List;

public interface GameCodeService {
    List<GameCodeRestDto> getAll();
}
