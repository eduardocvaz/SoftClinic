package com.example.softclinic.model;

public class Paciente {
    private String name;
    private String minit;
    private String cpf;
    private String data_nascimento;
    private String sex;

    public Paciente(String name, String minit, String cpf, String data_nascimento, String sex) {
        this.name = name;
        this.minit = minit;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
