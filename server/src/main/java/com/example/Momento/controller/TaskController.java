package com.example.Momento.controller;

import com.example.Momento.model.Task;
import com.example.Momento.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    public TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    public Task postTask(@RequestBody Task newTask){
        System.out.println("In controller");
        return taskService.saveTask(newTask);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@RequestBody Task newTask, @PathVariable Long id) {
        if(taskService.findById(id)!=null){
            taskService.deleteById(id);
            return taskService.saveTask(newTask);
        }
        else{
            return taskService.saveTask(newTask);
        }
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }
   
}