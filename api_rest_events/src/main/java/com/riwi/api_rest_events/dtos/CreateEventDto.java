package com.riwi.api_rest_events.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateEventDto {
  @NotBlank(message = "The name cannot be blank")
  @Size(max = 255, message = "The name cannot be longer than 255 characters")
  private String name;

  @Future(message = "The date must be in the future")
  private LocalDate date;

  @NotBlank(message = "The location cannot be blank")
  @Size(max = 255, message = "The name cannot be longer than 255 characters")
  private String location;

  @Positive(message = "The capacity must be positive")
  @Max(value = 100, message = "The capacity cannot be greater than 100")
  private Integer capacity;
}
