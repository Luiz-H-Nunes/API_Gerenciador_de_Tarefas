package com.example.taskmanager.service;

import com.example.taskmanager.execpitions.EmailAlreadyExistsException;
import com.example.taskmanager.repository.BancoDeDados;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @Test
    void newUser_TestIfHeMaintainsUniquenessOfEmails_ReturnEmailAlreadyExists() {
        BancoDeDados bancoDeDados = new BancoDeDados(new ArrayList<>());
        UserService userService = new UserService(bancoDeDados);
        userService.newUser("admin","admin@testmail.com");
        // Agora vamos criar um o
        Assertions.assertThrows(EmailAlreadyExistsException.class,() -> userService.newUser("bugTest","admin@testmail.com"));
    }

}