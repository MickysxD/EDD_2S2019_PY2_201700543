/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddp2;
import Estructuras.*;
import Vistas.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    public static Matriz matriz = null;
    public static TablaHash tabla = new TablaHash();
    public static NodoMatriz padre = null;
    public static NodoMatriz carpetaC = null;
    public static NodoAVL archivoM = null;
    public static NodoAVL archivos[] = null;
    public static String imagen = "";
    public static Pila bitacora = new Pila();
    
    
    public static void main(String[] args) {
        new Inicio();
        
    }
    
    public static String SHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
    
}
