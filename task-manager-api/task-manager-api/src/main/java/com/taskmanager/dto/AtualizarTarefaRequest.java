package com.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;

public class AtualizarTarefaRequest {
    @NotBlank 
    private String titulo;
    @NotBlank 
    private String conteudo;

    public AtualizarTarefaRequest() {
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
