package main;

public class Funcionario extends Pessoa {
    private Cargos cargo;

    public Funcionario(String nome, String dataNascimento, String endereco, String email, String telefone, String cpf, Cargos cargo) {
        super(nome, dataNascimento, endereco, email, telefone, cpf);
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + "Funcionario{" +
                "cargo=" + cargo +
                '}';
    }
}
