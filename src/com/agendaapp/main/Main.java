package com.agendaapp.main;

import com.agendaapp.controller.AgendamentoController;
import com.agendaapp.controller.AtendimentoController;
import com.agendaapp.controller.ClienteController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Controllers Principais
        ClienteController clienteController = new ClienteController();
        AtendimentoController atendimentoController = new AtendimentoController(clienteController.getClientes());
        AgendamentoController agendamentoController = new AgendamentoController(atendimentoController.getAtendimentos());
        String opcao;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listas Clientes");
            System.out.println("3 - Editar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Cadastrar Atendimento");
            System.out.println("6 - Listar Atendimentos");
            System.out.println("7 - Atendimentos por Cliente");
            System.out.println("X - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextLine();

            switch (opcao.toUpperCase()) {
                case "1":
                    clienteController.cadastrarCliente();
                    break;
                case "2":
                    clienteController.listarClientes();
                    break;
                case "3":
                    clienteController.editarCliente();
                    break;
                case "4":
                    clienteController.excluirCliente();
                    break;
                case "5":
                    atendimentoController.cadastrarAtendimento();
                    break;
                case "6":
                    atendimentoController.listarAtendimentos();
                    break;
                case "7":
                    atendimentoController.listarAtendimentoPorCliente();
                    break;
                case "8":
                    agendamentoController.cadastrarAgendamento();
                    break;
                case "9":
                    agendamentoController.listarAgendamentos();
                    break;
                case "10":
                    agendamentoController.listarPorCliente();
                    break;
                case "X":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println(); // espaço entre execuções

        } while (!opcao.equalsIgnoreCase("X"));

        scanner.close();
    }
}