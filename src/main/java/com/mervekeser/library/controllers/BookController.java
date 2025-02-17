package com.mervekeser.library.controllers;

import com.mervekeser.library.domain.dtos.book.BookDto;
import com.mervekeser.library.domain.entities.Book;
import com.mervekeser.library.mappers.BookMapper;
import com.mervekeser.library.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
