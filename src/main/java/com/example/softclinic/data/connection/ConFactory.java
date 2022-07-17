package com.example.softclinic.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {
    public static final boolean MYSQL = false;
    public static final boolean POSTGRES = true;
    private static final String MySQLDriver = "com.mysql.cj.jdbc.Driver";
    private static final String PostgreSQLDriver = "org.postgresql.Driver";

    private static ConFactory instance;

    private static Connection con;

    public ConFactory() throws ClassNotFoundException {
        String url;
        String user;
        String password;
        if(MYSQL) {
            Class.forName(MySQLDriver);
        } else if (POSTGRES) {
            Class.forName(PostgreSQLDriver);
            url="jdbc:postgresql://localhost:5432/SoftClinic";
            user = "postgres";
            password= "root";
        }
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ConFactory getInstance() throws ClassNotFoundException {
        if(instance == null) {
            instance = new ConFactory();
        }
        return instance;
    }
    public Connection conexao() throws ClassNotFoundException, SQLException {
        return con;
    }


}
