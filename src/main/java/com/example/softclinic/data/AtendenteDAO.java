package com.example.softclinic.data;

import com.example.softclinic.data.connection.ConFactory;
import com.example.softclinic.model.Atendente;
import com.example.softclinic.model.Medico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO {
    private Connection con;
    private Statement comando;

    public Atendente search(String cpf){
        Atendente atendente = new Atendente();
        try{
            conectar();
            String sql ="SELECT * FROM ATENDENTE WHERE cpf =" + this.retornaValorStringBD(cpf);
            System.out.println("%"+sql+"%");
            ResultSet rs = comando.executeQuery(sql);
            if (rs.next()){
                atendente = this.buildAtendente(rs);
                System.out.println(atendente.getNome());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return atendente;

    }
    public List<Atendente> search(){
        try{
            conectar();
            String sql ="SELECT * FROM atendente";
            ResultSet rs = comando.executeQuery(sql);
            List<Atendente> atend = new ArrayList<Atendente>();
            while (rs.next()){
                Atendente e = this.buildAtendente(rs);
                atend.add(e);
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public void remove(Atendente atendente){
        try{
            conectar();
            String sql = "DELETE FROM atendente WHERE cpf="+ this.retornaValorStringBD(atendente.getCpf());
            comando.executeUpdate(sql);
            fechar();
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void insert(Atendente atendente){
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO ATENDENT (");
            buffer.append(this.retornarCamposBD());
            buffer.append(") VALUES (");
            buffer.append(retornarValoresBD(atendente));
            buffer.append(")");
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Atendente atendente) {

        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE medico SET ");
            buffer.append(returnFieldValuesBD(atendente));
            buffer.append(" WHERE CPF=");
            buffer.append(this.retornarValorStringBD(atendente.getCpf()));
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected String returnFieldValuesBD(Atendente e) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("cpf=");
        buffer.append(retornarValorStringBD(e.getCpf()));
        buffer.append(", nome=");
        buffer.append(retornarValorStringBD(e.getNome()));
        buffer.append(", sobrenome=");
        buffer.append(retornarValorStringBD(e.getSobrenome()));
        buffer.append(", data_nascimento=");
        buffer.append(retornarValorStringBD(e.getData_nascimento()));
        buffer.append(", telefone=");
        buffer.append(retornarValorStringBD(e.getTelefone()));
        buffer.append(", sexo=");
        buffer.append(retornarValorStringBD(e.getSexo()));
        buffer.append(", numeroctps=");
        buffer.append(e.getNumeroCTPS());
        return buffer.toString();
    }

    private String retornarValoresBD(Atendente e) {
        return
                retornarValorStringBD(e.getCpf())
                        + ", "
                        + retornarValorStringBD(e.getNome())
                        + ", "
                        + retornarValorStringBD(e.getSobrenome())
                        + ", "
                        + retornarValorStringBD(e.getData_nascimento())
                        + ", "
                        + retornarValorStringBD(e.getTelefone())
                        + ", "
                        + retornarValorStringBD(e.getSexo())
                        + ", "
                        + e.getNumeroCTPS();
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
    private String retornarCamposBD() {
        return "cpf, nome, sobrenome, data_nascimento, telefone, sexo, numeroctps";
    }

    private void fechar() {
        try{
            comando.close();
            con.close();
            System.out.println("Conexão Fechada");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void conectar() throws ClassNotFoundException, SQLException {
        con = new ConFactory().conexao();
        comando = con.createStatement();
        System.out.println("Conectado!");
    }
    private String retornaValorStringBD(String valor){
        String retorno;
        if(valor == null){
            retorno = "null";
        }else{
            retorno = "'" + valor + "'";
        }
        return retorno;
    }
    private Atendente buildAtendente(ResultSet rs) {
        Atendente atendente = new Atendente();
        try{
            atendente.setCpf(rs.getString("cpf"));
            atendente.setNome(rs.getString("nome"));
            atendente.setSobrenome(rs.getString("sobrenome"));
            atendente.setData_nascimento(rs.getDate("data_nascimento").toString());
            atendente.setSexo(rs.getString("sexo"));
            atendente.getNumeroCTPS(rs.getInt("numeroctps"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return atendente;
    }

}