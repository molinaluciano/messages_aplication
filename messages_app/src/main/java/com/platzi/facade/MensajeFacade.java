/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.facade;

import com.platzi.model.Mensaje;

/**
 *
 * @author lmolina
 */
public interface MensajeFacade {
    public void  crearMensajeDB(Mensaje mensaje);
    public void  leerMensajesDB();
    public void  borrarMensajeDB(int id_mensaje);
    public void  actualizarMensajeDB(Mensaje mensaje);

}
