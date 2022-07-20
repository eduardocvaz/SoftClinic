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

public class MedicoDAO {
    private Connection con;
    private Statement comando;

    public Medico search(String cpf) {
        Medico medico = new Medico();
        try{
            conectar();
            String sql = "SELECT * FROM MEDICO WHERE cpf = " + this.retornarValorStringBD(cpf);
            System.out.println("%"+sql+"%");
            ResultSet rs = comando.executeQuery(sql);
            if (rs.next()){
                medico = this.buildMedico(rs);
                System.out.println(medico.getNome());
            }
            fechar();
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return medico;
    }

    public List<Medico> search() {
        try {
            conectar();
            String sql = "SELECT * FROM medico";
            ResultSet rs = comando.executeQuery(sql);
            List<Medico> meds = new ArrayList<>();
            while (rs.next()){
                Medico e = this.buildMedico(rs);
                meds.add(e);
            }
            fechar();
            return meds;
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public void remove(Medico medico) {

        try {
            conectar();
            String sql ="DELETE FROM medico WHERE cpf=" + this.retornarValorStringBD(medico.getCpf());
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void remove(String cpf) {

        try {
            conectar();
            String sql ="DELETE FROM medico WHERE cpf=" + this.retornarValorStringBD(cpf);
            System.out.println("%"+sql+"%");
            comando.executeUpdate(sql);
            fechar();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(Medico medico) {
        try {

            conectar();

            StringBuffer buffer = new StringBuffer();
            buffer.append("INSERT INTO MEDICO (");
            buffer.append(this.retornarCamposBD());
            buffer.append(") VALUES (");
            buffer.append(retornarValoresBD(medico));
            buffer.append(")");
            String sql = buffer.toString();

            comando.executeUpdate(sql);
            fechar();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Medico medico) {

        try {
            conectar();
            StringBuffer buffer = new StringBuffer();
            buffer.append("UPDATE medico SET ");
            buffer.append(returnFieldValuesBD(medico));
            buffer.append(" WHERE CPF=");
            buffer.append(this.retornarValorStringBD(medico.getCpf()));
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
        return "cpf, nome, sobrenome, data_nascimento, telefone, sexo, cr, especialidade, numeroctps";
    }

    protected String returnFieldValuesBD(Medico e) {

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
        buffer.append(", cr=");
        buffer.append(retornarValorStringBD(e.getCr()));
        buffer.append(", especialidade=");
        buffer.append(retornarValorStringBD(e.getEspecialidade()));
        buffer.append(", numeroctps=");
        buffer.append(e.getNumeroCTPS());

        return buffer.toString();
    }

    protected String retornarValoresBD(Medico e) {
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
                        + retornarValorStringBD(e.getCr())
                        + ", "
                        + retornarValorStringBD(e.getEspecialidade())
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
    //"cpf, nome, sobrenome, data_nascimento, telefone, sexo, cr, especialidade, numeroctps"
    private Medico buildMedico(ResultSet rs) {
        Medico medico = new Medico();
        try {
            medico.setCpf(rs.getString("cpf"));
            medico.setNome(rs.getString("nome"));
            medico.setSobrenome(rs.getString("sobrenome"));
            medico.setData_nascimento(rs.getDate("data_nascimento").toString());
            medico.setTelefone(rs.getString("telefone"));
            medico.setSexo(rs.getString("sexo"));
            medico.setCr(rs.getString("cr"));
            medico.setEspecialidade(rs.getString("especialidade"));
            medico.setNumeroCTPS(rs.getInt("numeroctps"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }

}

