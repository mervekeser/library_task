package com.mervekeser.library.services.impls;

import com.mervekeser.library.domain.entities.Book;
import com.mervekeser.library.repositories.BookRepository;
import com.mervekeser.library.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
