package com.agendaapp.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("X - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextLine();

            switch (opcao.toUpperCase()) {
                case "1":
                    System.out.println("Cadastro de cliente ainda não implementado.");
                    break;
                case "X":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equalsIgnoreCase("X"));

        scanner.close();
    }
}