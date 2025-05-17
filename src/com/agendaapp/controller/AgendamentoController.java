package com.agendaapp.controller;

import com.agendaapp.model.Agendamento;
import com.agendaapp.model.Atendimento;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendamentoController {
    private final List<Agendamento> agendamentos = new ArrayList<>();
    private final List<Atendimento> atendimentos;
    private final Scanner scanner = new Scanner(System.in);

    public AgendamentoController(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public void cadastrarAgendamento() {
        if (atendimentos.isEmpty()) {
            System.out.println("Nenhum atendimento registrado. Cadastre um atendimento primeiro.");
            return;
        }

        System.out.println("===== Cadastro de Agendamento =====");
        System.out.print("Digite o nome do cliente para agendar: ");
        String nomeBusca = scanner.nextLine().trim();

        List<Atendimento> opcoes = new ArrayList<>();
        for (Atendimento a : atendimentos) {
            if (a.getCliente().getNome().equalsIgnoreCase(nomeBusca)) {
                opcoes.add(a);
            }
        }

        if (opcoes.isEmpty()) {
            System.out.println("Nenhum atendimento encontrado para esse cliente.");
            return;
        }

        System.out.println("Atendimentos encontrados:");
        for (int i = 0; i < opcoes.size(); i++) {
            System.out.printf("[%d] %s - %s\n", i + 1, opcoes.get(i).getTipoServico(), opcoes.get(i).getStatus());
        }

        System.out.print("Escolha o atendimento (número): ");
        int escolha = Integer.parseInt(scanner.nextLine()) - 1;

        if (escolha < 0 || escolha >= opcoes.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Atendimento atendimentoSelecionado = opcoes.get(escolha);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataInscricao = lerDataValida("Data de inscrição (DD/MM/AAAA): ");
        LocalDate dataInicio = lerDataValida("Data de início (DD/MM/AAAA): ");
        LocalDate dataTermino;

        while (true) {
            dataTermino = lerDataValida("Data de término (DD/MM/AAAA): ");
            if (!dataTermino.isBefore(dataInicio)) break;
            System.out.println("A data de término não pode ser antes da data de início.");
        }

        System.out.print("Frequência (único / semanal / mensal): ");
        String frequencia = scanner.nextLine().trim();

        Agendamento agendamento = new Agendamento(
                atendimentoSelecionado,
                dataInscricao.format(formatter),
                dataInicio.format(formatter),
                dataTermino.format(formatter),
                frequencia
        );

        agendamentos.add(agendamento);
        System.out.println("Agendamento registrado com sucesso.");
    }

    public void listarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento registrado.");
            return;
        }

        System.out.println("===== Lista de Agendamentos =====");
        for (Agendamento a : agendamentos) {
            System.out.println(a);
            System.out.println("-------------------------------");
        }
    }

    public void listarPorCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine().trim();

        boolean encontrado = false;

        for (Agendamento a : agendamentos) {
            if (a.getAtendimento().getCliente().getNome().equalsIgnoreCase(nome)) {
                if (!encontrado) {
                    System.out.println("Agendamentos de " + nome + ":");
                    encontrado = true;
                }
                System.out.println(a);
                System.out.println("-------------------------------");
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum agendamento encontrado para este cliente.");
        }
    }

    public void exportarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento para exportar.");
            return;
        }

        String nomePasta = "export";
        String nomeArquivo = nomePasta + "/agendamentos_exportados.txt";

        try {
            // Cria a pasta export se ela não existir
            java.nio.file.Files.createDirectories(java.nio.file.Paths.get(nomePasta));

            try (PrintWriter writer = new PrintWriter(nomeArquivo)) {
                writer.println("===== Lista de Agendamentos =====\n");

                for (Agendamento a : agendamentos) {
                    writer.println(a.toString());
                    writer.println("-------------------------------");
                }

                System.out.println("Agendamentos exportados com sucesso para o arquivo: " + nomeArquivo);
            }

        } catch (Exception e) {
            System.out.println("Erro ao exportar agendamentos: " + e.getMessage());
        }
    }

    // Métodos auxiliares de validação de data

    private boolean validarData(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(data, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private LocalDate lerDataValida(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            if (validarData(entrada)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return LocalDate.parse(entrada, formatter);
            } else {
                System.out.println("Data inválida. Use o formato DD/MM/AAAA.");
            }
        }
    }
}
