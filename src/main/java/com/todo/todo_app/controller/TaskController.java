package com.todo.todo_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;  // ✅ CORRECT

import com.todo.todo_app.models.Task;
import com.todo.todo_app.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public String geTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTasks(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggle(id);
        return "redirect:/";
    }
}
