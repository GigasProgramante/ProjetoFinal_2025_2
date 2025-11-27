package main;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;

    public Pessoa(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public abstract void imprimirDados();
}
