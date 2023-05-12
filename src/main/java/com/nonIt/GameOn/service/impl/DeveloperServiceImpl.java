package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Developer;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.DeveloperRepository;
import com.nonIt.GameOn.service.DeveloperService;
import com.nonIt.GameOn.service.dto.DeveloperDto;
import com.nonIt.GameOn.service.mapper.DeveloperMapper;
import com.nonIt.GameOn.service.restDto.DeveloperRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    @Override
    public List<DeveloperRestDto> getAll() {
        return developerRepository.findAll().stream().map(developerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DeveloperRestDto findById(Integer developerId) {
        Developer developer = developerRepository.findById(developerId).orElseThrow(GameOnException::DeveloperNotFound);
        return developerMapper.toDto(developer);
    }

    @Override
    public DeveloperRestDto createDeveloper(DeveloperDto developerDto) {
        Developer developer = Developer.builder()
                .name(developerDto.getName())
                .description(developerDto.getDescription())
                .thumbnail(developerDto.getThumbnail())
                .coverPhoto(developerDto.getCoverPhoto())
                .establishedDate(developerDto.getEstablishedDate())
                .build();

        developer = developerRepository.save(developer);
        return developerMapper.toDto(developer);
    }

    @Override
    public DeveloperRestDto updateDeveloper(Integer developerId, DeveloperDto developerDto) {
        Developer developer = developerRepository.findById(developerId).orElseThrow(GameOnException::DeveloperNotFound);
        developerMapper.updateFromDto(developerDto, developer);
        developer = developerRepository.save(developer);
        return developerMapper.toDto(developer);
    }

    @Override
    public void deleteDeveloper(Integer developerId) {
        developerRepository.deleteById(developerId);
    }
}
