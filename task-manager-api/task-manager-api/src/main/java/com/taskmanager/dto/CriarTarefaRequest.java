package com.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;

public class CriarTarefaRequest {

    @NotBlank 
    private String titulo;
    @NotBlank 
    private String conteudo;

    public CriarTarefaRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
