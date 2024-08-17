package com.riwi.todo_list_thymeleaf_jpa_mysql.entities;

import com.riwi.todo_list_thymeleaf_jpa_mysql.enums.TaskState;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tasks")
public class Task {

    public Task() {
    }

    public Task(Long id, String description, TaskState state, LocalDate creationDate, LocalTime creationTime) {
        this.id = id;
        this.description = description;
        this.state = state;
        this.creationDate = creationDate;
        this.creationTime = creationTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 150, nullable = false)
    String title;

    @Column(length = 255, nullable = false)
    String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TaskState state;

    @Column(name = "creation_date", nullable = false)
    LocalDate creationDate;

    @Column(name = "creation_time", nullable = false)
    LocalTime creationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Task: {" + "\n" +
                "id= " + id + ",\n" +
                "title= " + title + ",\n" +
                "description= " + description + ",\n" +
                "state= " + state + ",\n" +
                "creationDate= " + creationDate + ",\n" +
                "creationTime= " + creationTime + ",\n" +
                '}';
    }
}
