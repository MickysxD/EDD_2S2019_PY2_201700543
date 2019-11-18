/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Micky
 */
public class NodoPila {
    private String time;
    private String operacion;
    private String usuario;
    private NodoPila abajo;

    public NodoPila(String operacion, String usuario) {
        this.time = new Timestamp(new Date().getTime()).toString();
        this.operacion = operacion;
        this.usuario = usuario;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public NodoPila getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPila abajo) {
        this.abajo = abajo;
    }

}
