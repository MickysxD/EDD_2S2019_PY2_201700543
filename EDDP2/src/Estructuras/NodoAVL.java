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
public class NodoAVL {
    private NodoAVL izq;
    private NodoAVL der;
    private String nombre;
    private String contenido;
    private String time;
    private String propietario;
    private int altura;
    private int factor;

    public NodoAVL(String nombre, String contenido, String propietario) {
        this.izq = null;
        this.der = null;
        this.nombre = nombre;
        this.contenido = contenido;
        this.propietario = propietario;
        this.altura = 1;
        this.factor = 0;
        this.time = new Timestamp(new Date().getTime()).toString();
    }

    public NodoAVL getIzq() {
        return izq;
    }

    public void setIzq(NodoAVL izq) {
        this.izq = izq;
    }

    public NodoAVL getDer() {
        return der;
    }

    public void setDer(NodoAVL der) {
        this.der = der;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    
}
