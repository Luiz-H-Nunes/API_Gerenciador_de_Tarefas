package com.example.taskmanager.service;

import com.example.taskmanager.dominio.Tasks;
import com.example.taskmanager.execpitions.TaskNotFoundException;

import java.util.List;

public class UserTaks {
    private InterfaceTaskService interfaceTaskService;
    public UserTaks(InterfaceTaskService interfaceTaskService) {
        this.interfaceTaskService = interfaceTaskService;
    }
    public Tasks newTask(String name, String description, String deadline, String titulo, int idUser){

        if (titulo == null){throw new TaskNotFoundException("Title is Null");}

        return interfaceTaskService.newTask(name, description, deadline, titulo, idUser);
    }
    public List<Tasks> tasksUser(int id){
        return interfaceTaskService.tasksUser(id);
    }
    public List<Tasks> ConcluidedTask(String titulo){
        return interfaceTaskService.ConcluidedTask(titulo);
    }
    public boolean removeTask(String titulo){
        return interfaceTaskService.removeTask(titulo);
    }
}
