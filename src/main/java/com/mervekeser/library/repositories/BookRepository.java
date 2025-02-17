package com.mervekeser.library.repositories;

import com.mervekeser.library.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    boolean existsByTitleIgnoreCase(String title);
}
