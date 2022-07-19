package com.example.softclinic.data;

import com.example.softclinic.data.connection.ConFactory;
import com.example.softclinic.model.Administrador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {
    private Connection con;
    private Statement comando;

    public Administrador search(String cpf){
        Administrador administrador = new Administrador();
        try{
            conectar();
            String sql ="SELECT * FROM administrador WHERE cpf =" + this.retornaValorStringBD(cpf);
            System.out.println("%"+sql+"%");
            ResultSet rs = comando.executeQuery(sql);
            if (rs.next()){
                administrador = this.buildAdministrador(rs);
                System.out.println(administrador.getNome());
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return administrador;

    }
    public List<Administrador> search(){
        try{
            conectar();
            String sql ="SELECT * FROM administrador";
            ResultSet rs = comando.executeQuery(sql);
            List<Administrador> adm = new ArrayList<Administrador>();
            while (rs.next()){
                Administrador e = this.buildAdministrador(rs);
                adm.add(e);
            }
            fechar();
            return adm;
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public void remove(Administrador administrador){
        try{
            conectar();
            String sql = "DELETE FROM administrador WHERE cpf="+ this.retornaValorStringBD(administrador.getCpf());
            comando.executeUpdate(sql);
            fechar();
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void insert(Administrador administrador){
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO administrador (");
            buffer.append(this.retornarCamposBD());
            buffer.append(") VALUES (");
            buffer.append(retornarValoresBD(administrador));
            buffer.append(")");
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Administrador administrador) {

        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE administrador SET ");
            buffer.append(returnFieldValuesBD(administrador));
            buffer.append(" WHERE CPF=");
            buffer.append(this.retornarValorStringBD(administrador.getCpf()));
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected String returnFieldValuesBD(Administrador e) {
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

    private String retornarValoresBD(Administrador e) {
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
    private Administrador buildAdministrador(ResultSet rs) {
        Administrador administrador = new Administrador();
        try{
            administrador.setCpf(rs.getString("cpf"));
            administrador.setNome(rs.getString("nome"));
            administrador.setSobrenome(rs.getString("sobrenome"));
            administrador.setData_nascimento(rs.getDate("data_nascimento").toString());
            administrador.setSexo(rs.getString("sexo"));
            administrador.setTelefone(rs.getString("telefone"));
            administrador.setNumeroCTPS(rs.getInt("numeroctps"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return administrador;
    }

}