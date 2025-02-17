package com.mervekeser.library.services;

import com.mervekeser.library.domain.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
}
