package com.example.taskmanager.model;

import java.time.LocalDateTime;

public class Tasks {

    public enum Status {
        PENDENTE,
        CONCLUIDA
    };

    private int id;
    private String titulo;
    private String descricao;
    private Status status;
    private int usuarioId;
    private LocalDateTime dataCriacao;

    public Tasks(int id, String titulo, String descricao, Status status, int usuarioId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.usuarioId = usuarioId;
        this.dataCriacao = LocalDateTime.now();

    }

    public int getId() {
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public void concluidedStatus() {
        this.status = Status.CONCLUIDA;
    }
}
