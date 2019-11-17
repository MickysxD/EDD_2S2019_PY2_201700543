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
public class NodoMatriz {
    private NodoMatriz siguiente;
    private NodoMatriz anterior;
    private NodoMatriz abajo;
    private NodoMatriz arriba;
    private AVL archivos;
    private String nombre;
    private String ruta;
    private NodoMatriz padre;
    private NodoMatriz mismo;
    private String time;
    private int carpetas;

    public NodoMatriz() {
        this.archivos = new AVL();
    }
    
    public NodoMatriz(String nombre, String ruta, NodoMatriz padre, NodoMatriz mismo) {
        this.archivos = new AVL();
        this.nombre = nombre;
        this.ruta = ruta;
        this.padre = padre;
        this.mismo = mismo;
        this.carpetas = 0;
        this.time = new Timestamp(new Date().getTime()).toString();
    }
    
    public NodoMatriz getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMatriz siguiente) {
        this.siguiente = siguiente;
    }

    public NodoMatriz getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoMatriz anterior) {
        this.anterior = anterior;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    public AVL getArchivos() {
        return archivos;
    }

    public void setArchivos(AVL archivos) {
        this.archivos = archivos;
    }

    public NodoMatriz getPadre() {
        return padre;
    }

    public void setPadre(NodoMatriz padre) {
        this.padre = padre;
    }

    public NodoMatriz getMismo() {
        return mismo;
    }

    public void setMismo(NodoMatriz mismo) {
        this.mismo = mismo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCarpetas() {
        return carpetas;
    }

    public void setCarpetas(int carpetas) {
        this.carpetas = carpetas;
    }
    
    
    
}
