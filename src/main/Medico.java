package main;

public class Medico extends Pessoa {
    private Especialidade especialidade;
    private String crm;
    private double salario;

    public Medico(String nome, String dataNascimento, String endereco, String email, String telefone, String cpf, Especialidade especialidade, String crm, double salario) {
        super(nome, dataNascimento, endereco, email, telefone, cpf);
        this.especialidade = especialidade;
        this.crm = crm;
        this.salario = salario;
    }
    @Override
    public String exibirInfo() {
        return super.exibirInfo() + "~~~~~~~~~~~ Médico:" +
                " | Especialidade= " + especialidade +
                " | CRM= " + crm +
                " | Salário= " + salario + "\n";
    }
}

