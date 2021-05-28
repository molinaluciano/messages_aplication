/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.facade;

import com.platzi.config.Conection;
import com.platzi.model.Mensaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lmolina
 */
public class MensajeFacadeImpl implements MensajeFacade {

    @Override
    public void crearMensajeDB(Mensaje mensaje) {
        Conection db_connect = new Conection();
       try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;

            try{
                String query = "INSERT INTO mensajes ( MENSAJE, AUTOR_MENSAJE, FECHA_MENSAJE) VALUES ( ?, ?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.setString(3, mensaje.getFecha_mensaje());
                System.out.println("---QUERY TO EXECUTE---");
                System.out.println(ps);
                ps.executeUpdate();
               
                System.out.println("QUERY EJECUTADA CORRECTAMENTE");
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
       }
       catch(Exception e)  {
          System.out.println(e);
        }
    }

    @Override
    public void leerMensajesDB() {
         Conection db_connect = new Conection();
       try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                String query = "SELECT * FROM mensajes";
                ps = conexion.prepareStatement(query);
                
                System.out.println("---QUERY TO EXECUTE---");
                System.out.println(ps);
                rs = ps.executeQuery();
               while(rs.next()){
                  System.out.println("id: " + rs.getInt("id_mensaje"));
                  System.out.println("mensaje: " + rs.getString("mensaje"));
               }
             
                System.out.println("QUERY EJECUTADA CORRECTAMENTE");
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
       }
       catch(Exception e)  {
          System.out.println(e);
        }
    }

    @Override
    public void borrarMensajeDB(int id_mensaje) {
        Conection db_connect = new Conection();
       try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;

            try{
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                
                System.out.println("---QUERY TO EXECUTE---");
                System.out.println(ps);
                ps.executeUpdate();
               
                System.out.println("QUERY EJECUTADA CORRECTAMENTE");
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
       }
       catch(Exception e)  {
          System.out.println(e);
        }
    }

    @Override
    public void actualizarMensajeDB(Mensaje mensaje) {
        Conection db_connect = new Conection();
        try(Connection conexion = db_connect.get_connection()){
             PreparedStatement ps = null;

             try{
                 String query = "UPDATE mensajes set mensaje = ? WHERE id_mensaje = ?";
                 ps = conexion.prepareStatement(query);
                 ps.setString(1, mensaje.getMensaje());
                 ps.setInt(2, mensaje.getId_mensaje());

                 System.out.println("---QUERY TO EXECUTE---");
                 System.out.println(ps);
                 ps.executeUpdate();

                 System.out.println("QUERY EJECUTADA CORRECTAMENTE");
             }
             catch(SQLException ex){
                 System.out.println(ex);
             }
        }
        catch(Exception e)  {
          System.out.println(e);
        }
    }
    
}
