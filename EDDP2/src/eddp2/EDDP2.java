/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddp2;
import Estructuras.*;
import Vistas.*;

/**
 *
 * @author Micky
 */
public class EDDP2 {

    /**
     * @param args the command line arguments
     */
    
    public static AVL avl = new AVL();
    public static NodoMatriz matriz = null;
    
    public static void main(String[] args) {
        
        //avl.agregar(new NodoAVL("Jeje"));
        //new Inicio();
        System.out.println(division("ab"));
    }
    
    public static int division(String nombre){
        int suma = 0;
        for (int i=0; i<nombre.length(); i++){
            suma += (int) nombre.charAt(i);
        }
        
        return suma%7;
    }
    
}
