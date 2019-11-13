/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddp2;
import Estructuras.*;
import Vistas.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Micky
 */
public class EDDP2 {

    /**
     * @param args the command line arguments
     */
    
    public static Usuario actual = null;
    public static NodoMatriz matriz = null;
    public static TablaHash tabla = new TablaHash();
    
    public static void main(String[] args) {
        new Inicio();
        
    }
    
    
}
