package main;

import java.util.ArrayList;
import java.util.Random;

public class Prontuario {

    private int idProntuario;
    private Consulta consulta;
    private ArrayList<Consulta> consultas;

    private ArrayList<Receita> receitas;
    private Paciente paciente;

    public Prontuario(Consulta consulta, ArrayList<Consulta> consultas, Paciente paciente) {
        Random rd = new Random();
        this.idProntuario = rd.nextInt();
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
        System.out.println("Receitas no Prontuário " + idProntuario + " do Paciente " + (paciente != null ? paciente.exibirInfo() : "Desconhecido") + ":");
        for (Receita r : receitas) {
            r.exibirDetalhes();
        }
    }
}
