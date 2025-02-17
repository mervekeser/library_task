package com.mervekeser.library.domain.dtos.author;

import com.mervekeser.library.domain.dtos.book.BookDto;
import lombok.Builder;

import java.util.Set;

@Builder
public record AuthorDto(
        String fullname,
        Set<BookDto> books
) {
}
