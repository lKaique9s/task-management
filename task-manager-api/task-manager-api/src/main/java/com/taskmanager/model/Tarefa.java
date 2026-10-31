package com.taskmanager.model;

public class Tarefa {
    private int id;
    private static int contadorId = 0;
    private String titulo;
    private String conteudo;

    public Tarefa(){};

    public Tarefa(String titulo, String conteudo){
        this.id = ++contadorId;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    

}
