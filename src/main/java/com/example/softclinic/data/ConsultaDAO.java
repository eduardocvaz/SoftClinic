package com.example.softclinic.data;

import com.example.softclinic.data.connection.ConFactory;
import com.example.softclinic.model.Consulta;
import com.example.softclinic.model.Medico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    private Connection con;
    private Statement comando;

    public Consulta search(int idconsulta) {
        Consulta consulta = new Consulta();
        try{
            conectar();
            String sql = "SELECT * FROM Consulta WHERE idconsulta = " + idconsulta;
            System.out.println("%"+sql+"%");
            ResultSet rs = comando.executeQuery(sql);
            if (rs.next()){
                consulta = this.buildConsulta(rs);
                System.out.println(consulta.getIdConsulta());
            }
            fechar();
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return consulta;
    }

    public List<Consulta> search() {
        try {
            conectar();
            String sql = "SELECT * FROM Consulta";
            ResultSet rs = comando.executeQuery(sql);
            List<Consulta> consults = new ArrayList<>();
            while (rs.next()){
                Consulta e = this.buildConsulta(rs);
                consults.add(e);
            }
            fechar();
            return consults;
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public void remove(Consulta consulta) {

        try {
            conectar();
            String sql ="DELETE FROM Consulta WHERE idconsulta=" + consulta.getIdConsulta();
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void remove(int idconsulta) {

        try {
            conectar();
            String sql ="DELETE FROM Consulta WHERE idconsulta=" + idconsulta;
            System.out.println("%"+sql+"%");
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(Consulta consulta) {
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO Consulta (");
            buffer.append(this.retornarCamposBD());
            buffer.append(") VALUES (");
            buffer.append(retornarValoresBD(consulta));
            buffer.append(")");
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Consulta consulta) {

        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE consulta SET ");
            buffer.append(returnFieldValuesBD(consulta));
            buffer.append(" WHERE idconsulta=");
            buffer.append(this.retornarValorStringBD(String.valueOf(consulta.getIdConsulta())));
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
        return "atendente_cpf, horario, dia, medico_cpf, paciente_cpf";
    }

    protected String returnFieldValuesBD(Consulta e) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("atendente_cpf=");
        buffer.append(retornarValorStringBD(e.getAtendente().getCpf()));
        buffer.append(", horario=");
        buffer.append(retornarValorStringBD(e.getHorario()));
        buffer.append(", dia=");
        buffer.append(retornarValorStringBD(e.getDia()));
        buffer.append(", medico_cpf=");
        buffer.append(retornarValorStringBD(e.getMedico().getCpf()));
        buffer.append(", paciente_cpf=");
        buffer.append(retornarValorStringBD(e.getPaciente().getCpf()));

        return buffer.toString();
    }

    protected String retornarValoresBD(Consulta e) {
        return
                retornarValorStringBD(e.getAtendente().getCpf())
                        + ", "
                        + retornarValorStringBD(e.getHorario())
                        + ", "
                        + retornarValorStringBD(e.getDia())
                        + ", "
                        + retornarValorStringBD(e.getMedico().getCpf())
                        + ", "
                        + retornarValorStringBD(e.getPaciente().getCpf());
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

    private Consulta buildConsulta(ResultSet rs) {
        Consulta consulta = new Consulta();
        try {
            consulta.setAtendente(new AtendenteDAO().search(rs.getString("atendente_cpf")));
            consulta.setHorario(rs.getString("horario"));
            consulta.setDia(rs.getString("dia"));
            consulta.setIdConsulta(Integer.parseInt(rs.getString("idconsulta")));
            consulta.setMedico(new MedicoDAO().search(rs.getString("medico_cpf")));
            consulta.setPaciente(new PacienteDAO().search(rs.getString("paciente_cpf")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }
}
