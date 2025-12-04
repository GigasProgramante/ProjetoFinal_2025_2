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

            exibirMenu();

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> pacientes.add(cadastrarPaciente(sc));
                case 2 -> medicos.add(cadastrarMedico(sc));
                case 3 -> funcionarios.add(cadastrarFuncionario(sc));
                case 4 -> {}
                case 5 -> listarPacientes(pacientes);
                case 6 -> listarMedicos(medicos);
                case 7 -> listarFuncionarios(funcionarios);

                // 8: Tratamento
                case 8 -> {
                    if (pacientes.isEmpty()) {
                        System.out.println("Cadastre um paciente primeiro!");
                    } else {
                        Tratamento novoTratamento = criarTratamento(sc);

                        System.out.println("Selecione o paciente pelo índice (0 a " + (pacientes.size() - 1) + "):");
                        int idxPaciente = sc.nextInt();
                        sc.nextLine();
                        Paciente pacienteSelecionado = pacientes.get(idxPaciente);

                        if (pacienteSelecionado.getProntuario() == null) {
                            pacienteSelecionado.criarProntuario(gerador.nextInt(100000), null, new ArrayList<>());
                        }

                        novoTratamento.associarProntuario(pacienteSelecionado.getProntuario());
                        System.out.println("Tratamento associado ao prontuário com sucesso!");
                    }
                }

                // 9: Receita
                case 9 -> {
                    if (pacientes.isEmpty() || medicos.isEmpty()) {
                        System.out.println("Cadastre pelo menos um paciente e um médico primeiro!");
                    } else {
                        listarPacientes(pacientes);
                        System.out.print("Selecione o paciente pelo índice: ");
                        int idxPaciente = sc.nextInt();
                        sc.nextLine();
                        Paciente paciente = pacientes.get(idxPaciente);

                        listarMedicos(medicos);
                        System.out.print("Selecione o médico pelo índice: ");
                        int idxMedico = sc.nextInt();
                        sc.nextLine();
                        Medico medico = medicos.get(idxMedico);

                        if (paciente.getProntuario() == null) {
                            paciente.criarProntuario(gerador.nextInt(100000), null, new ArrayList<>());
                        }

                        System.out.print("ID da receita: ");
                        int idReceita = sc.nextInt();
                        sc.nextLine();

                        ArrayList<String> meds = new ArrayList<>();
                        System.out.println("Digite os medicamentos (digite 'fim' para encerrar):");
                        while (true) {
                            String med = sc.nextLine();
                            if (med.equalsIgnoreCase("fim")) break;
                            meds.add(med);
                        }

                        Receita receita = new Receita(idReceita, meds, java.time.LocalDate.now(), medico);
                        paciente.getProntuario().adicionarReceita(receita);

                        System.out.println("Receita associada ao prontuário com sucesso!");
                        paciente.getProntuario().listarReceitas();
                    }
                }

                // 10: sair
                case 10 -> {
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Opção inválida!");
            }

        }
    }

    public static void exibirMenu() {
        System.out.println("[1] - Cadastrar novo paciente");
        System.out.println("[2] - Cadastrar novo médico");
        System.out.println("[3] - Cadastrar novo funcionário");
        System.out.println("[4] - Marcar uma consulta");
        System.out.println("[5] - Listar pacientes");
        System.out.println("[6] - Listar médicos");
        System.out.println("[7] - Listar funcionários");
        System.out.println("[8] - Cadastrar Tratamento");
        System.out.println("[9] - Cadastrar Receita");
        System.out.println("[10] - Sair");
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

        return new Paciente(
                nome,
                partes[0] + "/" + partes[1] + "/" + partes[2],
                endereco,
                email,
                telefone,
                cpf
        );
    }

    public static Medico cadastrarMedico(Scanner sc) {
        Random gerador = new Random();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Endereço (Ex: Rua Alberto Pereira, 124):");
        String endereco = sc.nextLine();

        System.out.print("Data de nascimento: ");
        String dataNascimento = sc.nextLine();
        String[] partes = dataNascimento.split("/");

        System.out.print("Salário: ");
        double salario = sc.nextDouble();

        int crm = gerador.nextInt(100000, 120000);
        String crmString = (crm + "/SC");

        System.out.println("Especialidade: ");
        System.out.println("[1] - GINECOLOGISTA\n[2] - CARDIOLOGISTA\n[3] - DERMATOLOGISTA\n[4] - ORTOPEDISTA\n"
                + "[5] - PSIQUIATRA\n[6] - OFTALMOLOGISTA\n[7] - GASTROENTEROLOGISTA\n[8] - PEDIATRA");
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

        return new Medico(
                nome,
                partes[0] + "/" + partes[1] + "/" + partes[2],
                endereco,
                email,
                telefone,
                cpf,
                esp,
                crmString,
                salario
        );
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

        System.out.print("Salario: ");
        double salario = sc.nextDouble();

        System.out.println("[1] - Recepcionista\n[2] - Gerente\n[3] - Zelador\n[4] - Auxiliar Administrativo\n[5] - Contador");
        int cargo = sc.nextInt();

        Cargos car = switch (cargo) {
            case 1 -> Cargos.RECEPCIONISTA;
            case 2 -> Cargos.GERENTE;
            case 3 -> Cargos.ZELADOR;
            case 4 -> Cargos.AUXILIAR_ADMINISTRATIVO;
            case 5 -> Cargos.CONTADOR;
            default -> throw new IllegalStateException("Unexpected value: " + cargo);
        };

        System.out.println("Funcionário cadastrado com sucesso!");

        return new Funcionario(
                nome,
                partes[0] + "/" + partes[1] + "/" + partes[2],
                endereco,
                email,
                telefone,
                cpf,
                car,
                salario
        );
    }

    private static void listarPacientes(ArrayList<Paciente> pacientes) {
        int i = 0;
        System.out.println("Lista de pacientes:\n[0]---------------------------");
        for (Paciente p : pacientes) {
            System.out.println(p.exibirInfo());
            i++;
            if (i == pacientes.size()) {
                break;
            }
            System.out.println("[" + i + "]---------------------------");
        }
    }

    private static void listarMedicos(ArrayList<Medico> medicos) {
        int i = 0;
        System.out.println("Lista de médicos:\n[0]---------------------------");
        for (Medico m : medicos) {
            System.out.println(m.exibirInfo());
            i++;
            if (i == medicos.size()) {
                break;
            }
            System.out.println("[" + i + "]---------------------------");
        }
    }

    private static void listarFuncionarios(ArrayList<Funcionario> funcionarios) {
        int i = 0;
        System.out.println("Lista de funcionários:\n[0]---------------------------");
        for (Funcionario f : funcionarios) {
            System.out.println(f.exibirInfo());
            i++;
            if (i == funcionarios.size()) {
                break;
            }
            System.out.println("[" + i + "]---------------------------");
        }
    }

    public static void associarConsulta(Consulta consulta, ArrayList<Medico> medicos) {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado!");
            return;
        }

        Scanner sc3 = new Scanner(System.in);
        System.out.print("Informe o nome do médico com qual será a consulta: ");
        String nomeMedico = sc3.nextLine();

        Medico medico = medicos.get(0);
        for (Medico m : medicos) {
            if (m.getNome().equals(nomeMedico)) {
                medico = m;
                break;
            }
        }

        consulta.setMedico(medico);
        // Não fechar sc3 para não fechar System.in
    }

    public static Tratamento criarTratamento(Scanner sc) {
        System.out.println("Digite o nome do tratamento:");
        String nomeTratamento = sc.nextLine();
        System.out.println("Digite a duração em dias:");
        int duracao = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a descrição:");
        String descricao = sc.nextLine();

        return new Tratamento(nomeTratamento, duracao, descricao);
    }
}
