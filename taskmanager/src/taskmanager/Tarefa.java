package taskmanager;

public class Tarefa {
    private int id;
    private static int contadorId = 0;
    private String titulo;
    private String conteudo;
    private StatusTarefa estado = StatusTarefa.PENDENTE;

    public Tarefa(String titulo, String conteudo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo invalido");
        }

        this.id = ++contadorId;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo invalido");
        }

        this.titulo = titulo;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public StatusTarefa getEstado() {
        return estado;
    }

    public void iniciar() {
        if (this.estado != StatusTarefa.PENDENTE) {
            throw new IllegalStateException("Tarefa nao pode ser inciada");
        }

        this.estado = StatusTarefa.EM_ANDAMENTO;
    }

    public void concluir() {
        if (this.estado != StatusTarefa.EM_ANDAMENTO) {
            throw new IllegalStateException("Tarefa nao pode ser concluida");
        }

        this.estado = StatusTarefa.CONCLUIDA;
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", titulo=" + titulo + ", conteudo=" + conteudo + ", estado=" + estado + "]";
    }

}