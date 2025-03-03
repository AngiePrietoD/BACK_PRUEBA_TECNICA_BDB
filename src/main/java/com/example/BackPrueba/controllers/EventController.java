package com.example.BackPrueba.controllers;

import com.example.BackPrueba.models.entities.Event;
import com.example.BackPrueba.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public List<Event> consultAll() {
        return service.consultAll();
    }

    @GetMapping("/{id}")
    public Optional<Event> consultId(@PathVariable Long id) {
        return service.consultId(id);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return service.createEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return service.updateEvent(id, event);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
        return ResponseEntity.ok("Evento con ID " + id + " eliminado exitosamente.");
    }
}

