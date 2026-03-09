package com.example.taskmanager.service;

import com.example.taskmanager.exception.UserNotFoundException;
import com.example.taskmanager.model.Tasks;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.repository.InterfaceTaskRepository;
import com.example.taskmanager.repository.InterfaceUserRepository;
import com.example.taskmanager.repository.UserRepositoryMemory;

import java.util.List;
import java.util.stream.Collectors;

public class UserTaks {
    private InterfaceTaskRepository interfaceTaskService;
    private InterfaceUserRepository interfaceUserService;


    public UserTaks(InterfaceTaskRepository interfaceTaskService, InterfaceUserRepository interfaceUserService) {
        this.interfaceTaskService = interfaceTaskService;
        this.interfaceUserService = interfaceUserService;
    }



    public Tasks newTask(String name, String description, String deadline, String titulo, int idUser){

        if (titulo == null) throw new TaskNotFoundException("Title is Null");

            if (!interfaceUserService.idExists(idUser)) {
                throw new UserNotFoundException("UserNotFound");
            }

            Tasks tasks = new Tasks(interfaceTaskService.geradorId(), titulo, description, Tasks.Status.PENDENTE, idUser);
            interfaceTaskService.save(tasks);

            return tasks;


        }


    public List<Tasks> tasksUser(int idUser){
        return interfaceTaskService.findByidUser(idUser);
    }
    public void ConcluidedTask(String titulo){
                interfaceTaskService.
                        findAll().stream().
                        filter(tasks -> tasks.getTitulo().equals(titulo)).
                        findFirst().
                        ifPresent(Tasks::concluidedStatus);

    }
    public boolean removeTask(String titulo){
        return interfaceTaskService.deleteByTitulo(titulo);
    }
}
