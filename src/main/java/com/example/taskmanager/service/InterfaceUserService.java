package com.example.taskmanager.service;

import com.example.taskmanager.User;
import com.example.taskmanager.repository.BancoDeDados;

public interface InterfaceUserService {
    public void save(User user);
    public User update(String name,String email);

}
