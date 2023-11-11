/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omarc
 */
public class Consulta_Usuario extends coneccion{
     public boolean Guardar(Usuario usuarios){
        PreparedStatement ps = null;
        Connection con = (Connection)getConnection();
        String query = "INSERT INTO usuarios(nombre_usuario, apellido_usuario, dni_usuario, correo_usuario, password_usuario)"
                + " VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getApellido());
            ps.setString(3, usuarios.getDni());
            ps.setString(4, usuarios.getCorreo());
            ps.setString(5, usuarios.getPassword());
            ps.execute();
                   return true;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
    }
    
    public boolean Login(Usuario usuarios){
       PreparedStatement ps= null;
        Connection con=(Connection)getConnection();
        ResultSet res = null;
        String query="SELECT * FROM usuarios WHERE nombre_usuario=? and password_usuario=?";
        try {
            ps=con.prepareStatement(query);
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getPassword());
            res=ps.executeQuery();
            if(res.next()){
                usuarios.setId(res.getInt("id_usuario"));
                usuarios.setNombre(res.getString("nombre_usuario"));
                usuarios.setCorreo(res.getString("correo_usuario"));
                usuarios.setPassword(res.getString("password_usuario"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    
} 

   public boolean Recuperacion(Usuario usuarios){
        PreparedStatement ps= null;
        Connection con=(Connection)getConnection();
        ResultSet res = null;
        String query="SELECT * FROM usuarios WHERE nombre_usuario=?";
        try {
            ps=con.prepareStatement(query);
            ps.setString(1, usuarios.getNombre());
            res=ps.executeQuery();
            if(res.next()){
                usuarios.setId(res.getInt("id_usuario"));
                usuarios.setNombre(res.getString("nombre_usuario"));
                usuarios.setCorreo(res.getString("correo_usuario"));
                usuarios.setPassword(res.getString("password_usuario"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Consulta_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
}

