package com.mervekeser.library.repositories;

import com.mervekeser.library.domain.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
    boolean existsByNameIgnoreCase(String name);
}
