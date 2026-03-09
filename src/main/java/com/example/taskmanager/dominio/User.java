package com.example.taskmanager.dominio;

import java.util.Objects;

public class User {
    private int id;
    private String email;
    private String name;



    public User(int id, String name, String email) {
        this.id = id;
        this.email = email;
        this.name = Objects.requireNonNull(name);

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
