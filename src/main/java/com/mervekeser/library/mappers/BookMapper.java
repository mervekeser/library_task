package com.mervekeser.library.mappers;

import com.mervekeser.library.domain.dtos.book.*;
import com.mervekeser.library.domain.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
    BookDto toDto(Book book);
    CreateBookRequest toCreateBookRequest(CreateBookRequestDto createBookRequestDto);
    UpdateBookRequest toUpdateBookRequest(UpdateBookRequestDto updateBookRequestDto);
}
