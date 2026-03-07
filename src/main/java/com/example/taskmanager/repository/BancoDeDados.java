package com.example.taskmanager.repository;

import com.example.taskmanager.Tasks;
import com.example.taskmanager.User;
import com.example.taskmanager.execpitions.EmailAlreadyExistsException;
import com.example.taskmanager.service.InterfaceTaskService;
import com.example.taskmanager.service.InterfaceUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BancoDeDados implements InterfaceUserService, InterfaceTaskService {

    private List<User> users;
    private List<Tasks> tasks;



    public BancoDeDados(List<User> users) {
        this.users = new ArrayList<>(users);
    }

    public int geradorId(Class<?> c) {

        if (c.equals(User.class)) {
            return getUsers().stream()
                    .mapToInt(User::getId)
                    .max()
                    .orElse(0) + 1;
        }

        if (c.equals(Tasks.class)) {
            return getTasks().stream()
                    .mapToInt(Tasks::getId)
                    .max()
                    .orElse(0) + 1;
        }

        throw new IllegalArgumentException("Classe não suportada: " + c);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void save(User user) {
        getUsers().add(user);
    }
    public void saveTasks(Tasks tasks) {
        getTasks().add(tasks);
    }

    @Override
    public User update(String name,String email) {
        if(emailExists(email)){
            throw new EmailAlreadyExistsException(email + " Is Aleready");
        }

        User user = new User(geradorId(User.class),name,email);
        save(user);
        return user;

    }

    private boolean emailExists(String email) {
        return getUsers().stream().anyMatch(u -> u.getEmail().equals(email));
    }
    private boolean usernameExists(String username) {
        return getUsers().stream().anyMatch(user ->  user.getName().equals(username));
    }

    @Override
    public Tasks newTask(String name, String description, String deadline, String titulo,int idUser) {
        Tasks tasks = new Tasks(geradorId(Tasks.class),titulo,description, Tasks.Status.PENDENTE,idUser);
        saveTasks(tasks);
        return tasks;
    }

    @Override
    public List<Tasks> tasksUser(int id) {
        return getTasks().stream().filter(n -> n.getUsuarioId() == id).collect(Collectors.toList());
    }

    @Override
    public List<Tasks> ConcluidedTask(String titulo) {
        return getTasks().stream().map(n -> {
            if (n.getTitulo().equals(titulo))
                n.concluidedStatus();
            return n;
        }  ).collect(Collectors.toList());
    }

    @Override
    public boolean removeTask(String titulo) {
        return getTasks().removeIf(n -> n.getTitulo().equals(titulo));
    }
}
