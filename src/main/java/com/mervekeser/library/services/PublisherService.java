package com.mervekeser.library.services;

import com.mervekeser.library.domain.entities.Publisher;

import java.util.List;
import java.util.UUID;

public interface PublisherService {
    List<Publisher> getAllPublishers();
    Publisher createPublisher(Publisher publisher);
    Publisher getPublisherById(UUID id);
}
