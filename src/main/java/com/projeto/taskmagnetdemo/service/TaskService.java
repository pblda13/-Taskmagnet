package com.projeto.taskmagnetdemo.service;

import com.projeto.taskmagnetdemo.model.Task;

import java.util.Optional;

public interface TaskService {

    Task create(Task task);
    Optional<Task> findById(Long id);
    Task findByTitle(String title);
    Task findByStatus(String status);
    Task update(Long id,Task task);
    void delete(Long id);

}
