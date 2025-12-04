package main;

public class ClinicaMedica {
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;
    private String cidade;
    private String estado;

    public ClinicaMedica(String nome, String cnpj, String endereco,
                         String telefone, String email,
                         String cidade, String estado) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String exibirInfo() {
        return "=== Dados da Clínica ===\n" +
                "Nome: " + nome + "\n" +
                "CNPJ: " + cnpj + "\n" +
                "Endereço: " + endereco + "\n" +
                "Cidade: " + cidade + " - " + estado + "\n" +
                "Telefone: " + telefone + "\n" +
                "Email: " + email;
    }
}


