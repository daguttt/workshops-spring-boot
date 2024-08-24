package com.riwi.api_rest_events.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.riwi.api_rest_events.entities.Event;

public interface IEventsService {
  Event save(Event basEvent);

  List<Event> findAll();

  Optional<Event> findById(String id);

  void deleteById(String id);
}
