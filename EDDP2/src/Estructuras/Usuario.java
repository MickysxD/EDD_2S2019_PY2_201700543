/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Micky
 */
public class Usuario {
    private String nombre;
    private String pass;
    private Matriz archivos;

    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        this.archivos = new Matriz();
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
    
    
}
