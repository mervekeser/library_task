package com.mervekeser.library.services;

import com.mervekeser.library.domain.entities.Publisher;

import java.util.List;

public interface PublisherService {
    List<Publisher> getAllPublishers();
    Publisher createPublisher(Publisher publisher);
}
