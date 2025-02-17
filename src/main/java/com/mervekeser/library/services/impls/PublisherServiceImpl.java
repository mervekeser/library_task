package com.mervekeser.library.services.impls;

import com.mervekeser.library.domain.entities.Publisher;
import com.mervekeser.library.repositories.PublisherRepository;
import com.mervekeser.library.services.PublisherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;


    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        if(publisherRepository.existsByNameIgnoreCase(publisher.getName())){
            throw new IllegalArgumentException("Publisher already exists with name: " + publisher.getName());
        }
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(UUID id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Publisher does not exist with id " + id));
        return publisher;
    }
}
