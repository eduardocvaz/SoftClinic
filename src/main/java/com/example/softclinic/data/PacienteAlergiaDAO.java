package com.example.softclinic.data;

import com.example.softclinic.data.connection.ConFactory;
import com.example.softclinic.model.Exame;
import com.example.softclinic.model.PacienteAlergia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteAlergiaDAO {

    private Connection con;
    private Statement comando;


    public PacienteAlergia search(int id_paciente_alergia) {
        PacienteAlergia pacienteAlergia = new PacienteAlergia();
        try{
            conectar();
            String sql = "SELECT * FROM paciente_alergia WHERE id_paciente_alergia = " + id_paciente_alergia;
            System.out.println("%"+sql+"%");
            ResultSet rs = comando.executeQuery(sql);
            if (rs.next()){
                pacienteAlergia = this.buildPacienteAlergia(rs);
                System.out.println(pacienteAlergia.getIdPacienteAlergia());
            }
            fechar();
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return pacienteAlergia;
    }

    public List<PacienteAlergia> search() {
        try {
            conectar();
            String sql = "SELECT * FROM paciente_alergia";
            ResultSet rs = comando.executeQuery(sql);
            List<PacienteAlergia> pacienteAlergias = new ArrayList<>();
            while (rs.next()){
                PacienteAlergia e = this.buildPacienteAlergia(rs);
                pacienteAlergias.add(e);
            }
            fechar();
            return pacienteAlergias;
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public void remove(PacienteAlergia pacienteAlergia) {

        try {
            conectar();
            String sql ="DELETE FROM paciente_alergia WHERE id_paciente_alergia=" + pacienteAlergia.getIdPacienteAlergia();
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void remove(int id_paciente_alergia) {

        try {
            conectar();
            String sql ="DELETE FROM paciente_alergia WHERE id_paciente_alergia=" + id_paciente_alergia;
            System.out.println("%"+sql+"%");
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(PacienteAlergia pacienteAlergia) {
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO paciente_alergia (");
            buffer.append(this.retornarCamposBD());
            buffer.append(") VALUES (");
            buffer.append(retornarValoresBD(pacienteAlergia));
            buffer.append(")");
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(PacienteAlergia pacienteAlergia) {

        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE paciente_alergia SET ");
            buffer.append(returnFieldValuesBD(pacienteAlergia));
            buffer.append(" WHERE id_paciente_alergia=");
            buffer.append(pacienteAlergia.getIdPacienteAlergia());
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
        return "tipo, reacao, causador, nivel";
    }

    protected String returnFieldValuesBD(PacienteAlergia e) {

        StringBuffer buffer = new StringBuffer();
        buffer.append(", tipo=");
        buffer.append(retornarValorStringBD(e.getTipo()));
        buffer.append(", reacao=");
        buffer.append(retornarValorStringBD(e.getReacao()));
        buffer.append(", causador=");
        buffer.append(retornarValorStringBD(e.getCausador()));
        buffer.append(", nivel=");
        buffer.append(retornarValorStringBD(e.getNivel()));

        return buffer.toString();
    }

    protected String retornarValoresBD(PacienteAlergia e) {
        return
                retornarValorStringBD(e.getTipo())
                        + ", "
                        + retornarValorStringBD(e.getReacao())
                        + ", "
                        + retornarValorStringBD(e.getCausador())
                        + ", "
                        + retornarValorStringBD(e.getNivel());
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

    //tipo, reacao, causador, nivel,id_paciente_alergia
    private PacienteAlergia buildPacienteAlergia(ResultSet rs) {
        PacienteAlergia pacienteAlergia = new PacienteAlergia();
        try {
            pacienteAlergia.setTipo(rs.getString("tipo"));
            pacienteAlergia.setReacao(rs.getString("reacao"));
            pacienteAlergia.setCausador(rs.getString("causador"));
            pacienteAlergia.setNivel(rs.getString("nivel"));
            pacienteAlergia.setIdPacienteAlergia(Long.parseLong(rs.getString("id_paciente_alergia")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacienteAlergia;
    }
}
