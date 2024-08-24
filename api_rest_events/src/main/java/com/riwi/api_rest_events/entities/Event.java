package com.riwi.api_rest_events.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
  private LocalDate date;
  private String location;
  private Integer capacity;

  public Event(String name, LocalDate date, String location, Integer capacity) {
    this.name = name;
    this.date = date;
    this.location = location;
    this.capacity = capacity;
  }
}
