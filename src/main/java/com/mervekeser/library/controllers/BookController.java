package com.mervekeser.library.controllers;

import com.mervekeser.library.domain.dtos.book.BookDto;
import com.mervekeser.library.domain.dtos.book.CreateBookRequest;
import com.mervekeser.library.domain.dtos.book.CreateBookRequestDto;
import com.mervekeser.library.domain.entities.Book;
import com.mervekeser.library.mappers.BookMapper;
import com.mervekeser.library.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;


    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();

        List<BookDto> bookDtos = books.stream()
                .map(bookMapper::toDto)
                .toList();

        return ResponseEntity.ok(bookDtos);

    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody CreateBookRequestDto createBookRequestDto){
        CreateBookRequest createBookRequest = bookMapper.toCreateBookRequest(createBookRequestDto);
        Book savedBook = bookService.createBook(createBookRequest);

        BookDto savedBookDto = bookMapper.toDto(savedBook);

        return new ResponseEntity<>(
                savedBookDto,
                HttpStatus.CREATED
        );
    }
}
