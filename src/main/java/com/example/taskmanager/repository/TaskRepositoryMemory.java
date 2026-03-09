package com.example.taskmanager.repository;

import com.example.taskmanager.model.Tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryMemory implements InterfaceTaskRepository {
    private List<Tasks> tasks = new ArrayList<>();

    public TaskRepositoryMemory(List<Tasks> tasks) {
        this.tasks = tasks;

    }

    public List<Tasks> getTasks() {
        return tasks;
    }
    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
    @Override
    public void save(Tasks tasks) {
        getTasks().add(tasks);
    }

    @Override
    public int geradorId() {
        return getTasks().stream()
                    .mapToInt(Tasks::getId)
                    .max()
                    .orElse(0) + 1;
        }

    @Override
    public List<Tasks> findAll() {
        return getTasks();
    }

    @Override
    public List<Tasks> findByidUser(int idUser) {
        return getTasks().stream().filter(tasks -> tasks.getUsuarioId() == idUser ).toList();
    }

    @Override
    public boolean deleteByTitulo(String titulo) {
       return getTasks().removeIf(tasks -> tasks.getTitulo().equals(titulo));
    }

}

