package main;

public class Paciente extends Pessoa{
    private Prontuario prontuario;

    public Paciente(String nome, String dataNascimento, String endereco, String email, String telefone, String cpf) {
        super(nome, dataNascimento, endereco, email, telefone, cpf);
    }

    @Override
    public String exibirInfo() {
        return super.exibirInfo();
    }
}
