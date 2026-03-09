package com.example.taskmanager.model;

import java.time.LocalDateTime;

public class Task {

    public enum Status {
        PENDING,
        COMPLETED
    };

    private int id;
    private String title;
    private String description;
    private Status status;
    private int IdUser;
    private LocalDateTime createdAt;

    public Task(int id, String title, String description, Status status, int idUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.IdUser = idUser;
        this.createdAt = LocalDateTime.now();

    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        this.IdUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void concluidedStatus() {
        this.status = Status.COMPLETED;
    }
}
