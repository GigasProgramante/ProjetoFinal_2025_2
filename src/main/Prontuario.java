package main;

import java.util.ArrayList;
import java.util.Random;

public class Prontuario {

    private int numero;
    private ArrayList<Consulta> consultas = new ArrayList<>();

    private Paciente paciente;
    private ArrayList<Receita> receitas = new ArrayList<>();

    public Prontuario(Paciente paciente) {
        Random rd = new Random();
        this.numero = rd.nextInt(100000);
        this.paciente = paciente;
        this.receitas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);
    }

    public void removerReceita(Receita receita) {
        this.receitas.remove(receita);
    }

    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public ArrayList<Receita> getReceitas() {
        return receitas;
    }

    public void listarConsultas() {
        System.out.println("Consultas do prontuário #" + numero + ":");
        for (Consulta c : consultas) {
            System.out.println(c.exibirInfo());
        }
    }

    public void listarReceitas() {
        System.out.println("Receitas do prontuário #" + numero + ":");
        for (Receita r : receitas) {
            System.out.println(r.exibirInfo());
        }
    }
}
