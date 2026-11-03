package com.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.model.Tarefa;

@Service
public class TarefaService {

    List<Tarefa> tarefas = new ArrayList<>();

    public TarefaService() {
        tarefas.add(new Tarefa("aza", "asdasd"));
        tarefas.add(new Tarefa("dois", "sim "));
        tarefas.add(new Tarefa("tres", "capixaba"));
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    public Tarefa buscarTarefa(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id)
                return tarefa;
        }
        throw new TarefaNaoEncontradaException("Tarefa nao foi encontrada!");
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        if (tarefa == null)
            throw new IllegalArgumentException("Tarafa invalida!");
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa atualizarTarefa(int id, Tarefa tarefa){
        var oldTarefa = buscarTarefa(id);
        if (tarefa == null)
            throw new IllegalArgumentException("Tarafa invalida!");
        oldTarefa.setTitulo(tarefa.getTitulo());
        oldTarefa.setConteudo(tarefa.getConteudo());
        return oldTarefa;
    }

    public void removerTarefa(int id){
        var tarefaTarget = buscarTarefa(id);
        tarefas.remove(tarefaTarget);
    }


    
}
