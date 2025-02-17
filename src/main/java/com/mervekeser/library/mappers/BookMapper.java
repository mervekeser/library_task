package com.mervekeser.library.mappers;

import com.mervekeser.library.domain.dtos.book.BookDto;
import com.mervekeser.library.domain.dtos.book.CreateBookRequest;
import com.mervekeser.library.domain.dtos.book.CreateBookRequestDto;
import com.mervekeser.library.domain.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    BookDto toDto(Book book);
    CreateBookRequest toCreateBookRequest(CreateBookRequestDto createBookRequestDto);
}
