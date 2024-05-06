package com.projeto.taskmagnetdemo.service.Impl;

import com.projeto.taskmagnetdemo.model.Task;
import com.projeto.taskmagnetdemo.repository.TaskRepository;
import com.projeto.taskmagnetdemo.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    @Override
    public Task findByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public Task update(Long id,Task task) {
      Task existingTask = taskRepository.findById(id)
              .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
      existingTask.setTitle(task.getTitle());
      existingTask.setDescription(task.getDescription());
      existingTask.setDeadline(task.getDeadline());
      existingTask.setStatus(task.getStatus());

        return taskRepository.save(existingTask);
    }

    @Override
    public void delete(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
        taskRepository.deleteById(id);
    }
}
