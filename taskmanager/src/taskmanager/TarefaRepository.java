package taskmanager;

import java.util.List;

public interface TarefaRepository {
    void salvarTarefa(Tarefa tarefa);

    Tarefa buscarTarefaPorId(int id);

    void removerTarefaPorId(int id);
    
    List<Tarefa> listarTodas();
}
