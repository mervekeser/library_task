package com.mervekeser.library.services.impls;

import com.mervekeser.library.domain.dtos.book.CreateBookRequest;
import com.mervekeser.library.domain.entities.Author;
import com.mervekeser.library.domain.entities.Book;
import com.mervekeser.library.domain.entities.Publisher;
import com.mervekeser.library.repositories.BookRepository;
import com.mervekeser.library.services.AuthorService;
import com.mervekeser.library.services.BookService;
import com.mervekeser.library.services.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final PublisherService publisherService;
    private final AuthorService authorService;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(CreateBookRequest createBookRequest) {
        Book newBook = new Book();
        newBook.setTitle(createBookRequest.getTitle());
        newBook.setPrice(createBookRequest.getPrice());
        newBook.setEditionYear(createBookRequest.getEditionYear());
        newBook.setIsbn13(createBookRequest.getIsbn13());

        Publisher publisher = publisherService.getPublisherById(createBookRequest.getPublisherId());
        newBook.setPublisher(publisher);

        Set<UUID> authorIds = createBookRequest.getAuthorIds();
        List<Author> authors = authorService.getAuthorByIds(authorIds);
        newBook.setAuthors(new HashSet<>(authors));


        return bookRepository.save(newBook);
    }
}
