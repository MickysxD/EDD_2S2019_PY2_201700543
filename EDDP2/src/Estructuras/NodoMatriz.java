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

    public NodoMatriz() {
        this.archivos = new AVL();
    }
    
    public NodoMatriz(String nombre, String ruta, NodoMatriz padre, NodoMatriz mismo) {
        this.archivos = new AVL();
        this.nombre = nombre;
        this.ruta = ruta;
        this.padre = padre;
        this.mismo = mismo;
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
    
    
    
}
