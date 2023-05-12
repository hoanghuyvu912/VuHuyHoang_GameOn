package com.nonIt.GameOn.service;

import com.nonIt.GameOn.service.dto.PublisherDto;
import com.nonIt.GameOn.service.restDto.PublisherRestDto;

import java.util.List;

public interface PublisherService {
    List<PublisherRestDto> getAll();

    PublisherRestDto findById(Integer PublisherId);

    PublisherRestDto createPublisher(PublisherDto PublisherDto);

    PublisherRestDto updatePublisher(Integer PublisherId, PublisherDto PublisherDto);

    void deletePublisher(Integer PublisherId);
}
