/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Micky
 */
public class Usuario {
    private String nombre;
    private String pass;
    private Matriz archivos;
    private String time;

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        this.archivos = new Matriz();
        this.time = new Timestamp(new Date().getTime()).toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Matriz getArchivos() {
        return archivos;
    }

    public void setArchivos(Matriz archivos) {
        this.archivos = archivos;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
