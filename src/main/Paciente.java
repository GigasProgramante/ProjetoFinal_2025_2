package main;

public class Paciente extends Pessoa{
    private int anoNascimento;

    public Paciente(String nome, String cpf, String telefone, String email, String endereco, int anoNascimento) {
        super(nome, cpf, telefone, email, endereco);
        this.anoNascimento = anoNascimento;
    }

    @Override
    public void imprimirDados() {
        
    }
}
