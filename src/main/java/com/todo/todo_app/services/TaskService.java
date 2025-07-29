package com.todo.todo_app.services;

import com.sun.jdi.connect.Connector;
import com.todo.todo_app.models.Task;
import com.todo.todo_app.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    public TaskRepository taskRepository;
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        if(title.trim()!="") {
            task.setTitle(title);
            task.setCompleted(false);
            taskRepository.save(task);
        }
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggle(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
