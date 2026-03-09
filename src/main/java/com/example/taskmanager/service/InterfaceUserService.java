package com.example.taskmanager.service;

import com.example.taskmanager.dominio.User;

public interface InterfaceUserService {
    public void save(User user);
    public User update(String name,String email);

}
