/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.service;


import com.platzi.facade.MensajeFacadeImpl;
import com.platzi.model.Mensaje;
import java.util.Scanner;

/**
 *
 * @author lmolina
 */
public class MensajeService {
    private static MensajeFacadeImpl mensajeFacade = new MensajeFacadeImpl();
    public static Scanner sc = new Scanner(System.in);
    public static void  crearMensaje(){
        
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();
        
        System.out.println("Escribe la fecha");
        String fecha = sc.nextLine();
        
        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        registro.setFecha_mensaje(fecha);
      
//        MensajeFacadeImpl mensajeFacade = new MensajeFacadeImpl();
        mensajeFacade.crearMensajeDB(registro);
        
    }
    public static void  listarMensaje(){
        mensajeFacade.leerMensajesDB();
    }
    public static void  borrarMensaje(){
        System.out.println("INSERTAR ID");
        int idToDelete = sc.nextInt();
        mensajeFacade.borrarMensajeDB(idToDelete);
    }
    public static void  actualizarMensaje(){
        System.out.println("NUEVO MENSAJE");
        String nuevoMensaje = sc.nextLine();
        System.out.println("ID DE MENSAJE");
        int id = sc.nextInt();
        Mensaje mensaje = new Mensaje();
        mensaje.setMensaje(nuevoMensaje);
        mensaje.setId_mensaje(id);
        mensajeFacade.actualizarMensajeDB(mensaje);
    }
}
