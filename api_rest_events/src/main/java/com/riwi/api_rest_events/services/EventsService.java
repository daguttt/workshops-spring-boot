package com.riwi.api_rest_events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.api_rest_events.entities.Event;
import com.riwi.api_rest_events.repositories.EventsRepository;
import com.riwi.api_rest_events.services.interfaces.IEventsService;

@Service
public class EventsService implements IEventsService {

  @Autowired
  private EventsRepository eventsRepository;

  @Override
  public Event save(Event basEvent) {
    return this.eventsRepository.save(basEvent);
  }

  @Override
  public List<Event> findAll() {
    return this.eventsRepository.findAll();
  }

  @Override
  public Optional<Event> findById(String id) {
    return this.eventsRepository.findById(id);
  }

  @Override
  public void deleteById(String id) {
    this.eventsRepository.deleteById(id);
  }

}
