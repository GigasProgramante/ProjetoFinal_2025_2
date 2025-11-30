package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random gerador = new Random();
        System.out.println("Bem vindo ao sistema de gerenciamento de consultas");
        while (true) {
            System.out.println("[1] - Cadastrar novo paciente");
            System.out.println("[2] - Cadastrar novo médico");
            System.out.println("[3] - Cadastrar novo funcionário");
            System.out.println("[4] - Marcar uma consulta");
            System.out.println("[5] - Consultar pacientes");
            System.out.println("[6] - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                System.out.print("Telefone: ");
                String telefone = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Endereço (Ex: Rua Alberto Pereira, 124): ");
                String endereco = sc.nextLine();

                System.out.print("Data de nascimento: ");
                String dataNascimento = sc.nextLine();
                String[] partes = dataNascimento.split("/");
                Paciente paciente = new Paciente(nome, cpf, telefone, email, endereco, partes[0] + "/" + partes[1] + "/" + partes[2]);
                System.out.println("Paciente cadastrado com sucesso!");
                System.out.println(paciente);
                pacientes.add(paciente);
            } else if (opcao == 2) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.println("CPF: ");
                String cpf = sc.nextLine();

                System.out.println("Telefone: ");
                String telefone = sc.nextLine();

                System.out.println("Email: ");
                String email = sc.nextLine();

                System.out.println("Endereço (Ex: Rua Alberto Pereira, 124):");
                String endereco = sc.nextLine();

                System.out.println("Data de nascimento: ");
                String dataNascimento = sc.nextLine();
                String[] partes = dataNascimento.split("/");

                int crm = gerador.nextInt(100000, 120000);
            } else if (opcao == 3) {

            } else if (opcao == 4) {
                for (Paciente paciente : pacientes) {
                    System.out.println(paciente);
                }
            } else if (opcao == 5) {

            } else if (opcao == 6) {
                break;

            }
        }
    }
}
