package com.example.taskmanager.service;

import com.example.taskmanager.exception.EmailAlreadyExistsException;
import com.example.taskmanager.repository.UserRepositoryMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class UserServiceTest {
    @Test
    void newUser_TestIfHeMaintainsUniquenessOfEmails_ReturnEmailAlreadyExists() {
        UserRepositoryMemory userRepositoryMemory = new UserRepositoryMemory(new ArrayList<>());
        UserService userService = new UserService(userRepositoryMemory);
        userService.newUser("admin","admin@testmail.com");
        // Agora vamos criar um o
        Assertions.assertThrows(EmailAlreadyExistsException.class,() -> userService.newUser("bugTest","admin@testmail.com"));
    }

}