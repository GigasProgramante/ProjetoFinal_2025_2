// Tratamento.java
package main;

import java.util.ArrayList;

public class Tratamento {

    private String nomeTratamento;
    private int duracao;
    private String descricao;
    private ArrayList<Prontuario> prontuarios;

    public Tratamento(String nomeTratamento, int duracao, String descricao) {
        this.nomeTratamento = nomeTratamento;
        this.duracao = duracao;
        this.descricao = descricao;
        this.prontuarios = new ArrayList<>();
    }

    public void associarProntuario(Prontuario prontuario){
        this.prontuarios.add(prontuario);
    }
}
