package com.example.softclinic.data;

import com.example.softclinic.data.connection.ConFactory;
import com.example.softclinic.model.Paciente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private Connection con;
    private Statement comando;

    public Paciente search(String cpf){
        Paciente paciente = new Paciente();
        try{
            conectar();
            String sql ="SELECT * FROM PACIENTE WHERE cpf =" + this.retornaValorStringBD(cpf);
            System.out.println("%"+sql+"%");
            ResultSet rs = comando.executeQuery(sql);
            if (rs.next()){
                paciente = this.buildPaciente(rs);
                System.out.println(paciente.getNome());
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return paciente;

    }
    public List<Paciente> search(){
        try{
            conectar();
            String sql ="SELECT * FROM paciente";
            ResultSet rs = comando.executeQuery(sql);
            List<Paciente> pac = new ArrayList<Paciente>();
            while (rs.next()){
                Paciente e = this.buildPaciente(rs);
                pac.add(e);
            }
            fechar();
            return pac;
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public void remove(Paciente paciente){
        try{
            conectar();
            String sql = "DELETE FROM paciente WHERE cpf="+ this.retornaValorStringBD(paciente.getCpf());
            comando.executeUpdate(sql);
            fechar();
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void insert(Paciente paciente){
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO paciente (");
            buffer.append(this.retornarCamposBD());
            buffer.append(") VALUES (");
            buffer.append(retornarValoresBD(paciente));
            buffer.append(")");
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Paciente paciente) {

        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE medico SET ");
            buffer.append(returnFieldValuesBD(paciente));
            buffer.append(" WHERE CPF=");
            buffer.append(this.retornarValorStringBD(paciente.getCpf()));
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected String returnFieldValuesBD(Paciente e) {
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
        return buffer.toString();
    }

    private String retornarValoresBD(Paciente e) {
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
                        + retornarValorStringBD(e.getSexo());
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
        return "cpf, nome, sobrenome, data_nascimento, telefone, sexo";
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
    private Paciente buildPaciente(ResultSet rs) {
        Paciente paciente = new Paciente();
        try{
            paciente.setCpf(rs.getString("cpf"));
            paciente.setNome(rs.getString("nome"));
            paciente.setSobrenome(rs.getString("sobrenome"));
            paciente.setData_nascimento(rs.getDate("data_nascimento").toString());
            paciente.setSexo(rs.getString("sexo"));
            paciente.setTelefone(rs.getString("telefone"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }

}