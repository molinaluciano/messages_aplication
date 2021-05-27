/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.messages_app;

import com.platzi.config.Conection;
import java.sql.Connection;

/**
 *
 * @author lmolina
 */
public class Main {
     public static void main(String[] args){
      Conection conexion = new Conection();
      
     try(Connection cnx = conexion.get_connection()){ }
     catch(Exception e)  {
        System.out.println(e);
    }}

}
