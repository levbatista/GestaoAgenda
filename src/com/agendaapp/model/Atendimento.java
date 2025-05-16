package com.agendaapp.model;

public class Atendimento {
    private Cliente cliente;
    private String tipoServico;
    private String setor;
    private String responsavelAtendimento;
    private String supervisor;
    private String status;
    private String observacao;

    public Atendimento(Cliente cliente, String tipoServico, String setor, String responsavelAtendimento, String supervisor, String status, String observacao) {
        this.cliente = cliente;
        this.tipoServico = tipoServico;
        this.setor = setor;
        this.responsavelAtendimento = responsavelAtendimento;
        this.supervisor = supervisor;
        this.status = status;
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public String getSetor() {
        return setor;
    }

    public String getResponsavelAtendimento() {
        return responsavelAtendimento;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getStatus() {
        return status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String toString() {
        return String.format("""
                Cliente: %s
                Tipo de Serviço: %s
                Setor: %s
                Responsável: %s
                Supervisor: %s
                Status: %s
                Observação: %s
                """, cliente.getNome(), tipoServico, setor, responsavelAtendimento, supervisor, status, observacao);
    }
}
