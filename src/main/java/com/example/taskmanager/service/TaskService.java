package com.example.taskmanager.service;

import com.example.taskmanager.exception.UserNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.repository.InterfaceTaskRepository;
import com.example.taskmanager.repository.InterfaceUserRepository;

import java.util.List;
import java.util.Optional;

public class TaskService {
    private InterfaceTaskRepository interfaceTaskService;
    private InterfaceUserRepository interfaceUserService;


    public TaskService(InterfaceTaskRepository interfaceTaskService, InterfaceUserRepository interfaceUserService) {
        this.interfaceTaskService = interfaceTaskService;
        this.interfaceUserService = interfaceUserService;
    }



    public Task newTask(String name, String description, String deadline, String titulo, int idUser){

        if (titulo == null) throw new TaskNotFoundException("Title is Null");

            if (!interfaceUserService.existsByIdUser(idUser)) {
                throw new UserNotFoundException("UserNotFound");
            }

            Task tasks = new Task(interfaceTaskService.generateId(), titulo, description, Task.Status.COMPLETED, idUser);
            interfaceTaskService.save(tasks);

            return tasks;


        }


    public Optional<List<Task>> tasksUser(int idUser){
        return interfaceTaskService.findByUserId(idUser);
    }
    public void ConcluidedTask(String titulo){
                interfaceTaskService.
                        findAll().stream().
                        filter(tasks -> tasks.getTitle().equals(titulo)).
                        findFirst().
                        ifPresent(Task::concluidedStatus);

    }
    public boolean removeTask(String titulo){
        return interfaceTaskService.deleteByTitle(titulo);
    }
}
