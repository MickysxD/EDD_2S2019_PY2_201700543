/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Micky
 */
public class TablaHash {
    private Usuario[] usuarios;
    private int size;

    public TablaHash() {
        this.size = 7;
        this.usuarios = new Usuario[this.size];
    }
    
    public void agregar(String nombre, String pass){
        Usuario nuevo = new Usuario(nombre, SHA256(pass));
        
        int pos = division(nombre);
        boolean ag = true;
        int intento = 0;
        
        if(usuarios[pos] != null){
            usuarios[pos] = nuevo;
        }else{
            while(intento < 2 && ag == true){
                int n = (pos^intento)/this.size;
                if (usuarios[n] != null) {
                    usuarios[n] = nuevo;
                    ag = false;
                }
                intento += 1;
            }
        
            if (ag) {
                for (int i = 0; i < usuarios.length; i++) {
                    if(usuarios[i] == null){
                        usuarios[i] = nuevo;
                    }
                }
            }
        }
        
        
    }
    
    public int division(String nombre){
        int suma = 0;
        for (int i=0; i<nombre.length(); i++){
            suma += (int) nombre.charAt(i);
        }
        
        return suma%this.size;
    }
    
    public static boolean esPrimo(int numero){
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }
    
    public String SHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	} 
	catch (NoSuchAlgorithmException e) {		
		e.printStackTrace();
		return null;
	}
	    
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
	    
	for(byte b : hash) {        
		sb.append(String.format("%02x", b));
	}
	    
	return sb.toString();
    }
    
}
