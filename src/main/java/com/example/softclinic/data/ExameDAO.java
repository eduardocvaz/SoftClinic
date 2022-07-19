package com.example.softclinic.data;

import com.example.softclinic.data.connection.ConFactory;
import com.example.softclinic.model.Exame;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExameDAO {
    private Connection con;
    private Statement comando;

    public Exame search(int idexame) {
        Exame exame = new Exame();
        try{
            conectar();
            String sql = "SELECT * FROM Exame WHERE idexame = " + idexame;
            System.out.println("%"+sql+"%");
            ResultSet rs = comando.executeQuery(sql);
            if (rs.next()){
                exame = this.buildExame(rs);
                System.out.println(exame.getIdExame());
            }
            fechar();
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return exame;
    }

    public List<Exame> search() {
        try {
            conectar();
            String sql = "SELECT * FROM Exame";
            ResultSet rs = comando.executeQuery(sql);
            List<Exame> exames = new ArrayList<>();
            while (rs.next()){
                Exame e = this.buildExame(rs);
                exames.add(e);
            }
            fechar();
            return exames;
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public void remove(Exame exame) {

        try {
            conectar();
            String sql ="DELETE FROM Exame WHERE idexame=" + exame.getIdExame();
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void remove(int idexame) {

        try {
            conectar();
            String sql ="DELETE FROM Exame WHERE idexame=" + idexame;
            System.out.println("%"+sql+"%");
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(Exame exame) {
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO Exame (");
            buffer.append(this.retornarCamposBD());
            buffer.append(") VALUES (");
            buffer.append(retornarValoresBD(exame));
            buffer.append(")");
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Exame exame) {

        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE exame SET ");
            buffer.append(returnFieldValuesBD(exame));
            buffer.append(" WHERE idexame=");
            buffer.append(exame.getIdExame());
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
        return "resultado, tipo, sigiloso";
    }

    protected String returnFieldValuesBD(Exame e) {

        StringBuffer buffer = new StringBuffer();
        buffer.append(", resultado=");
        buffer.append(retornarValorStringBD(e.getResultado()));
        buffer.append(", tipo=");
        buffer.append(retornarValorStringBD(e.getTipo()));
        buffer.append(", sigiloso=");
        buffer.append(e.getSigilo());

        return buffer.toString();
    }

    protected String retornarValoresBD(Exame e) {
        return
                retornarValorStringBD(e.getResultado())
                        + ", "
                        + retornarValorStringBD(e.getTipo())
                        + ", "
                        + e.getSigilo();
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

    //"idexame, resultado, tipo, sigiloso"
    private Exame buildExame(ResultSet rs) {
        Exame exams = new Exame();
        try {
            exams.setIdExame(Integer.parseInt(rs.getString("idexame")));
            exams.setResultado(rs.getString("resultado"));
            exams.setTipo(rs.getString("tipo"));
            exams.setSigilo(rs.getBoolean("sigiloso"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }
}
