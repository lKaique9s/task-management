package taskmanager;

import java.util.List;

public class Main {
    static TarefaRepository rp = new TarefaRepositoryHashMap();
    static GerenciadorTarefas gd = new GerenciadorTarefas(rp);

    public static void main(String[] args) {
        gd.addTarefa("adsda","dasdad");
        gd.addTarefa("jazz", "dasdad");
        exibirTarefas(gd.listarTarefas());
        gd.atualizarTarefa(1, "lulamolusco", "chamber");
        exibirTarefas(gd.listarTarefas());
        gd.removerTarefa(2);
        try {
            gd.buscarTarefa(2);
        } catch (TarefaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void exibirTarefas(List<Tarefa> tarefas) {
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa.getId() + " - " +
                    tarefa.getTitulo() + " - " +
                    tarefa.getConteudo() + " - " +
                    tarefa.getEstado());
        }
    }

}
