package com.mervekeser.library.services;

import com.mervekeser.library.domain.entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
}
