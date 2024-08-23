package com.riwi.todo_list_thymeleaf_jpa_mysql.services;

import com.riwi.todo_list_thymeleaf_jpa_mysql.entities.Task;
import com.riwi.todo_list_thymeleaf_jpa_mysql.repositories.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Task> findAll() {
        return this.tasksRepository.findAll();
    }

    public Optional<Task> findById(Long id){
        return this.tasksRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.tasksRepository.deleteById(id);
    }

    public Task save(Task baseTask) {
        return this.tasksRepository.save(baseTask);
    }
}
