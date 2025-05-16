package com.agendaapp.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Cliente {
    private String nome;
    private String responsavel;
    private String genero; //'M', 'F' ou 'O'
    private String dataNascimento;
    private Contato contato;

    public Cliente(String nome, String responsavel, String genero, String dataNascimento, Contato contato) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.contato = contato;
    }

    // Getters e Setters aqui

    public String getNome() {
        return nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getGenero() {
        return genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public Contato getContato() {
        return contato;
    }

    public int getIdade() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(dataNascimento, formatter);
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

    public String getFaixaEtaria() {
        int idade = getIdade();
        if (idade < 12) return "Criança";
        if (idade < 18) return  "Adolescente";
        if (idade < 60) return  "Adulto";
        return "Idoso";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String toString() {
        return String.format("""
            Nome: %s
            Responsável: %s
            Gênero: %s
            Nascimento: %s
            Idade: %d
            Faixa Etária: %s
            Contato: %s
            """, nome, responsavel, genero, dataNascimento, getIdade(), getFaixaEtaria(), contato.toString());
    };
}