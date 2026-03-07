package com.example.taskmanager.service;

import com.example.taskmanager.Tasks;

import java.util.List;

public class UserTaks {
    private InterfaceTaskService interfaceTaskService;
    public void setInterfaceTaskService(InterfaceTaskService interfaceTaskService) {
        this.interfaceTaskService = interfaceTaskService;
    }
    public Tasks newTask(String name, String description, String deadline, String titulo, int idUser){
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
