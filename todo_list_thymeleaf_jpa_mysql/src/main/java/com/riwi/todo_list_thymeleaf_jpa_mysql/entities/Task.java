package com.riwi.todo_list_thymeleaf_jpa_mysql.entities;

import com.riwi.todo_list_thymeleaf_jpa_mysql.enums.TaskState;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 100, nullable = false)
    String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TaskState state;

    @Column(name = "creation_date", length = 100, nullable = false)
    LocalDate creationDate;

    @Column(name = "creation_time", length = 100, nullable = false)
    LocalTime creationTime;


}
