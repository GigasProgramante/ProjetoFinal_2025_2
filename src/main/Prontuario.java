package main;

import java.util.ArrayList;

public class Prontuario {

    private int numero;
    private Consulta consulta;
    private ArrayList<Consulta> consultas;

    private ArrayList<Receita> receitas;
    private Paciente paciente;

    public Prontuario(int numero, Consulta consulta, ArrayList<Consulta> consultas, Paciente paciente) {
        this.numero = numero;
        this.consulta = consulta;
        this.consultas = consultas;
        this.paciente = paciente;
    }
    public void adicionarReceita(Receita receita){
        this.receitas.add(receita);
    }
    public void removerReceita(Receita receita){
        this.receitas.remove(receita);
    }
    public void exibirReceitas() {
        System.out.println("Receitas no Prontuário " + numero + " do Paciente " + (paciente != null ? paciente.exibirInfo() : "Desconhecido") + ":");
        for (Receita r : receitas) {
            r.exibirDetalhes();
        }
    }
}
