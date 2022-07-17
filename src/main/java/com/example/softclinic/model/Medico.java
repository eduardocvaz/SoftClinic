package com.example.softclinic.model;

public class Medico {
    private String name;
    private String minit;
    private String cpf;
    private String data_nascimento;
    private int ctps;
    private String cr;
    private String sex;
    private String especialidade;

    public Medico(String name, String minit, String cpf, String data_nascimento, int ctps, String cr, String sex, String especialidade) {
        this.name = name;
        this.minit = minit;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.ctps = ctps;
        this.cr = cr;
        this.sex = sex;
        this.especialidade = especialidade;
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

    public int getCtps() {
        return ctps;
    }

    public void setCtps(int ctps) {
        this.ctps = ctps;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
