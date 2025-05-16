package com.agendaapp.controller;

import com.agendaapp.model.Atendimento;
import com.agendaapp.model.Cliente;
import com.agendaapp.model.Contato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void cadastrarCliente() {
        System.out.println("==== Cadastro de Cliente ====");

        System.out.println("Nome: ");
        String nome = lerTextoObrigatorio();

        System.out.println("Responsável: ");
        String responsavel = lerTextoObrigatorio();

        String genero;
        while (true) {
            System.out.println("Gênero (M/F/O): ");
            String generoInput = scanner.nextLine().trim().toUpperCase();
            if (generoInput.equals("M")) {
                genero = "Masculino";
                break;
            } else if (generoInput.equals("F")) {
                genero = "Feminino";
                break;
            } else if (generoInput.equals("O")) {
                System.out.println("Digite o gênero desejado: ");
                genero = lerTextoObrigatorio();
                break;
            } else {
                System.out.println("Entrada inválida. Digite M, F, ou O");
            }
        }


        String dataNascimento;
        while (true) {
            System.out.println("Data de nascimento (DD/MM/AAAA): ");
            dataNascimento = scanner.next().trim();
            if (validarData(dataNascimento)) break;
            else System.out.println("Data inválida. Use o formato DD/MM/AAAA.");
        }

        // Contato
        System.out.println("===== Contato =====");
        scanner.nextLine();
        System.out.print("Telefone Pessoal: ");
        String telefonePessoal = lerTextoObrigatorio();

        System.out.print("Telefone Recado: ");
        String telefoneRecado = lerTextoObrigatorio();

        System.out.print("Cidade: ");
        String cidade = lerTextoObrigatorio();;

        System.out.print("Rua: ");
        String rua = lerTextoObrigatorio();

        System.out.print("Número: ");
        String numero = lerTextoObrigatorio();

        System.out.print("Bairro: ");
        String bairro = lerTextoObrigatorio();

        System.out.print("CEP: ");
        String cep = lerTextoObrigatorio();

        Contato contato = new Contato(telefonePessoal, telefoneRecado, cidade, rua, numero, bairro, cep);
        Cliente cliente = new Cliente(nome, responsavel, genero, dataNascimento, contato);

        clientes.add(cliente);
        System.out.println("\nCliente cadastrado com sucesso!");
    }

    public void listarClientes () {
        System.out.println("==== Lista de Clientes ====");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println(c);
            System.out.println("---------------------------");
        }
    }

    private String lerTextoObrigatorio() {
        String entrada;
        do {
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Campo obrigatório. Digite novamente: ");
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    private boolean validarData(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(data, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void editarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado para editar.");
            return;
        }

        System.out.println("Digite o nome do cliente que deseja editar: ");
        String nomeBusca = scanner.nextLine().trim();

        Cliente clienteEncontrado = null;
        for (Cliente c: clientes) {
            if (c.getNome().equalsIgnoreCase(nomeBusca)) {
                clienteEncontrado = c;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.println("Cliente encontrado: ");
        System.out.println(clienteEncontrado);
        System.out.println("\nDigite ENTER para manter o valor atual.");

        System.out.println("Cliente encontrado:");
        System.out.println(clienteEncontrado);
        System.out.println("\nDigite ENTER para manter o valor atual.");

        System.out.print("Novo nome [" + clienteEncontrado.getNome() + "]: ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isBlank()) clienteEncontrado.setNome(novoNome);

        System.out.print("Novo responsável [" + clienteEncontrado.getResponsavel() + "]: ");
        String novoResponsavel = scanner.nextLine();
        if (!novoResponsavel.isBlank()) clienteEncontrado.setResponsavel(novoResponsavel);

        System.out.print("Novo gênero [" + clienteEncontrado.getGenero() + "]: ");
        String novoGenero = scanner.nextLine();
        if (!novoGenero.isBlank()) clienteEncontrado.setGenero(novoGenero);

        System.out.print("Nova data de nascimento [" + clienteEncontrado.getDataNascimento() + "]: ");
        String novaData = scanner.nextLine();
        if (!novaData.isBlank() && validarData(novaData)) {
            clienteEncontrado.setDataNascimento(novaData);
        }

        // Atualizando contato
        Contato contato = clienteEncontrado.getContato();

        System.out.print("Novo telefone pessoal [" + contato.getTelefonePessoal() + "]: ");
        String tel = scanner.nextLine();
        if (!tel.isBlank()) contato.setTelefonePessoal(tel);

        System.out.print("Novo telefone recado [" + contato.getTelefoneRecado() + "]: ");
        String recado = scanner.nextLine();
        if (!recado.isBlank()) contato.setTelefoneRecado(recado);

        System.out.print("Nova cidade [" + contato.getCidade() + "]: ");
        String cidade = scanner.nextLine();
        if (!cidade.isBlank()) contato.setCidade(cidade);

        System.out.print("Nova rua [" + contato.getRua() + "]: ");
        String rua = scanner.nextLine();
        if (!rua.isBlank()) contato.setRua(rua);

        System.out.print("Novo número [" + contato.getNumero() + "]: ");
        String numero = scanner.nextLine();
        if (!numero.isBlank()) contato.setNumero(numero);

        System.out.print("Novo bairro [" + contato.getBairro() + "]: ");
        String bairro = scanner.nextLine();
        if (!bairro.isBlank()) contato.setBairro(bairro);

        System.out.print("Novo CEP [" + contato.getCep() + "]: ");
        String cep = scanner.nextLine();
        if (!cep.isBlank()) contato.setCep(cep);

        System.out.println("\nCliente atualizado com sucesso!");
    }

    public void excluirCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado para excluir.");
            return;
        }

        System.out.print("Digite o nome do cliente que deseja excluir: ");
        String nomeBusca = scanner.nextLine().trim();

        Cliente clienteEncontrado = null;
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nomeBusca)) {
                clienteEncontrado = c;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("\nCliente encontrado:");
        System.out.println(clienteEncontrado);
        System.out.print("Deseja realmente excluir este cliente? (S/N): ");
        String confirmacao = scanner.nextLine().trim().toUpperCase();

        if (confirmacao.equals("S")) {
            clientes.remove(clienteEncontrado);
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Exclusão cancelada.");
        }
    }

}