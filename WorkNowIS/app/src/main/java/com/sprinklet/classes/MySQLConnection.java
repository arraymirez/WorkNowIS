package com.sprinklet.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.ClassNotFoundException;

public class MySQLConnection
{
    private Connection conexion = null;
    private Statement comando = null;
    public ResultSet registro = null;

    public MySQLConnection() throws SQLException
    {
        if (conexion == null)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://192.168.0.8/evento", "root", "");
            }
            catch (SQLException ex)
            {
                throw new SQLException(ex);
            }
            catch (ClassNotFoundException ex)
            {
                throw new ClassCastException(ex.getMessage());
            }
        }
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public void exec(String query) throws SQLException {
        comando = conexion.createStatement();
        registro = comando.executeQuery(query);
    }
}