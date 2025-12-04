package main;

import java.util.ArrayList;

public class Prontuario {

    private int numero;
    private Consulta consultaInicial;
    private ArrayList<Consulta> consultas;
    private Paciente paciente;
    private ArrayList<Receita> receitas;

    public Prontuario(int numero, Consulta consulta, ArrayList<Consulta> consultas, Paciente paciente) {
        this.numero = numero;
        this.consultaInicial = consulta;
        this.consultas = (consultas != null) ? consultas : new ArrayList<>();
        this.paciente = paciente;
        this.receitas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void adicionarReceita(Receita receita) {
        this.receitas.add(receita);
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
