package com.riwi.todo_list_thymeleaf_jpa_mysql.controllers;

import com.riwi.todo_list_thymeleaf_jpa_mysql.entities.Task;
import com.riwi.todo_list_thymeleaf_jpa_mysql.services.TasksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
