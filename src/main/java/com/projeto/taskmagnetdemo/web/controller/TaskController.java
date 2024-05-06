package com.projeto.taskmagnetdemo.web.controller;

import com.projeto.taskmagnetdemo.model.Task;
import com.projeto.taskmagnetdemo.service.Impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;


    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        try {
            Task newTask = taskService.create(task);
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task) {
        try {
            Task updated = taskService.update(id, task);
            return ResponseEntity.ok().body(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable Long id) {
        try {
            Optional<Task> find = taskService.findById(id);
            return ResponseEntity.ok().body(find);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{title}")
    public ResponseEntity<Task> findByTitle(@PathVariable String title) {
        try {
            Task find = taskService.findByTitle(title);
            return ResponseEntity.ok().body(find);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{status}")
    public ResponseEntity<Task> findByStatus(@PathVariable String status) {
        try {
            Task find = taskService.findByStatus(status);
            return ResponseEntity.ok().body(find);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
