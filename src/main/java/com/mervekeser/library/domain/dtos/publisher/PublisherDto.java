package com.mervekeser.library.domain.dtos.publisher;

import com.mervekeser.library.domain.dtos.book.BookDto;
import lombok.Builder;

import java.util.List;

@Builder
public record PublisherDto(
        String name,
        List<BookDto> books
) {
}
