package com.mervekeser.library.services.impls;

import com.mervekeser.library.domain.entities.Author;
import com.mervekeser.library.repositories.AuthorRepository;
import com.mervekeser.library.services.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

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

    @Override
    public List<Author> getAuthorByIds(Set<UUID> ids) {
        List<Author> authors = authorRepository.findAllById(ids);

        if(authors.size() != ids.size()){
            throw  new EntityNotFoundException("Author does not exist with id: " + ids);
        }

        return authors;
    }
}
