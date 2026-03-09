package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepositoryMemory implements InterfaceTaskRepository {
    private List<Task> tasks = new ArrayList<>();

    public TaskRepositoryMemory(List<Task> tasks) {
        this.tasks = tasks;

    }

    public List<Task> getTasks() {
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    @Override
    public void save(Task tasks) {
        getTasks().add(tasks);
    }

    @Override
    public int generateId() {
        return getTasks().stream()
                    .mapToInt(Task::getId)
                    .max()
                    .orElse(0) + 1;
        }

    @Override
    public List<Task> findAll() {
        return getTasks();
    }

    @Override
    public Optional<List<Task>> findByUserId(int idUser) {
        return Optional.of(getTasks().stream().filter(tasks -> tasks.getIdUser() == idUser ).toList());
    }

    @Override
    public boolean deleteByTitle(String titulo) {
       return getTasks().removeIf(tasks -> tasks.getTitle().equals(titulo));
    }

}

