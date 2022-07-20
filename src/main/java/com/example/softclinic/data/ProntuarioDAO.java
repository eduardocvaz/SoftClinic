package com.example.softclinic.data;

import com.example.softclinic.data.*;
import com.example.softclinic.data.connection.ConFactory;
import com.example.softclinic.model.Prontuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {

    private Connection con;
    private Statement comando;


    public Prontuario search(int id) {
        Prontuario prontuario = new Prontuario();
        try{
            conectar();
            String sql = "SELECT * FROM Prontuario WHERE id = " + id;
            System.out.println("%"+sql+"%");
            ResultSet rs = comando.executeQuery(sql);
            if (rs.next()){
                prontuario = this.buildProntuario(rs);
                System.out.println(prontuario.getId());
            }
            fechar();
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return prontuario;
    }

    public List<Prontuario> search() {
        try {
            conectar();
            String sql = "SELECT * FROM Prontuario";
            ResultSet rs = comando.executeQuery(sql);
            List<Prontuario> prontuarios = new ArrayList<>();
            while (rs.next()){
                Prontuario e = this.buildProntuario(rs);
                prontuarios.add(e);
            }
            fechar();
            return prontuarios;
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public void remove(Prontuario prontuario) {

        try {
            conectar();
            String sql ="DELETE FROM Prontuario WHERE id=" + prontuario.getId();
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {

        try {
            conectar();
            String sql ="DELETE FROM Prontuario WHERE id=" + id;
            System.out.println("%"+sql+"%");
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(Prontuario prontuario) {
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO Prontuario (");
            buffer.append(this.retornarCamposBD());
            buffer.append(") VALUES (");
            buffer.append(retornarValoresBD(prontuario));
            buffer.append(")");
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Prontuario prontuario) {

        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE Prontuario SET ");
            buffer.append(returnFieldValuesBD(prontuario));
            buffer.append(" WHERE id=");
            buffer.append(prontuario.getId());
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    private void conectar() throws ClassNotFoundException, SQLException {
        con = new ConFactory().conexao();
        comando = con.createStatement();
        System.out.println("Conectado!");
    }

    private void fechar() {
        try {
            comando.close();
            con.close();
            System.out.println("Conexão Fechada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected String retornarCamposBD() {
        return "paciente_cpf, tiposanguineo, observacao, id_exame, id_paciente_alergia";
    }

    protected String returnFieldValuesBD(Prontuario e) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("paciente_cpf=");
        buffer.append(retornarValorStringBD(e.getPaciente().getCpf()));
        buffer.append(", tiposanguineo=");
        buffer.append(retornarValorStringBD(e.getTiposanguineo()));
        buffer.append(", observacao=");
        buffer.append(retornarValorStringBD(e.getObservacao()));
        buffer.append(", id_exame=");
        buffer.append(e.getExame().getIdExame());
        buffer.append(", id_paciente_alergia=");
        buffer.append(e.getPacienteAlergia().getIdPacienteAlergia());

        return buffer.toString();
    }

    protected String retornarValoresBD(Prontuario e) {
        return
                retornarValorStringBD(e.getPaciente().getCpf())
                        + ", "
                        + retornarValorStringBD(e.getTiposanguineo())
                        + ", "
                        + retornarValorStringBD(e.getObservacao())
                        + ", "
                        + retornarValorIntBD(e.getExame().getIdExame())
                        + ", "
                        + retornarValorIntBD((int) e.getPacienteAlergia().getIdPacienteAlergia());
    }

    private String retornarValorIntBD(int valor) {
        String retorno;
        if (valor == 0) {
            retorno = "null";
        } else {
            retorno = ""+ valor +"";
        }
        return retorno;
    }

    private String retornarValorStringBD(String valor) {
        String retorno;
        if (valor == null) {
            retorno = "null";
        } else {
            retorno = "'" + valor + "'";
        }
        return retorno;
    }
    //"id, paciente_cpf, tiposanguineo, observacao, id_exame, id_paciente_alergia";
    private Prontuario buildProntuario(ResultSet rs) {
        Prontuario prontuario = new Prontuario();
        try {

            prontuario.setPaciente(new PacienteDAO().search(rs.getString("paciente_cpf")));
            prontuario.setTiposanguineo(rs.getString("tiposanguineo"));
            prontuario.setObservacao(rs.getString("observacao"));
            prontuario.setId(rs.getInt("id"));
            prontuario.setExame(new ExameDAO().search(rs.getInt("id_exame")));
            prontuario.setPacienteAlergia(new PacienteAlergiaDAO().search(rs.getInt("id_paciente_alergia")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prontuario;
    }
}
