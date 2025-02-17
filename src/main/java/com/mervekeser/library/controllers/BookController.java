package com.mervekeser.library.controllers;

import com.mervekeser.library.domain.dtos.book.*;
import com.mervekeser.library.domain.entities.Book;
import com.mervekeser.library.mappers.BookMapper;
import com.mervekeser.library.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PutMapping(path = "/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable UUID id,
                                              @Valid @RequestBody UpdateBookRequestDto updateBookRequestDto){
        UpdateBookRequest updateBookRequest = bookMapper.toUpdateBookRequest(updateBookRequestDto);
        Book updatedBook = bookService.updateBook(id, updateBookRequest);

        BookDto savedBookDto = bookMapper.toDto(updatedBook);

        return ResponseEntity.ok(savedBookDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable UUID id){
        Book book = bookService.getBookbyId(id);
        BookDto bookDto = bookMapper.toDto(book);

        return ResponseEntity.ok(bookDto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID id){
        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }
}
