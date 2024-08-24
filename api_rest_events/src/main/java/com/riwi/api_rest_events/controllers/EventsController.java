package com.riwi.api_rest_events.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.api_rest_events.dtos.CreateEventDto;
import com.riwi.api_rest_events.dtos.EventsMapper;
import com.riwi.api_rest_events.entities.Event;
import com.riwi.api_rest_events.services.interfaces.IEventsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/events")
@Validated
public class EventsController {
  // Add a logger
  // private final Logger logger =
  // LoggerFactory.getLogger(EventsController.class);

  @Autowired
  private IEventsService eventsService;

  @GetMapping
  public List<Event> findAll() {
    return this.eventsService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Event> findById(@PathVariable String id) {
    // if (this.eventsService.findById(id).isEmpty()) {
    // return ResponseEntity.notFound().build();
    // }
    // return ResponseEntity.ok(this.eventsService.findById(id).get());

    // Shortcut to the above ⬆️
    // (Docs link:
    // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html#of(java.util.Optional))
    return ResponseEntity.of(this.eventsService.findById(id));
  }

  @PostMapping
  public ResponseEntity<Event> save(@Valid @RequestBody CreateEventDto createEventDto) {
    // this.logger.debug(baseEvent.getDate().toString());
    // this.logger.debug("Default Time Zone: " + TimeZone.getDefault().getID());
    var baseEvent = EventsMapper.toEntity(createEventDto);
    return new ResponseEntity<Event>(
        this.eventsService.save(baseEvent),
        HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Event> update(@PathVariable String id, @RequestBody Event baseEvent) {
    if (this.eventsService.findById(id).isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(this.eventsService.save(baseEvent));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable String id) {
    if (this.eventsService.findById(id).isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    this.eventsService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(
      MethodArgumentNotValidException exception) {
    Map<String, String> errors = new HashMap<>();
    exception.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }
}