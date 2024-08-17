package com.riwi.todo_list_thymeleaf_jpa_mysql.repositories;

import com.riwi.todo_list_thymeleaf_jpa_mysql.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task, Long> {

}
