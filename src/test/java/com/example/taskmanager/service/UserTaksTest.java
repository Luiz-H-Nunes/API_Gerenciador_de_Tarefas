package com.example.taskmanager.service;

import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.exception.UserNotFoundException;

import com.example.taskmanager.repository.TaskRepositoryMemory;
import com.example.taskmanager.repository.UserRepositoryMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class UserTaksTest {

    @Test
    void newTask_testIfNotAcceptTitleNull_ReturnTaskNotFoundException() {
        UserRepositoryMemory userRepositoryMemory = new UserRepositoryMemory(new ArrayList<>());
        TaskRepositoryMemory taskRepositoryMemory = new TaskRepositoryMemory(new ArrayList<>());
        UserTaks userTaks = new UserTaks(taskRepositoryMemory, userRepositoryMemory);
        UserService userService = new UserService(userRepositoryMemory);
        userService.newUser("test","test@testmail.com");

        Assertions.assertThrows(TaskNotFoundException.class,() -> userTaks.newTask("nameTest","descripitionTest",
                "deadlineTest",null,1));

    }

    @Test
    void newTask_testIfNotAcceptToHaveCreateForUserNull_ReturnUserNotFoundException() {
        UserRepositoryMemory userRepositoryMemory = new UserRepositoryMemory(new ArrayList<>());
        TaskRepositoryMemory taskRepositoryMemory = new TaskRepositoryMemory(new ArrayList<>());
        UserTaks userTaks = new UserTaks(taskRepositoryMemory,userRepositoryMemory);

        Assertions.assertThrows(UserNotFoundException.class,() -> userTaks.newTask("nameTest","descripitionTest",
                "deadlineTest","titleTest",1));

    }
}