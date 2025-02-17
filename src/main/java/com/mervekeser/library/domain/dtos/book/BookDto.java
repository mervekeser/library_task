package com.mervekeser.library.domain.dtos.book;

import com.mervekeser.library.domain.dtos.author.AuthorDto;
import com.mervekeser.library.domain.dtos.publisher.PublisherDto;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Set;

@Builder
public record BookDto(
        String title,
        BigDecimal price,
        String isbn13,
        Integer editionYear,
        PublisherDto publisherDto,
        Set<AuthorDto> authors
) {
}
