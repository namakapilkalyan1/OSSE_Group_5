package com.example.Momento.service;

import com.example.Momento.model.Task;
import com.example.Momento.repository.TaskFileRepository;
import com.example.Momento.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskFileRepository taskFileRepository;

    public Task saveTask(Task newTask) {
        return taskFileRepository.saveTask(newTask);
    }

    public List<Task> getTasks() {
        System.out.println(taskFileRepository.getTasks());
        return taskFileRepository.getTasks();
    }
}