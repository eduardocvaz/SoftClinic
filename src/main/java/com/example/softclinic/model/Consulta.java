package com.example.softclinic.model;

public class Consulta {
    private int idConsulta;
    private String horario;
    private String dia;
    private Atendente atendente;
    private Medico medico;
    private Paciente paciente;

    public Consulta(int idConsulta, String horario, String dia, Atendente atendente, Medico medico, Paciente paciente) {
        this.idConsulta = idConsulta;
        this.horario = horario;
        this.dia = dia;
        this.atendente = atendente;
        this.medico = medico;
        this.paciente = paciente;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
