package Principal;

import java.util.Scanner;

import Clinica.GerenciamentoClinica;
import Clinica.Medico;
import Clinica.Paciente;
import Eventos.GerenciamentoEventos;
import Restaurante.GerenciamentoRestaurante;

public class Shopping {
    private GerenciamentoClinica gerenciamentoClinica;
    private GerenciamentoRestaurante gerenciamentoRestaurante;
    private GerenciamentoEventos gerenciamentoEventos;

    public Shopping() {
        this.gerenciamentoClinica = new GerenciamentoClinica();
        this.gerenciamentoRestaurante = new GerenciamentoRestaurante(20);
        this.gerenciamentoEventos = new GerenciamentoEventos();
    }

    public void iniciarSistema() {
        System.out.println("Bem-vindo ao Sistema de Gerenciamento do Shopping!");
        exibirMenu();
    }

    private void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gerenciar Clínica");
            System.out.println("2. Gerenciar Restaurante");
            System.out.println("3. Gerenciar Eventos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1 -> menuClinica(scanner);
                case 2 -> menuRestaurante(scanner);
                case 3 -> menuEventos(scanner);
                case 4 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private void menuClinica(Scanner scanner) {
        System.out.println("\n--- Gerenciamento de Clínica ---");
        System.out.println("1. Cadastrar Paciente");
        System.out.println("2. Cadastrar Médico");
        System.out.println("3. Agendar Consulta");
        System.out.println("4. Gerar Relatório de Consultas");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> {
                System.out.print("Nome do paciente: ");
                String nome = scanner.nextLine();
                System.out.print("CPF do paciente: ");
                String cpf = scanner.nextLine();
                Paciente paciente = new Paciente(nome, cpf);
                gerenciamentoClinica.adicionarPaciente(paciente);
            }
            case 2 -> {
                System.out.print("Nome do médico: ");
                String nome = scanner.nextLine();
                System.out.print("CRM do médico: ");
                String crm = scanner.nextLine();
                Medico medico = new Medico(nome, crm);
                gerenciamentoClinica.adicionarMedico(medico);
            }
            case 3 -> {
                System.out.print("CPF do paciente: ");
                String cpfPaciente = scanner.nextLine();
                System.out.print("CRM do médico: ");
                String crmMedico = scanner.nextLine();
                System.out.print("Data e hora da consulta: ");
                String dataHora = scanner.nextLine();
                gerenciamentoClinica.agendarConsulta(cpfPaciente, crmMedico, dataHora);
            }
            case 4 -> gerenciamentoClinica.relatorioConsultas();
            default -> System.out.println("Opção inválida.");
        }
    }

    private void menuRestaurante(Scanner scanner) {
        System.out.println("\n--- Gerenciamento de Restaurante ---");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Fechar Conta");
        System.out.println("3. Gerar Relatório de Vendas");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> {
                System.out.print("Número da mesa: ");
                int numeroMesa = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nome do item: ");
                String nomeItem = scanner.nextLine();
                System.out.print("Preço do item: ");
                double preco = scanner.nextDouble();
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                gerenciamentoRestaurante.adicionarItemPedido(numeroMesa, nomeItem, quantidade, preco);
            }
            case 2 -> {
                System.out.print("Número da mesa: ");
                int numeroMesa = scanner.nextInt();
                gerenciamentoRestaurante.fecharPedidoMesa(numeroMesa);
            }
            case 3 -> gerenciamentoRestaurante.gerarRelatorioVendas();
            default -> System.out.println("Opção inválida.");
        }
    }

    private void menuEventos(Scanner scanner) {
        System.out.println("\n--- Gerenciamento de Eventos ---");
        System.out.println("1. Cadastrar Evento");
        System.out.println("2. Registrar Participante");
        System.out.println("3. Gerar Relatório de Participação");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1 -> {
                System.out.print("Nome do evento: ");
                String nomeEvento = scanner.nextLine();
                System.out.print("Data e hora do evento: ");
                String local = scanner.nextLine();
                System.out.print("Local: ");
                String capacidade =scanner.nextLine();
                gerenciamentoEventos.cadastrarEvento(nomeEvento, local, capacidade);
            }
            case 2 -> {
                System.out.print("Nome do evento: ");
                String nomeEvento = scanner.nextLine();
                System.out.print("Nome do participante: ");
                String nomeParticipante = scanner.nextLine();
                gerenciamentoEventos.cadastrarParticipante(nomeEvento, nomeParticipante);
            }
            case 3 -> gerenciamentoEventos.gerarRelatorioEventos();
            default -> System.out.println("Opção inválida.");
        }
    }
}
