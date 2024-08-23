package com.riwi.todo_list_thymeleaf_jpa_mysql.controllers;

import com.riwi.todo_list_thymeleaf_jpa_mysql.entities.Task;
import com.riwi.todo_list_thymeleaf_jpa_mysql.services.TasksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    private final Logger logger = LoggerFactory.getLogger(TasksController.class);
    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public String showAllTasks(Model model) {
        var tasks = this.tasksService.findAll();

        model.addAttribute("tasks", tasks);
        return "tasks/list.html";
    }

    @GetMapping("/{id}")
    public String showTask(@PathVariable Long id, Model model) {
        var task = this.tasksService.findById(id);
        if(task.isPresent()){
            model.addAttribute("task", task.get());
            return "tasks/task";    //Se tiene que dejar la dirección de la vista
        }

        model.addAttribute("taskId", id);
        return "tasks/empty";    //Se tiene que dejar la dirección de la vista
    }

    @GetMapping("/delete/{id}")
    public String showDeletingTask(@PathVariable Long id, Model model) {
        var task = this.tasksService.findById(id);

        if (task.isEmpty()) {
            model.addAttribute("taskId", id);
            return "tasks/empty";
        }

        // Delete task
        try {
            this.tasksService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            logger.warn(String.format("Error: Attempting to delete a task which doesn't exist. Error Message: %s", e.getMessage()));
        }

        model.addAttribute("task", task.get());
        return "tasks/success_deleting";
    }

    @GetMapping("/create")
    public String showCreateTask() {
        return "tasks/create";
    }

    @PostMapping
    public String createTask(@RequestBody Task task, Model model) {
        var createdTask = this.tasksService.save(task);
        model.addAttribute("task", createdTask);
        return "tasks/task";
    }
}
