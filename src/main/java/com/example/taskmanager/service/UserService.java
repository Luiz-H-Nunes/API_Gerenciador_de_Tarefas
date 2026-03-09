package com.example.taskmanager.service;

import com.example.taskmanager.dominio.User;

public class UserService {
    InterfaceUserService interfaceUserService;

    public UserService(InterfaceUserService interfaceUserService) {
        this.interfaceUserService = interfaceUserService;
    }

    public User newUser(String name,String email){
        return interfaceUserService.update(name ,email);
    }


}
