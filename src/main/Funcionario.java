package main;

public class Funcionario extends Pessoa {
    private Cargos cargo;
    private double salario;

    public Funcionario(String nome, String dataNascimento, String endereco, String email, String telefone, String cpf, Cargos cargo, double salario) {
        super(nome, dataNascimento, endereco, email, telefone, cpf);
        this.cargo = cargo;
        this.salario = salario;
    }
    @Override
    public String exibirInfo() {
        return super.exibirInfo() + "~~~~~~~~~~~ Funcionario " +
                " | cargo=" + cargo +
                '\n';
    }
}
