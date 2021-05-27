/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.messages_app;

import com.platzi.config.Conection;
import com.platzi.service.MensajeService;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author lmolina
 */
public class Main {
     public static void main(String[] args){
         
       Conection conexion = new Conection();
       Scanner sc = new Scanner(System.in);
       int opcion = 0;
       do{
           System.out.println("------------------");
           System.out.println("Aplicacion de mensjes");
           System.out.println("1) crear mensaje");
           System.out.println("2) listar mensajes");
           System.out.println("3) editar mensaje");
           System.out.println("4) eliminar mensaje");
           System.out.println("5) salir");
           
           opcion = sc.nextInt();
           switch(opcion){
               case 1:
                   MensajeService.crearMensaje();
                   break;
               case 2:
                   MensajeService.listarMensaje();
                   break;
               case 3:
                   MensajeService.actualizarMensaje();
                   break;
               case 4:
                   MensajeService.borrarMensaje();
                   break;
               default:
                   break;
           }
       }while(opcion != 5);
               
//       try(Connection cnx = conexion.get_connection()){ }
//       catch(Exception e)  {
//          System.out.println(e);
//        }
    }

}
