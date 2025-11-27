package main;

public class Funcionario extends Pessoa {
    private Cargos cargo;

    public Funcionario(String nome, String cpf, String telefone, String email, String endereco, Cargos cargo) {
        super(nome, cpf, telefone, email, endereco);
        this.cargo = cargo;
    }

    @Override
    public void imprimirDados() {

    }
}
