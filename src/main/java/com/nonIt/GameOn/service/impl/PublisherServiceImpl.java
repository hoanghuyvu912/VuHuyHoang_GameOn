package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Publisher;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.PublisherRepository;
import com.nonIt.GameOn.service.PublisherService;
import com.nonIt.GameOn.service.dto.PublisherDto;
import com.nonIt.GameOn.service.mapper.PublisherMapper;
import com.nonIt.GameOn.service.restDto.PublisherRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository PublisherRepository;
    private final PublisherMapper PublisherMapper;

    @Override
    public List<PublisherRestDto> getAll() {
        return PublisherRepository.findAll().stream().map(PublisherMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PublisherRestDto findById(Integer PublisherId) {
        Publisher Publisher = PublisherRepository.findById(PublisherId).orElseThrow(GameOnException::PublisherNotFound);
        return PublisherMapper.toDto(Publisher);
    }

    @Override
    public PublisherRestDto createPublisher(PublisherDto PublisherDto) {
        Publisher publisher = Publisher.builder()
                .name(PublisherDto.getName())
                .description(PublisherDto.getDescription())
                .thumbnail(PublisherDto.getThumbnail())
                .coverPhoto(PublisherDto.getCoverPhoto())
                .establishedDate(PublisherDto.getEstablishedDate())
                .build();

        publisher = PublisherRepository.save(publisher);
        return PublisherMapper.toDto(publisher);
    }

    @Override
    public PublisherRestDto updatePublisher(Integer PublisherId, PublisherDto PublisherDto) {
        Publisher Publisher = PublisherRepository.findById(PublisherId).orElseThrow(GameOnException::PublisherNotFound);
        PublisherMapper.updateFromDto(PublisherDto, Publisher);
        Publisher = PublisherRepository.save(Publisher);
        return PublisherMapper.toDto(Publisher);
    }

    @Override
    public void deletePublisher(Integer PublisherId) {
        PublisherRepository.deleteById(PublisherId);
    }
}
