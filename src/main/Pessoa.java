package main;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private String dataNascimento;

    public Pessoa(String nome, String dataNascimento, String endereco, String email, String telefone, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    public String exibirInfo() {
        return "Informaçoes Pessoais:" +
                " | Nome= " + nome +
                " | CPF= " + cpf +
                " | Telefone= " + telefone +
                " | E-mail= " + email +
                " | Endereço= " + endereco +
                " | Data de nascimento= " + dataNascimento + "\n";
    }

    public String getNome() {
        return nome;
    }
}
