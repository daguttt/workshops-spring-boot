package com.riwi.api_rest_events.dtos;

import org.slf4j.Logger;

import com.riwi.api_rest_events.entities.Event;

public class EventsMapper {
  public static Logger logger = org.slf4j.LoggerFactory.getLogger(EventsMapper.class);

  public static Event toEntity(CreateEventDto dto) {
    logger.debug("Mapping createEventDto", dto);
    return new Event(dto.getName(), dto.getDate(), dto.getLocation(), dto.getCapacity());
  }
}
