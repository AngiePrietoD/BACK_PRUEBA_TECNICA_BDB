package com.example.BackPrueba.services;

import com.example.BackPrueba.models.entities.Event;
import com.example.BackPrueba.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    private Event event;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        event = new Event(1L, "Event Title", "2025-03-03", "Event Description", "Event Location");
    }

    @Test
    void testConsultAll() {
        // Arrange
        Mockito.when(eventRepository.findAll()).thenReturn(Arrays.asList(event));

        // Act
        var result = eventService.consultAll();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Event Title", result.get(0).getTitle());
        assertEquals("2025-03-03", result.get(0).getDate());
        assertEquals("Event Description", result.get(0).getDescription());
        assertEquals("Event Location", result.get(0).getLocation());
    }

    @Test
    void testConsultId() {
        // Arrange
        Mockito.when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        // Act
        Optional<Event> result = eventService.consultId(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Event Title", result.get().getTitle());
        assertEquals("2025-03-03", result.get().getDate());
        assertEquals("Event Description", result.get().getDescription());
        assertEquals("Event Location", result.get().getLocation());
    }

    @Test
    void testCreateEvent() {
        Event newEvent = new Event(1L, "Event Title", "2025-03-03", "Event Description", "Event Location");
        Mockito.when(eventRepository.save(newEvent)).thenReturn(new Event(1L, "Event Title", "2025-03-03", "Event Description", "Event Location"));

        Event result = eventService.createEvent(newEvent);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Event Title", result.getTitle());
        assertEquals("2025-03-03", result.getDate());
        assertEquals("Event Description", result.getDescription());
        assertEquals("Event Location", result.getLocation());
    }

    @Test
    void testUpdateEvent() {
        // Arrange
        Event updatedEvent = new Event(1L, "Event Title", "2025-03-03", "Event Description", "Event Location");
        Mockito.when(eventRepository.existsById(1L)).thenReturn(true);
        Mockito.when(eventRepository.save(updatedEvent)).thenReturn(new Event( 1L, "Event Title", "2025-03-03", "Event Description", "Event Location"));

        // Act
        Event result = eventService.updateEvent(1L, updatedEvent);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Event Title", result.getTitle());
        assertEquals("2025-03-03", result.getDate());
        assertEquals("Event Description", result.getDescription());
        assertEquals("Event Location", result.getLocation());
    }

    @Test
    void testUpdateEventNotFound() {
        // Arrange
        Event updatedEvent = new Event(1L, "Event Title", "2025-03-03", "Event Description", "Event Location");
        Mockito.when(eventRepository.existsById(1L)).thenReturn(false);

        // Act
        Event result = eventService.updateEvent(1L, updatedEvent);

        // Assert
        assertNull(result);
    }

    @Test
    void testDeleteEvent() {
        // Arrange
        Mockito.doNothing().when(eventRepository).deleteById(1L);

        // Act
        eventService.deleteEvent(1L);

        // Assert
        Mockito.verify(eventRepository, Mockito.times(1)).deleteById(1L);
    }
}

