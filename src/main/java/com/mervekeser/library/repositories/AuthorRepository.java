package com.mervekeser.library.repositories;

import com.mervekeser.library.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    boolean existsByFullnameIgnoreCase(String fullname);
}
