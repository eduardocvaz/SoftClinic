package com.example.softclinic.data;

import com.example.softclinic.data.connection.ConFactory;
import com.example.softclinic.model.Medico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicoDAO {
    private Connection con;
    private Statement comando;

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

    private void conectar() throws ClassNotFoundException, SQLException {
        con = ConFactory.conexao();
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
        buffer.append(retornarValorStringBD(e.getName()));
        buffer.append(", sobrenome=");
        buffer.append(retornarValorStringBD(e.getSobrenome()));
        buffer.append(", data_nascimento=");
        buffer.append(retornarValorStringBD(e.getSsn()));
        buffer.append(", telefone=");
        buffer.append(retornarValorStringBD(e.getBdate().toString()));
        buffer.append(", sexo=");
        buffer.append(retornarValorStringBD(e.getAddress()));
        buffer.append(", cr=");
        buffer.append(retornarValorStringBD(e.getSex()));
        buffer.append(", especialidade=");
        buffer.append(e.getSalary());
        buffer.append(", numeroctps=");
        buffer.append(e.getDno());

        return buffer.toString();
    }

    protected String retornarValoresBD(Medico e) {
        return
                retornarValorStringBD(e.getName())
                        + ", "
                        + retornarValorStringBD(e.getMinit())
                        + ", "
                        + retornarValorStringBD(e.getLname())
                        + ", "
                        + retornarValorStringBD(e.getSsn())
                        + ", "
                        + retornarValorStringBD(e.getBdate().toString())
                        + ", "
                        + retornarValorStringBD(e.getAddress())
                        + ", "
                        + retornarValorStringBD(e.getSex())
                        + ", "
                        + e.getSalary()
                        + ", "
                        + retornarValorStringBD(e.getSuperssn())
                        + ", "
                        + e.getDno();
    }

    private String retornarValorStringBD(String valor) {
        String retorno = "";
        if (valor == null) {
            retorno = "null";
        } else {
            retorno = "'" + valor + "'";
        }
        return retorno;
    }

    private Medico buildMedico(ResultSet rs) {
        Medico employee = new Medico();
        try {
            employee.setFname(rs.getString("fname"));
            employee.setMinit(rs.getString("minit"));
            employee.setLname(rs.getString("lname"));
            employee.setSsn(rs.getString("ssn"));
            employee.setBdate(rs.getDate("bdate"));
            employee.setAddress(rs.getString("address"));
            employee.setSex(rs.getString("sex"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setSuperssn(rs.getString("super_ssn"));
            employee.setDno(rs.getInt("dno"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
