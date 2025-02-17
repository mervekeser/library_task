package com.mervekeser.library.services.impls;

import com.mervekeser.library.domain.dtos.book.CreateBookRequest;
import com.mervekeser.library.domain.dtos.book.UpdateBookRequest;
import com.mervekeser.library.domain.entities.Author;
import com.mervekeser.library.domain.entities.Book;
import com.mervekeser.library.domain.entities.Publisher;
import com.mervekeser.library.repositories.BookRepository;
import com.mervekeser.library.services.AuthorService;
import com.mervekeser.library.services.BookService;
import com.mervekeser.library.services.PublisherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public Book updateBook(UUID id, UpdateBookRequest updateBookRequest) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Book does not exist with id:" + id));

        existingBook.setTitle(updateBookRequest.getTitle());
        existingBook.setPrice(updateBookRequest.getPrice());
        existingBook.setIsbn13(updateBookRequest.getIsbn13());
        existingBook.setEditionYear(updateBookRequest.getEditionYear());

        UUID updateBookRequestPublisherId = updateBookRequest.getPublisherId();
        if(!existingBook.getPublisher().getId().equals(updateBookRequestPublisherId)){
            Publisher newPublisher = publisherService.getPublisherById(updateBookRequestPublisherId);
            existingBook.setPublisher(newPublisher);
        }

        Set<UUID> existingAuthorIds = existingBook.getAuthors().stream().map(Author::getId).collect(Collectors.toSet());
        Set<UUID> updateBookRequestAuthorIds = updateBookRequest.getAuthorIds();
        if(!existingAuthorIds.equals(updateBookRequestAuthorIds)){
            List<Author> newAuthors = authorService.getAuthorByIds(updateBookRequestAuthorIds);
            existingBook.setAuthors(new HashSet<>(newAuthors));
        }

        return bookRepository.save(existingBook);
    }

    @Override
    public Book getBookbyId(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Book does not exist with id: "+ id));

        return book;
    }

    @Override
    public void deleteBook(UUID id) {
        Book book = getBookbyId(id);

        bookRepository.delete(book);
    }


}
