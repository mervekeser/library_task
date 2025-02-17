package com.mervekeser.library.mappers;

import com.mervekeser.library.domain.dtos.author.AuthorDto;
import com.mervekeser.library.domain.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {
    AuthorDto toDto(Author author);
    Author toEntity(AuthorDto authorDto);
}
