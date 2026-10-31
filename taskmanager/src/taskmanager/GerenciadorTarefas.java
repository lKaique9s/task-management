package taskmanager;

import java.util.Collections;
import java.util.List;

public class GerenciadorTarefas {
    private TarefaRepository repositorio;

    public GerenciadorTarefas(TarefaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void addTarefa(String titulo, String conteudo) {
        var tarefa = new Tarefa(titulo, conteudo);

        repositorio.salvarTarefa(tarefa);

    }

    public Tarefa buscarTarefa(int id) {
        return repositorio.buscarTarefaPorId(id);
    }

    public void removerTarefa(int id) {
        repositorio.removerTarefaPorId(id);
    }

    public void atualizarTarefa(int id, String titulo, String conteudo) {
        var tarefa = repositorio.buscarTarefaPorId(id);

        tarefa.setTitulo(titulo);
        tarefa.setConteudo(conteudo);
    }

    public List<Tarefa> listarTarefas() {
        return Collections.unmodifiableList(repositorio.listarTodas());
    }

}
