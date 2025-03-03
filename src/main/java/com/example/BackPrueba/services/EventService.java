package com.example.BackPrueba.services;

import com.example.BackPrueba.models.entities.Event;
import com.example.BackPrueba.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> consultAll() {
        return repository.findAll();
    }

    public Optional<Event> consultId(Long id) {
        return repository.findById(id);
    }

    public Event createEvent(Event event) {
        return repository.save(event);
    }

    public Event updateEvent(Long id, Event event) {
        if (repository.existsById(id)) {
            event.setId(id);
            return repository.save(event);
        }
        return null;
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }
}



