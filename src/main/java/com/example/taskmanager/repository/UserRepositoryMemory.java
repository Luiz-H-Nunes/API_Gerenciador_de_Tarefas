package com.example.taskmanager.repository;

import com.example.taskmanager.model.User;

import java.util.List;

public class UserRepositoryMemory implements InterfaceUserRepository {

    private List<User> users;

    public UserRepositoryMemory(List<User> users) {
        this.users = users;

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void save(User user) {
        getUsers().add(user);
    }

    @Override
    public int geradorId() {
        return getUsers().stream()
                .mapToInt(User::getId)
                .max()
                .orElse(0) + 1;
    }
    @Override
    public Boolean emailExists(String email) {
        return getUsers().stream().anyMatch(u -> u.getEmail().equals(email));
    }
    @Override
    public Boolean idExists(int id) {
        return getUsers().stream().anyMatch(user ->  user.getId() == id);
    }

}
