package com.example.softclinic.model;

public class Consulta {
    private int idConsulta;
    private String horario;
    private String dia;
    private String atendente_cpf;
    private Medico medico;
    private String paciente_cpf;

    public String getAtendente_cpf() {
        return atendente_cpf;
    }

    public void setAtendente_cpf(String atendente_cpf) {
        this.atendente_cpf = atendente_cpf;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getPaciente_cpf() {
        return paciente_cpf;
    }

    public void setPaciente_cpf(String paciente_cpf) {
        this.paciente_cpf = paciente_cpf;
    }

    public Consulta(int idConsulta, String horario, String dia) {
        this.idConsulta = idConsulta;
        this.horario = horario;
        this.dia = dia;
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
}
