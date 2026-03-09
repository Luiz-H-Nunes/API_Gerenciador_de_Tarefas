package com.example.taskmanager.repository;

import com.example.taskmanager.model.User;

public interface InterfaceUserRepository {
    public void save(User user);
    public Boolean emailExists(String email);
    public Boolean idExists(int idUser);
    public int geradorId();

}
