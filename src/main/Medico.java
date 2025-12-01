package main;

public class Medico extends Pessoa {
    private Especialidade especialidade;
    private String crm;
    private double salario;

    public Medico(String nome, String dataNascimento, String endereco, String email, String telefone, String cpf,
                  Especialidade especialidade, String crm, double salario) {
        super(nome, dataNascimento, endereco, email, telefone, cpf);
        this.especialidade = especialidade;
        this.crm = crm;
        this.salario = salario;
    }

    public void criarConsulta() {
    }

    @Override
    public String toString() {
        return super.toString() + "Medico{" +
                "especialidade=" + especialidade +
                ", crm='" + crm + '\'' +
                ", salario=" + salario +
                '}';
    }
}

