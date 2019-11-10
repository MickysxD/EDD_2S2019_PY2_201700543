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
public class Matriz {

    private NodoMatriz root;

    public Matriz() {
        this.root = new NodoMatriz("/", "/", null);
    }

    public NodoMatriz buscarPadre(String ruta) {
        NodoMatriz temp = this.root;
        while (temp != null) {
            if (temp.getRuta().equals(ruta)) {
                return temp;
            }
            temp = temp.getAbajo();
        }
        return temp;
    }

    public NodoMatriz buscarHijo(NodoMatriz padre, String hijo) {
        NodoMatriz temp = padre.getSiguiente();
        while (temp != null) {
            if (temp.getNombre().equals(hijo)) {
                return temp;
            }
            temp = temp.getSiguiente();
        }
        return temp;
    }

    public NodoMatriz agregarPadre(NodoMatriz nuevo) {
        NodoMatriz temp = this.root;

        while (temp.getAbajo()!= null) {
            temp = temp.getAbajo();
        }

        temp.setAbajo(nuevo);
        nuevo.setArriba(temp);

        return nuevo;
    }

    public NodoMatriz agregarHijo(NodoMatriz padre, NodoMatriz hijo) {
        NodoMatriz temp = padre;
        NodoMatriz nuevo = hijo;
        boolean bandera = false;
        boolean entra = false;

        if (temp.getSiguiente() != null) {
            temp = padre.getSiguiente();
            while (entra) {
                int pos = temp.getNombre().compareTo(hijo.getNombre());

                if (pos == 0) {
                    return null;
                } else if (pos == 1) {
                    bandera = true;
                    entra = false;
                } else if (temp.getSiguiente() != null) {
                    temp = temp.getSiguiente();
                } else {
                    entra = false;
                }
            }
        }

        if (bandera) {
            nuevo.setSiguiente(temp);
            temp.getAnterior().setSiguiente(nuevo);
            nuevo.setAnterior(temp.getAnterior());
            temp.setAnterior(nuevo);
        } else {
            temp.setSiguiente(nuevo);
            nuevo.setAnterior(temp);
        }

        return nuevo;
    }
    
    public boolean agregarCarpeta(NodoMatriz padre, String nombre){
        NodoMatriz nodoPadre = padre;
        NodoMatriz nodoHijo = buscarHijo(padre, nombre);
        
        if(nodoHijo == null){
            NodoMatriz h = agregarHijo(padre, new NodoMatriz(nombre, padre.getRuta()+"/"+nombre, padre));
            agregarPadre(new NodoMatriz(h.getNombre(), h.getRuta(), h.getPadre()));
            return true;
        }else{
            return false;
        }
    }
    
    
    public NodoMatriz getRoot() {
        return root;
    }

    public void setRoot(NodoMatriz root) {
        this.root = root;
    }

}

