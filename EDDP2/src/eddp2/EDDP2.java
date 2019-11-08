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
    
    public static AVL av = new AVL();
    
    public static void main(String[] args) {
        
        av.agregar(new NodoAVL("Jeje"));
        new Inicio();
        
    }
    
    
    
}
