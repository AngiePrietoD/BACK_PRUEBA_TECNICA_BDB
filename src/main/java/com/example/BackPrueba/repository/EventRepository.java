package com.example.BackPrueba.repository;

import com.example.BackPrueba.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Long> {
}

