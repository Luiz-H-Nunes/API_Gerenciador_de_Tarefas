package com.example.taskmanager.repository;

import com.example.taskmanager.model.User;

public interface InterfaceUserRepository {
     void save(User user);
     boolean emailExists(String email);
     boolean existsByIdUser(int idUser);
     int generateId();

}
