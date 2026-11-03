package com.taskmanager.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.taskmanager.dto.AtualizarTarefaRequest;
import com.taskmanager.dto.CriarTarefaRequest;
import com.taskmanager.dto.ErroResponse;
import com.taskmanager.model.Tarefa;
import com.taskmanager.service.TarefaNaoEncontradaException;
import com.taskmanager.service.TarefaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController 
public class TarefaController {
    private final TarefaService tarefaService;

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
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping("/tarefas")
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody CriarTarefaRequest tarefa) {
        var tarefaTarget = new Tarefa(tarefa.getTitulo(), tarefa.getConteudo());
        var tarefaCriada = tarefaService.criarTarefa(tarefaTarget);
        var uri = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(tarefaCriada.getId())
                            .toUri();
        return ResponseEntity.created(uri).body(tarefaCriada);
    }

    @PutMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable int id, @Valid @RequestBody AtualizarTarefaRequest tarefa) {
        var tarefaTarget = new Tarefa(tarefa.getTitulo(), tarefa.getConteudo());
        var tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefaTarget);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Void> removerTarefa(@PathVariable int id){
        tarefaService.removerTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(TarefaNaoEncontradaException.class)
    public ResponseEntity<ErroResponse> HandlerTarefaNaoEncontrada (TarefaNaoEncontradaException ex){
        return ResponseEntity.status(404).body(new ErroResponse(ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResponse> HandlerBadRequest (IllegalArgumentException ex){
        return ResponseEntity.status(400).body(new ErroResponse(ex.getMessage()));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> HandlerValid(MethodArgumentNotValidException ex){
        var erros = ex.getBindingResult().getFieldErrors();
        var mensagens = erros.stream()
            .map(erro -> erro.getDefaultMessage())
            .collect(Collectors.toList());

        var mensagemFinal = String.join(", ", mensagens);
        return ResponseEntity.status(400).body(new ErroResponse(mensagemFinal));
    }
}
