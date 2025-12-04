package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Sistema de gerenciamento de consultas em linha de comando.
 * Este programa permite cadastrar pacientes, médicos e funcionários,
 * além de marcar consultas, criar tratamentos e registrar receitas,
 * exibindo um menu iterativo para o usuário.
 */
public class main {

    /**
     * Scanner compartilhado para entrada de dados do usuário via console.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Gerador de números aleatórios utilizado, por exemplo, para criar IDs.
     */
    private static Random gerador = new Random();

    /**
     * Ponto de entrada do sistema.
     * Exibe um menu contínuo permitindo a execução das operações disponíveis.
     *
     * @param args argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        System.out.println("Bem vindo ao sistema de gerenciamento de consultas");
        ClinicaMedica clinica = new ClinicaMedica(
                "Clínica Médica Santa Saúde",
                "12.345.678/0001-90",
                "Rua Exemplo, 123",
                "(47) 99999-9999",
                "contato@clinicasantasaude.com",
                "Itaiópolis",
                "SC"
        );

        // Loop principal do menu
        while (true) {

            // Exibe as opções
            exibirMenu();

            // Lê a opção escolhida pelo usuário
            int opcao = sc.nextInt();
            sc.nextLine(); // Consome quebra de linha pendente

            switch (opcao) {
                case 1 -> pacientes.add(cadastrarPaciente(sc));
                case 2 -> medicos.add(cadastrarMedico(sc));
                case 3 -> funcionarios.add(cadastrarFuncionario(sc));

                // Marcar uma consulta
                case 4 -> {
                    System.out.print("Insira o nome do paciente: ");
                    String nomePaciente = sc.nextLine();

                    // Busca paciente pelo nome (case-insensitive)
                    Paciente pacienteSelecionado = null;
                    for (Paciente p : pacientes) {
                        if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                            pacienteSelecionado = p;
                            break;
                        }
                    }

                    if (pacienteSelecionado == null) {
                        System.out.println("Paciente não encontrado!!!");
                        break;
                    }

                    if (medicos.isEmpty()) {
                        System.out.println("Nenhum médico cadastrado!");
                        break;
                    }

                    System.out.print("Informe o nome do médico com qual será a consulta: ");
                    String nomeMedico = sc.nextLine();

                    // Busca médico pelo nome (case-insensitive)
                    Medico medicoSelecionado = null;
                    for (Medico m : medicos) {
                        if (m.getNome().equalsIgnoreCase(nomeMedico)) {
                            medicoSelecionado = m;
                            break;
                        }
                    }

                    if (medicoSelecionado == null) {
                        System.out.println("Médico não encontrado!");
                        break;
                    }

                    // Realiza o agendamento de consulta para o paciente com o médico selecionado
                    Consulta consulta = pacienteSelecionado.marcarConsulta(medicoSelecionado, sc);
                }

                // Listagens
                case 5 -> listarPacientes(pacientes);
                case 6 -> listarMedicos(medicos);
                case 7 -> listarFuncionarios(funcionarios);

                // Cadastrar Tratamento
                case 8 -> {
                    if (pacientes.isEmpty()) {
                        System.out.println("Cadastre um paciente primeiro!");
                    } else {
                        Tratamento novoTratamento = criarTratamento(sc);

                        System.out.print("Digite o nome do paciente: ");
                        String nomePaciente = sc.nextLine();

                        Paciente pacienteSelecionado = null;
                        for (Paciente p : pacientes) {
                            if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                                pacienteSelecionado = p;
                                break;
                            }
                        }

                        if (pacienteSelecionado == null) {
                            System.out.println("Paciente não encontrado!");
                        } else {
                            novoTratamento.associarProntuario(pacienteSelecionado.getProntuario());
                            System.out.println("Tratamento associado ao prontuário com sucesso!");
                        }
                    }
                }

                // Cadastrar Receita
                case 9 -> {
                    if (pacientes.isEmpty() || medicos.isEmpty()) {
                        System.out.println("Cadastre pelo menos um paciente e um médico primeiro!");
                    } else {
                        // --- PACIENTE POR NOME ---
                        System.out.print("Digite o nome do paciente: ");
                        String nomePaciente = sc.nextLine();

                        Paciente paciente = null;
                        for (Paciente p : pacientes) {
                            if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                                paciente = p;
                                break;
                            }
                        }

                        if (paciente == null) {
                            System.out.println("Paciente não encontrado!");
                            break;
                        }

                        // --- MÉDICO POR NOME ---
                        System.out.print("Digite o nome do médico: ");
                        String nomeMedico = sc.nextLine();

                        Medico medico = null;
                        for (Medico m : medicos) {
                            if (m.getNome().equalsIgnoreCase(nomeMedico)) {
                                medico = m;
                                break;
                            }
                        }

                        if (medico == null) {
                            System.out.println("Médico não encontrado!");
                            break;
                        }

                        int idReceita = gerador.nextInt(100000, 999999);

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

                // Sair
                case 10 -> {
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    return;
                }

                // Popular dados básicos rapidamente
                case 11 -> {
                    Paciente pppppp = new Paciente("Guilherme", "24/04/2006", "Rua Alfredo Constantino, 1234", "guivoj@gmail.com", "1234567", "123456");
                    Paciente ppppp2 = new Paciente("Ronei", "02/10/2000", "Rua Bernadete, 2004", "ronei@gmail.com", "654342", "678901");
                    pacientes.add(pppppp);
                    pacientes.add(ppppp2);
                    Medico mmmmmm = new Medico("Henrique", "10/08/1990", "Avenida Carlinhos, 326", "henri@gmail.com", "324563", "635256", Especialidade.CARDIOLOGISTA, "12332134123", 2200);
                    Medico mmmmm2 = new Medico("Gregory", "10/08/1980", "Avenida Carlinhos, 589", "greg@gmail.com", "354566", "424124", Especialidade.DERMATOLOGISTA, "6542345346", 4400);
                    medicos.add(mmmmmm);
                    medicos.add(mmmmm2);
                }
                case 12 -> {
                    if (pacientes.isEmpty()) {
                        System.out.println("Cadastre um paciente primeiro!");
                        break;
                    }

                    System.out.print("Digite o nome do paciente: ");
                    String nomePaciente = sc.nextLine();

                    Paciente pacienteSelecionado = null;
                    for (Paciente p : pacientes) {
                        if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                            pacienteSelecionado = p;
                            break;
                        }
                    }

                    if (pacienteSelecionado == null) {
                        System.out.println("Paciente não encontrado!");
                    } else {
                        pacienteSelecionado.getProntuario().exibirProntuarioCompleto();
                    }
                }
                case 13 -> System.out.println(clinica.exibirInfo());
                default -> System.out.println("Opção inválida!");
            }

        }
    }

    /**
     * Exibe no console o menu de opções disponíveis para o usuário.
     */
    public static void exibirMenu() {
        System.out.println("[01] - Cadastrar novo paciente");
        System.out.println("[02] - Cadastrar novo médico");
        System.out.println("[03] - Cadastrar novo funcionário");
        System.out.println("[04] - Marcar uma consulta");
        System.out.println("[05] - Listar pacientes");
        System.out.println("[06] - Listar médicos");
        System.out.println("[07] - Listar funcionários");
        System.out.println("[08] - Cadastrar Tratamento");
        System.out.println("[09] - Cadastrar Receita");
        System.out.println("[10] - Sair");
        System.out.println("[11] - Instanciar o Básico");
        System.out.println("[12] - Exibir Prontuario");
        System.out.println("[13] - Exibir Detalhes da Clinica");
    }

