package com.mervekeser.library.services;

import com.mervekeser.library.domain.dtos.book.CreateBookRequest;
import com.mervekeser.library.domain.dtos.book.UpdateBookRequest;
import com.mervekeser.library.domain.entities.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Book> getAllBooks();
    Book createBook(CreateBookRequest createBookRequest);
    Book updateBook(UUID id, UpdateBookRequest updateBookRequest);
    Book getBookbyId(UUID id);
    void deleteBook(UUID id);
}
