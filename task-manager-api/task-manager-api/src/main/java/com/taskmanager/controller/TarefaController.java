package com.taskmanager.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.taskmanager.model.Tarefa;
import com.taskmanager.service.TarefaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController 
public class TarefaController {
    private TarefaService tarefaService;

    public TarefaController (TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @GetMapping("/tarefas")
    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> buscarTarefa(@PathVariable int id){
        var tarefa = tarefaService.buscarTarefa(id);
        if(tarefa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping("/tarefas")
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        var tarefaCriada = tarefaService.criarTarefa(tarefa);
        var uri = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(tarefaCriada.getId())
                            .toUri();
        return ResponseEntity.created(uri).body(tarefaCriada);
    }
    
    
    
    
}
