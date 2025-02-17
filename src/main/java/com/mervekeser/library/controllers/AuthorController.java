package com.mervekeser.library.controllers;

import com.mervekeser.library.domain.dtos.author.AuthorDto;
import com.mervekeser.library.domain.dtos.author.CreateAuthorRequest;
import com.mervekeser.library.domain.entities.Author;
import com.mervekeser.library.mappers.AuthorMapper;
import com.mervekeser.library.services.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        List<Author> authors = authorService.getAllAuthors();

        List<AuthorDto> authorDtos = authors.stream()
                .map(authorMapper::toDto)
                .toList();

        return ResponseEntity.ok(authorDtos);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody CreateAuthorRequest createAuthorRequest){
        Author author = authorMapper.toEntity(createAuthorRequest);
        Author savedAuthor = authorService.createAuthor(author);

        return new ResponseEntity<>(
                authorMapper.toDto(savedAuthor),
                HttpStatus.CREATED
        );
    }
}
