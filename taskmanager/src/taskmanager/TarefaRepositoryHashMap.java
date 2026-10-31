package taskmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TarefaRepositoryHashMap implements TarefaRepository {
    private HashMap<Integer, Tarefa> tarefasHashMap = new HashMap<>();

    @Override
    public void salvarTarefa(Tarefa tarefa) {
        tarefasHashMap.put(tarefa.getId(), tarefa);
    }

    @Override
    public void removerTarefaPorId(int id) {
        var tarefa = tarefasHashMap.get(id);
        if (tarefa == null)
            throw new TarefaNaoEncontradaException("Tarefa nao foi encontrada!");
        tarefasHashMap.remove(id);
    }

    @Override
    public Tarefa buscarTarefaPorId(int id) {
        var tarefa = tarefasHashMap.get(id);
        if (tarefa == null)
            throw new TarefaNaoEncontradaException("Tarefa nao foi encontrada!");
        return tarefa;
    }

    @Override 
    public List<Tarefa> listarTodas(){
        return new ArrayList<>(tarefasHashMap.values());
    }
}
