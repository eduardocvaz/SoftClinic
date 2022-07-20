package com.example.softclinic;

import com.example.softclinic.data.*;
import com.example.softclinic.data.ProntuarioDAO;
import com.example.softclinic.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        Date data = new java.sql.Date(format.parse("2012-09-13").getTime());
        //"cpf, nome, sobrenome, data_nascimento, telefone, sexo, cr, especialidade, numeroctps"
        Medico medico = new Medico("11111111111", "teste", "do teste", "2012-09-13","9999999",1111,"1111","F","Clinico geral");


//        //new MedicoDAO().insert(medico);
//        System.out.println(new MedicoDAO().search("11111111111").toString());
//        new MedicoDAO().search().forEach(medic-> System.out.println(medic.toString()));


        Paciente paciente = new Paciente("1111","2222","33336333333", "2012-09-13", "F", "999999999");
//        new PacienteDAO().insert(paciente);
//        System.out.println(new PacienteDAO().search("33336333333").toString());
//        new PacienteDAO().search().forEach(medic-> System.out.println(medic.toString()));
//
//
        Atendente atendente = new Atendente("1111","2222","33336333333", "2012-09-13",11111, "99999999", "F");
//        new AtendenteDAO().insert(atendente);
//        System.out.println(new AtendenteDAO().search("33336333333").toString());
//        new AtendenteDAO().search().forEach(medic-> System.out.println(medic.toString()));
//
        Administrador administrador = new Administrador("1111","2222","33336333333", "2012-09-13", "F","9999999999", 11111);
//        new AdministradorDAO().insert(administrador);
//        System.out.println(new AdministradorDAO().search("33336333333").toString());
//        new AdministradorDAO().search().forEach(medic-> System.out.println(medic.toString()));
//
        Consulta consulta = new Consulta("11:00","2012-09-13", atendente,medico, paciente);
//        new ConsultaDAO().insert(consulta);
//        System.out.println(new ConsultaDAO().search(1).toString());
//        new ConsultaDAO().search().forEach(medic-> System.out.println(medic.toString()));

        Exame exame = new Exame("CCCC","222", true);
//        new ExameDAO().insert(exame);
//        System.out.println(new ExameDAO().search(1).toString());
//        new ExameDAO().search().forEach(medic-> System.out.println(medic.toString()));
//        new ExameDAO().remove(0);

        PacienteAlergia pacienteAlergia = new PacienteAlergia("alergica","vermelhidão", "cigarro","alto");
//        new PacienteAlergiaDAO().insert(pacienteAlergia);
////        System.out.println(new PacienteAlergiaDAO().search(1).toString());
//        new PacienteAlergiaDAO().search().forEach(medic-> System.out.println(medic.toString()));


        Prontuario prontuario = new Prontuario(paciente,"A+", "Paciente gosta de um cigarrinho",new ExameDAO().search(2),new PacienteAlergiaDAO().search(1));
//        new ProntuarioDAO().insert(prontuario);
////        System.out.println(new PacienteAlergiaDAO().search(1).toString());
//        new ProntuarioDAO().search().forEach(medic-> System.out.println(medic.toString()));

//        Prontuario prontuario = new Prontuario(paciente,"A+", "Paciente gosta de um cigarrinho",new Exame(),new PacienteAlergia());
//        new ProntuarioDAO().insert(prontuario);
////        System.out.println(new PacienteAlergiaDAO().search(1).toString());
        new ProntuarioDAO().search().forEach(medic-> System.out.println(medic.toString()));
//        System.out.println(prontuario.getPacienteAlergia().getIdPacienteAlergia());
    }
}
