package com.nonIt.GameOn.repository.CustomRepository.GameCustomRespository;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.service.customDto.GameSearchDto;

import java.util.List;

public interface CustomGameRepository {
    List<Game> findGamesBySystemReqAndPriceLessThan(String systemReq, Double price);

    List<Game> findGamesByDto(GameSearchDto gameSearchDto);
}
