package com.agendaapp.controller;

import com.agendaapp.model.Atendimento;
import com.agendaapp.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtendimentoController {
    private final List<Atendimento> atendimentos = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final List<Cliente> clientes;

    public AtendimentoController(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void cadastrarAtendimento() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente!");
            return;
        }

        System.out.println("==== Cadastro de Atendimento ====");
        System.out.println("Digite o nome do cliente: ");
        String nomeBusca = scanner.nextLine().trim();

        Cliente clienteSelecionado = null;
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nomeBusca)) {
                clienteSelecionado = c;
                break;
            }
        }

        if (clienteSelecionado == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Tipo de Serviço (ex: Consulta, Suporte): ");
        String tipoServico = scanner.nextLine().trim();

        System.out.print("Setor (ex: Psicologia, Financeiro): ");
        String setor = scanner.nextLine().trim();

        System.out.print("Responsável pelo atendimento: ");
        String responsavel = scanner.nextLine().trim();

        System.out.print("Supervisor (opcional): ");
        String supervisor = scanner.nextLine().trim();

        System.out.print("Status (em andamento / finalizado): ");
        String status = scanner.nextLine().trim();

        System.out.print("Observações: ");
        String observacao = scanner.nextLine().trim();

        Atendimento atendimento = new Atendimento(clienteSelecionado, tipoServico, setor, responsavel, supervisor, status, observacao);
        atendimentos.add(atendimento);
        System.out.println("Atendimento cadastrado com sucesso!");
    }

    public void listarAtendimentos() {
        System.out.println("==== Lista de Atendimentos ====");

        if (atendimentos.isEmpty()) {
            System.out.println("Nenhum atendimento registrado.");
            return;
        }

        for (Atendimento a : atendimentos) {
            System.out.println(a);
            System.out.println("-------------------------------");
        }
    }

    public void listarAtendimentoPorCliente() {
        System.out.println("Digitar o nome do cliente: ");
        String nomeBusca = scanner.nextLine().trim();

        boolean encontrou = false;
        for (Atendimento a : atendimentos) {
            if (a.getCliente().getNome().equalsIgnoreCase(nomeBusca)) {
                if (!encontrou) {
                    System.out.println("==== Atendimentos para " + nomeBusca + " ====");
                    encontrou = true;
                }
                System.out.println(a);
                System.out.println("-------------------------------");
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum atendimento encontrado para este cliente.");
        }
    }
    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }
}
