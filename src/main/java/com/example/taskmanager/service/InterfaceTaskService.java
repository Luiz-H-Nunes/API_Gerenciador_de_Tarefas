package com.example.taskmanager.service;

import com.example.taskmanager.Tasks;

import java.util.List;

public interface InterfaceTaskService {
    public Tasks newTask(String name, String description, String deadline, String titulo,int idUser);
    public List<Tasks> tasksUser(int id);
    public List<Tasks> ConcluidedTask(String titulo);public boolean removeTask(String titulo);
}
