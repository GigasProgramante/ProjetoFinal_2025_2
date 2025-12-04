// Paciente.java
package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Paciente extends Pessoa {

    private Prontuario prontuario;

    public Paciente(String nome, String dataNascimento, String endereco, String email, String telefone, String cpf) {
        super(nome, dataNascimento, endereco, email, telefone, cpf);
        criarProntuario();
    }
    public void criarProntuario() {
        this.prontuario = new Prontuario(this); // Liga ao Paciente
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void deletarProntuario() {
        this.prontuario = null;
    }

    @Override
    public String exibirInfo() {
        return super.exibirInfo();
    }

    public Consulta marcarConsulta() {
        Scanner sc1 = new Scanner(System.in);

        System.out.print("Informe o nome do médico com qual será a consulta: ");
        String nomeMedico = sc1.nextLine();

        System.out.println("Informe a data da consulta (AAAA-MM-DD)");
        LocalDate data = LocalDate.parse(sc1.nextLine());

        System.out.println("Informe o horário da consulta (HH:MM)");
        LocalTime hora = LocalTime.parse(sc1.nextLine());

        ArrayList<String> sintomas = new ArrayList<>();
        while (true) {
            System.out.println("Insira sintomas um por um, deixe vazio para sair: ");
            String sintoma = sc1.nextLine();
            if (sintoma.isEmpty()) {
                break;
            }
            sintomas.add(sintoma);
        }

        Consulta consulta = new Consulta(this, data, hora, sintomas);
        this.prontuario.adicionarConsulta(consulta);
        return consulta;
    }
}
