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
    @Override
    public String exibirInfo() {
        return super.exibirInfo();
    }

    public Consulta marcarConsulta(Medico medico, Scanner sc) {

        System.out.println("Informe a data da consulta (AAAA-MM-DD)");
        LocalDate data = LocalDate.parse(sc.nextLine());

        System.out.println("Informe o horário da consulta (HH:MM)");
        LocalTime hora = LocalTime.parse(sc.nextLine());

        ArrayList<String> sintomas = new ArrayList<>();
        while (true) {
            System.out.println("Insira sintomas um por um, deixe vazio para sair: ");
            String sintoma = sc.nextLine();
            if (sintoma.isEmpty()) {
                break;
            }
            sintomas.add(sintoma);
        }
        Consulta consulta = new Consulta(this, data, hora, sintomas);

        consulta.setMedico(medico);

        this.prontuario.adicionarConsulta(consulta);

        return consulta;
    }
}
