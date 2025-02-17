package com.mervekeser.library.controllers;

import com.mervekeser.library.domain.dtos.publisher.CreatePublisherRequest;
import com.mervekeser.library.domain.dtos.publisher.PublisherDto;
import com.mervekeser.library.domain.entities.Publisher;
import com.mervekeser.library.mappers.PublisherMapper;
import com.mervekeser.library.services.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/publishers")
public class PublisherController {
    private final PublisherService publisherService;
    private final PublisherMapper publisherMapper;

    @GetMapping
    public ResponseEntity<List<PublisherDto>> getAllPublishers(){
        List<Publisher> publishers = publisherService.getAllPublishers();

        List<PublisherDto> publisherDtos = publishers.stream()
                .map(publisherMapper::toDto)
                .toList();

        return ResponseEntity.ok(publisherDtos);
    }

    @PostMapping
    public ResponseEntity<PublisherDto> createPublisher(CreatePublisherRequest createPublisherRequest){
        Publisher publisher = publisherMapper.toEntity(createPublisherRequest);
        Publisher savedPublisher = publisherService.createPublisher(publisher);

        return new ResponseEntity<>(
                publisherMapper.toDto(savedPublisher),
                HttpStatus.CREATED
        );
    }
}