    /**
     * Coleta as informações do usuário e cria um novo paciente.
     *
     * @param sc scanner a ser utilizado na leitura dos campos.
     * @return uma instância de Paciente preenchida com os dados informados.
     */
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

    /**
     * Coleta as informações do usuário e cria um novo médico.
     * Também permite a seleção da especialidade.
     *
     * @param sc scanner a ser utilizado na leitura dos campos.
     * @return uma instância de Medico preenchida com os dados informados.
     * @throws IllegalArgumentException se a especialidade informada não existir.
     */
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

        return new Medico(nome, partes[0] + "/" + partes[1] + "/" + partes[2], endereco, email, telefone, cpf, esp, crmString, salario);
    }

    /**
     * Coleta as informações do usuário e cria um novo funcionário.
     * Também permite a seleção do cargo.
     *
     * @param sc scanner a ser utilizado na leitura dos campos.
     * @return uma instância de Funcionario preenchida com os dados informados.
     * @throws IllegalStateException se o cargo informado não for reconhecido.
     */
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

        return new Funcionario(nome, partes[0] + "/" + partes[1] + "/" + partes[2], endereco, email, telefone, cpf, car, salario);
    }

    /**
     * Exibe no console a lista de pacientes cadastrados com um separador visual.
     *
     * @param pacientes lista de pacientes a exibir.
     */
    private static void listarPacientes(ArrayList<Paciente> pacientes) {
        int i=0;
        System.out.println("Lista de pacientes:\n[1]---------------------------");
        for (Paciente p : pacientes) {
            System.out.println(p.exibirInfo());
            i++;
            if (i == pacientes.size()) {
                break;
            }
            System.out.println("[" + (i + 1) + "]---------------------------");
        }
    }

    /**
     * Exibe no console a lista de médicos cadastrados com um separador visual.
     *
     * @param medicos lista de médicos a exibir.
     */
    private static void listarMedicos(ArrayList<Medico> medicos) {
        int i=0;
        System.out.println("Lista de médicos:\n[1]---------------------------");
        for (Medico m : medicos) {
            System.out.println(m.exibirInfo());
            i++;
            if (i == medicos.size()) {
                break;
            }
            System.out.println("[" + (i + 1) + "]---------------------------");
        }
    }

    /**
     * Exibe no console a lista de funcionários cadastrados com um separador visual.
     *
     * @param funcionarios lista de funcionários a exibir.
     */
    private static void listarFuncionarios(ArrayList<Funcionario> funcionarios) {
        int i=0;
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

    /**
     * Cria um tratamento a partir dos dados informados pelo usuário.
     *
     * @param sc scanner utilizado para leitura dos dados.
     * @return uma instância de Tratamento com nome, duração e descrição.
     */
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
