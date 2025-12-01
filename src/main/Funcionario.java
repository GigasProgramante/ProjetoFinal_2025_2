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
    public String toString() {
        return super.toString() + "Funcionario{" +
                "cargo=" + cargo +
                '}';
    }
}
