package com.mervekeser.library.mappers;

import com.mervekeser.library.domain.dtos.publisher.PublisherDto;
import com.mervekeser.library.domain.entities.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PublisherMapper {
    PublisherDto toDto(Publisher publisher);
    Publisher toEntity(PublisherDto publisherDto);
}
