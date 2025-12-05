package main;

import java.util.ArrayList;
import java.util.Random;

import java.util.ArrayList;

import java.util.ArrayList;

public class Prontuario {

    private Paciente paciente;
    private ArrayList<Consulta> consultas;
    private ArrayList<Receita> receitas;
    private ArrayList<Tratamento> tratamentos;

    public Prontuario(Paciente paciente) {
        this.paciente = paciente;
        this.consultas = new ArrayList<>();
        this.receitas = new ArrayList<>();
        this.tratamentos = new ArrayList<>();
    }

    // ===== CONSULTAS =====
    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta registrada.");
            return;
        }
        System.out.println("Consultas do paciente " + paciente.getNome() + ":");
        for (Consulta c : consultas) {
            System.out.println("----------------------------");
            System.out.println(c.getIdconsulta() + " ------- Médico: " + c.getMedico().getNome());
            System.out.println("Data/hora: " + c.getData() + " | " + c.getHora());
            c.listarSintomas();
        }
    }
    public void adicionarReceita(Receita receita) {
        receitas.add(receita);
    }
    public void listarReceitas() {
        if (receitas.isEmpty()) {
            System.out.println("Nenhuma receita registrada.");
            return;
        }
        System.out.println("Receitas do paciente " + paciente.getNome() + ":");
        for (Receita r : receitas) {
            System.out.println("----------------------------");
            System.out.println(r.exibirInfo()); // ou r.exibirInfo()
        }
    }


    public void adicionarTratamento(Tratamento tratamento) {
        tratamentos.add(tratamento);
    }

    public void listarTratamentos() {
        if (tratamentos.isEmpty()) {
            System.out.println("Nenhum tratamento cadastrado para este paciente.");
            return;
        }
        System.out.println("Tratamentos do paciente " + paciente.getNome() + ":");
        for (Tratamento t : tratamentos) {
            System.out.println("----------------------------");
            System.out.println("Nome: " + t.getNome());
            System.out.println("Duração (dias): " + t.getDuracao());
            System.out.println("Descrição: " + t.getDescricao());
        }
    }

    // ===== EXIBIR TUDO =====
    public void exibirProntuarioCompleto() {
        System.out.println("=== PRONTUÁRIO DO PACIENTE: " + paciente.getNome() + " ===");

        System.out.println("\n--- Consultas ---");
        listarConsultas();

        System.out.println("\n--- Receitas ---");
        listarReceitas();

        System.out.println("\n--- Tratamentos ---");
        listarTratamentos();
    }
}
