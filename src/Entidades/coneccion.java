/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omarc
 */
public class coneccion {
    final String base_datos = "envio_correos";
    final String user = "root";
    String clave = "";
    String url ="jdbc:mysql://localhost:3306/" + base_datos;
    Connection conexion;
    
    public Connection getConnection() {
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conexion = (Connection)DriverManager.getConnection(url,user,clave);
            } catch (SQLException ex) {
                Logger.getLogger(coneccion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }  catch (ClassNotFoundException ex) {
        Logger.getLogger(coneccion.class.getName()).log(Level.SEVERE, null, ex);
}
        return conexion;
    }
    
}

