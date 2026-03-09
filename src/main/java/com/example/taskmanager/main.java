package com.example.taskmanager;

import com.example.taskmanager.execpitions.EmailAlreadyExistsException;
import com.example.taskmanager.repository.BancoDeDados;
import com.example.taskmanager.service.UserService;

import java.lang.reflect.Executable;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        BancoDeDados bancoDeDados = new BancoDeDados(new ArrayList<>());
        UserService userService = new UserService(bancoDeDados);
        userService.newUser("admin","admin@testmail.com");
        // Agora vamos criar um o
        userService.newUser("bugTest","admin@testmail.com");
        System.out.println(bancoDeDados.getUsers());

    }
}
