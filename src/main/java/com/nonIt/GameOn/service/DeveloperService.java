package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.DeveloperDto;
import com.nonIt.GameOn.service.restDto.DeveloperRestDto;

import java.time.LocalDate;
import java.util.List;

public interface DeveloperService {
    List<DeveloperRestDto> getAll();

    List<DeveloperRestDto> findByName(String name);

    List<DeveloperRestDto> findByEstablishedDateAfter(LocalDate date);
    List<DeveloperRestDto> findByEstablishedDateBefore(LocalDate date);

    DeveloperRestDto findById(Integer developerId);

    DeveloperRestDto createDeveloper(DeveloperDto developerDto);

    DeveloperRestDto updateDeveloper(Integer developerId, DeveloperDto developerDto);

    void deleteDeveloper(Integer developerId);
}
