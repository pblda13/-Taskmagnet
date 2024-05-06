package com.projeto.taskmagnetdemo.repository;

import com.projeto.taskmagnetdemo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

    Task findByTitle(String title);

    Task findByStatus(String status);
}
