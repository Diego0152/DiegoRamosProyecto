package com.iesvdc.dam.acceso.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    
    public static Connection getConection(Properties props) {
        Connection conn=null;
        String cadenaConexion = 
            "jdbc:mysql:" + 
            props.getProperty("host")+ //host
            ":"+
            props.getProperty("port") // puerto
            +"/"+ 
            props.getProperty("database"); //base de datos
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(cadenaConexion, props);
        } catch (Exception e) {
            System.err.println("No se puede localizar el driver");
        }
        
        return conn;

    }
}
