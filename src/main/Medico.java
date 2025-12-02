package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Medico extends Pessoa {
    Random gerador = new Random();
    private Especialidade especialidade;
    private String crm;
    private double salario;

    public Medico(String nome, String dataNascimento, String endereco, String email, String telefone, String cpf,
                  Especialidade especialidade, String crm, double salario) {
        super(nome, dataNascimento, endereco, email, telefone, cpf);
        this.especialidade = especialidade;
        this.crm = crm;
        this.salario = salario;
    }
    public Receita emitirReceita(ArrayList<String> medicamentos, LocalDate dataEmissao) {
        int numero = gerador.nextInt(120000);
        return new Receita(numero, medicamentos, dataEmissao, this);
    }
    @Override
    public String exibirInfo() {
        return super.exibirInfo() + "~~~~~~~~~~~ Médico:" +
                " | Especialidade= " + especialidade +
                " | CRM= " + crm +
                " | Salário= " + salario + "\n";
    }
}

