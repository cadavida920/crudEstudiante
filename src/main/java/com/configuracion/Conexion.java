package com.configuracion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.Class.forName;

public class Conexion {
    // Creamos los metodos para crear coneccion
     String host = "localhost";
     String port = "3306";
     String database = "Estudiantes";
     String url = "jdbc:mysql://".concat(host).concat(":").concat(port).concat("/").concat(database);
     String username = "root";
     String password = "12345678";
     String classname = "com.mysql.cj.jdbc.Driver";

    public Connection getConexion() throws SQLException {

        String className = "com.mysql.cj.jdbc.Driver";
        try {
            forName(classname);
            return DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException exception) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, exception);
        }  return null;

    }
}

