/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lmolina
 */
public class Conection {
       public Connection get_connection(){
        Connection conection = null;
        try
        {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
//            if(conection != null){
//                System.out.println("CONECTION SUCCES");
//            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return conection;
    }

}
