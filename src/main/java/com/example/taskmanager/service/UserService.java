package com.example.taskmanager.service;

import com.example.taskmanager.exception.EmailAlreadyExistsException;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.InterfaceUserRepository;

public class UserService {
    private final InterfaceUserRepository interfaceUserRepository;

    public UserService(InterfaceUserRepository interfaceUserRepository) {
        this.interfaceUserRepository = interfaceUserRepository;
    }

    public User newUser(String name,String email){
            if(interfaceUserRepository.emailExists(email)){
                throw new EmailAlreadyExistsException(email + " Is Aleready");
            }

            User user = new User(interfaceUserRepository.geradorId(),name,email);
            interfaceUserRepository.save(user);
            return user;
        }
    }


