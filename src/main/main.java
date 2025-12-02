package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random gerador = new Random();
        System.out.println("Bem vindo ao sistema de gerenciamento de consultas");
        while (true) {

            // Executa um metodo que exibe o menu
            exibirMenu();

            // O scanner coleta na main a opção escolhida pelo usuário
            int opcao = sc.nextInt();
            sc.nextLine(); // Aqui o scanner garante que não tem uma linha vazia, talvez não seja necessário, mas é sempre bom garantir

            switch (opcao) {
                case 1 -> pacientes.add(cadastrarPaciente(sc));
                case 2 -> medicos.add(cadastrarMedico(sc));
                case 3 -> funcionarios.add(cadastrarFuncionario(sc));
                case 4 -> {
                    int idConsulta = gerador.nextInt(100000);
                    System.out.println("Qual seu nome");
                    String nome = sc.nextLine();
                }
                case 5 -> {
                    System.out.println("Lista de pacientes:\n------------------------------");
                    for (Paciente p : pacientes) {
                        System.out.println(p.exibirInfo() + "------------------------------");
                    }
                }
                case 6 -> {
                    System.out.println("Lista de médicos:\n------------------------------");
                    for (Medico m : medicos) {
                        System.out.println(m.exibirInfo() + "------------------------------");
                    }
                }
                case 7 -> {
                    System.out.println("Lista de funcionários:\n------------------------------");
                    for (Funcionario f : funcionarios) {
                        System.out.println(f.exibirInfo() + "------------------------------");
                    }
                }
                case 8 ->{
                    if (pacientes.isEmpty() || medicos.isEmpty()) {
                        System.out.println("Cadastre um paciente e um médico primeiro!");
                    } else {
                        System.out.println("Selecione o paceinte pelo indice (0 a " + (pacientes.size() - 1) + "):");
                        int idxPaciente = sc.nextInt();
                        sc.nextLine();
                        Paciente pacienteSeleciondado = pacientes.get(idxPaciente);

                        System.out.println("Selecionando o medico pelo indice (0 a " + (medicos.size() - 1) + "):");
                        int idxMedico = sc.nextInt();
                        sc.nextLine();
                        Medico medicoSelecionado = medicos.get(idxMedico);

                        if (pacienteSeleciondado.getProntuario() == null) {
                            pacienteSeleciondado.criarProntuario(gerador.nextInt(100000), null, new ArrayList<>());
                        }
                }
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("[1] - Cadastrar novo paciente");
        System.out.println("[2] - Cadastrar novo médico");
        System.out.println("[3] - Cadastrar novo funcionário");
        System.out.println("[4] - Marcar uma consulta");
        System.out.println("[5] - Consultar pacientes");
        System.out.println("[6] - Consultar médicos");
        System.out.println("[7] - Consultar funcionários");
        System.out.println("[8] - Sair");
    }

    public static Paciente cadastrarPaciente(Scanner sc) {

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
        System.out.println("Paciente cadastrado com sucesso!");
        return new Paciente(nome, partes[0] + "/" + partes[1] + "/" + partes[2], endereco, email, telefone, cpf);
    }

    public static Medico cadastrarMedico(Scanner sc) {
        Random gerador = new Random();

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

        System.out.println("Salário: ");
        double salario = sc.nextDouble();

        int crm = gerador.nextInt(100000, 120000);
        String crmString = (crm + "/SC");

        System.out.println("Especialidade: ");
        System.out.println("[1] - GINECOLOGISTA\n[2] - CARDIOLOGISTA\n[3] - DERMATOLOGISTA\n[4] - ORTOPEDISTA\n" + "[5] - PSIQUIATRA\n[6] - OFTALMOLOGISTA\n[7] - GASTROENTEROLOGISTA\n[8] - PEDIATRA");
        int especialidade = sc.nextInt();
        sc.nextLine();
        Especialidade esp = switch (especialidade) {
            case 1 -> Especialidade.GINECOLOGISTA;
            case 2 -> Especialidade.CARDIOLOGISTA;
            case 3 -> Especialidade.DERMATOLOGISTA;
            case 4 -> Especialidade.ORTOPEDISTA;
            case 5 -> Especialidade.PSIQUIATRA;
            case 6 -> Especialidade.OFTALMOLOGISTA;
            case 7 -> Especialidade.GASTROENTEROLOGISTA;
            case 8 -> Especialidade.PEDIATRA;
            default -> throw new IllegalArgumentException("Opção inválida para especialidade: " + especialidade);
        };

        System.out.println("Médico cadastrado com sucesso!");

        return new Medico(nome, partes[0] + "/" + partes[1] + "/" + partes[2], endereco, email, telefone, cpf, esp, crmString, salario);
    }

    public static Funcionario cadastrarFuncionario(Scanner sc) {

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

        System.out.println("Salario: ");
        double salario = sc.nextDouble();

        System.out.println("[1] - Recepsionista\n[2] - Gerente\n[3] - Zelador\n[4] - Auxiliar Administrativo\n[5] - Contador");
        int cargo = sc.nextInt();
        Cargos car = switch (cargo) {
            case 1 -> Cargos.RECEPCIONISTA;
            case 2 -> Cargos.GERENTE;
            case 3 -> Cargos.ZELADOR;
            case 4 -> Cargos.AULIAR_ADMINISTRATIVO;
            case 5 -> Cargos.CONTADOR;
            default -> throw new IllegalStateException("Unexpected value: " + cargo);
        };

        System.out.println("Funcionário cadastrado com sucesso!");

        return new Funcionario(nome, partes[0] + "/" + partes[1] + "/" + partes[2], endereco, email, telefone, cpf, car, salario);
    }
}
