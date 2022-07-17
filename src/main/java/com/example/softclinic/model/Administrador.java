package com.example.softclinic.model;

public class Administrador {
    private String name;
    private String minit;
    private String cpf;
    private String data_nascimento;
    private String sex;
    private String numberCTPS;

    public String getNumberCTPS() {
        return numberCTPS;
    }

    public void setNumberCTPS(String numberCTPS) {
        this.numberCTPS = numberCTPS;
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
