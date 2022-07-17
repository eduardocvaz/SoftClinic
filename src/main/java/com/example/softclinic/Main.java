package com.example.softclinic;

import com.example.softclinic.data.MedicoDAO;
import com.example.softclinic.model.Medico;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date data = new java.sql.Date(format.parse("2012-09-13").getTime());
        //"cpf, nome, sobrenome, data_nascimento, telefone, sexo, cr, especialidade, numeroctps"
        Medico medico = new Medico("11111111111", "teste", "do teste", "2012-09-13","9999999",1111,"1111","F","Clinico geral");

        //new MedicoDAO().insert(medico);
        System.out.println(new MedicoDAO().search("11111111111").toString());
        new MedicoDAO().search().forEach(medic-> System.out.println(medic.toString()));
    }
}
