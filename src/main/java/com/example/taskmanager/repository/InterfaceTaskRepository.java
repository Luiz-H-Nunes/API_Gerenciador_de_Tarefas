package com.example.taskmanager.repository;

import com.example.taskmanager.model.Tasks;
import com.example.taskmanager.model.User;

import java.util.List;

public interface InterfaceTaskRepository {
    public void save(Tasks task);
    public int geradorId();
    public List<Tasks> findAll();
    public List<Tasks> findByidUser(int idUser);
    boolean deleteByTitulo(String titulo);

}
