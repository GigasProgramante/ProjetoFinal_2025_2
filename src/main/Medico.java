package main;

public class Medico extends Pessoa {
    private Especialidade especialidade;
    private String crm;
    private double salario;

    public Medico(String nome, String cpf, String telefone, String email, String endereco, Especialidade especialidade, String crm, double salario) {
        super(nome, cpf, telefone, email, endereco);
        this.especialidade = especialidade;
        this.crm = crm;
        this.salario = salario;
    }

    @Override
    public void imprimirDados() {

    }
}
