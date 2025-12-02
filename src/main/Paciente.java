package main;

import java.util.ArrayList;

public class Paciente extends Pessoa {
    private Prontuario prontuario;

    public Paciente(String nome, String dataNascimento, String endereco, String email, String telefone, String cpf) {
        super(nome, dataNascimento, endereco, email, telefone, cpf);
    }
    public void criarProntuario(int numero, Consulta consulta, ArrayList<Consulta> consultas) {
        this.prontuario = new Prontuario(numero, consulta, consultas, this); // Liga ao Paciente
    }
    public Prontuario getProntuario() {
        return prontuario;
    }
    public void deletarProntuario() {
        this.prontuario = null;
    }
    @Override
    public String exibirInfo() {
        return super.exibirInfo();
    }
}
