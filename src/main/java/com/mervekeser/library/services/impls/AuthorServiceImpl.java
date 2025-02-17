package com.mervekeser.library.services.impls;

import com.mervekeser.library.domain.entities.Author;
import com.mervekeser.library.repositories.AuthorRepository;
import com.mervekeser.library.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;


    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        if (authorRepository.existsByFullnameIgnoreCase(author.getFullname())){
            throw new IllegalArgumentException("Author already exists with fullname: " + author.getFullname());
        }
        return authorRepository.save(author);
    }
}
