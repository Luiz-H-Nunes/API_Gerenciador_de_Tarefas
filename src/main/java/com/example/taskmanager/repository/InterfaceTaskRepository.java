package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;

import java.util.List;
import java.util.Optional;

public interface InterfaceTaskRepository {
     void save(Task task);
     int generateId();
     List<Task> findAll();
     Optional<List<Task>> findByUserId(int idUser);
    boolean deleteByTitle(String titulo);

}
