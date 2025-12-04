package main;

public class Tratamento {

    private String nome;
    private int duracao;          // em dias
    private String descricao;
    private Prontuario prontuario; // onde será associado

    public Tratamento(String nome, int duracao, String descricao) {
        this.nome = nome;
        this.duracao = duracao;
        this.descricao = descricao;
    }

    // associa este tratamento a um prontuário
    public void associarProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
        prontuario.adicionarTratamento(this);
    }

    // getters usados em listarTratamentos()
    public String getNome() {
        return nome;
    }
    public int getDuracao() {
        return duracao;
    }
    public String getDescricao() {
        return descricao;
    }
}

