package com.mervekeser.library.services;

import com.mervekeser.library.domain.entities.Author;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author createAuthor(Author author);
    List<Author> getAuthorByIds(Set<UUID> ids);
}
