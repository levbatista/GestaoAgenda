package com.agendaapp.model;

public class Contato {
    private String telefonePessoal;
    private String telefoneRecado;
    private String cidade;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;

    public Contato(String telefonePessoal, String telefoneRecado, String cidade, String rua, String numero, String bairro, String cep) {
        this.telefonePessoal = telefonePessoal;
        this.telefoneRecado = telefoneRecado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public String getTelefonePessoal() {
        return telefonePessoal;
    }

    public String getTelefoneRecado() {
        return telefoneRecado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setTelefonePessoal(String telefonePessoal) {
        this.telefonePessoal = telefonePessoal;
    }

    public void setTelefoneRecado(String telefoneRecado) {
        this.telefoneRecado = telefoneRecado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String toString() {
        return String.format("""
            Endereço: %s, %s - %s, %s | CEP: %s
            Tel: %s | Recado: %s
            """, rua, numero, bairro, cidade, cep, telefonePessoal, telefoneRecado);
    }
}