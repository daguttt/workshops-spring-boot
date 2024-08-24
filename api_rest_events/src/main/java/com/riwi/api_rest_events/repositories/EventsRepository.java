package com.riwi.api_rest_events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.api_rest_events.entities.Event;

public interface EventsRepository extends JpaRepository<Event, String> {
}
