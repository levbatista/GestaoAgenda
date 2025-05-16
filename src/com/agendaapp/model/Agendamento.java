package com.agendaapp.model;

public class Agendamento {
    private Atendimento atendimento;
    private String dataInscricao;
    private String dataInicio;
    private String dataTermino;
    private String frequencia; // único, semanal, mensal

    public Agendamento(Atendimento atendimento, String dataInscricao, String dataInicio, String dataTermino, String frequencia) {
        this.atendimento = atendimento;
        this.dataInscricao = dataInscricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.frequencia = frequencia;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public String getDataInscricao() {
        return dataInscricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public String toString() {
        return String.format("""
            Cliente: %s
            Serviço: %s
            Início: %s | Término: %s | Frequência: %s
            Inscrição: %s
            """,
                atendimento.getCliente().getNome(),
                atendimento.getTipoServico(),
                dataInicio, dataTermino, frequencia, dataInscricao);
    }
}
