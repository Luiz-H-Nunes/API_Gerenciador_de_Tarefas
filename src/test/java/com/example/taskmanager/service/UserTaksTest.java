package com.example.taskmanager.service;

import com.example.taskmanager.execpitions.TaskNotFoundException;
import com.example.taskmanager.execpitions.UserNotFoundException;
import com.example.taskmanager.repository.BancoDeDados;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTaksTest {

    @Test
    void newTask_testIfNotAcceptTitleNull_ReturnTaskNotFoundException() {
        BancoDeDados bancoDeDados = new BancoDeDados(new ArrayList<>());
        UserTaks userTaks = new UserTaks(bancoDeDados);
        bancoDeDados.update("test","test@mail.com");
        Assertions.assertThrows(TaskNotFoundException.class,() -> userTaks.newTask("nameTest","descripitionTest",
                "deadlineTest",null,1));

    }

    @Test
    void newTask_testIfNotAcceptToHaveCreateForUserNull_ReturnUserNotFoundException() {
        BancoDeDados bancoDeDados = new BancoDeDados(new ArrayList<>());
        UserTaks userTaks = new UserTaks(bancoDeDados);

        Assertions.assertThrows(UserNotFoundException.class,() -> userTaks.newTask("nameTest","descripitionTest",
                "deadlineTest","titleTest",1));

    }
}