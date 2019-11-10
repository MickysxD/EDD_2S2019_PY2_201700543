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
    private int uso;

    public TablaHash() {
        this.size = 7;
        this.uso = 0;
        this.usuarios = new Usuario[this.size];
    }

    public boolean agregar(String nombre, String pass) {
        Usuario nuevo = new Usuario(nombre, pass);

        int pos = division(nombre);
        boolean ag = false;
        int intento = 0;

        if (usuarios[pos] != null) {
            usuarios[pos] = nuevo;
            this.uso++;
            ag = true;
        } else {
            while (intento < 2 && ag == false) {
                int n = (pos ^ intento) / this.size;
                if (usuarios[n] != null) {
                    usuarios[n] = nuevo;
                    ag = true;
                    this.uso++;
                }
                intento += 1;
            }

            if (!ag) {
                for (int i = 0; i < usuarios.length; i++) {
                    if (usuarios[i] == null) {
                        usuarios[i] = nuevo;
                        ag = true;
                        this.uso++;
                    }
                }
            }
        }

        lleno();

        return ag;
    }

    public void lleno() {
        if (this.uso >= this.size * .75) {
            Usuario[] anterior = this.usuarios;
            this.usuarios = new Usuario[primo()];
            
            for (int i = 0; i < anterior.length; i++) {
                if (anterior[i] != null) {
                    agregar(anterior[i].getNombre(), anterior[i].getPass());
                }
            }
        }

    }

    public int division(String nombre) {
        int suma = 0;
        for (int i = 0; i < nombre.length(); i++) {
            suma += (int) nombre.charAt(i);
        }

        return suma % this.size;
    }

    public int primo() {
        int i, j;
        boolean esPrimo;
        int rInicial = this.size+1;//Rango inicial, este debe ser mayor de 1.
        int rFinal = 1000;//Rango final.
        for (i = rInicial; i <= rFinal; i++) {
            //recorro ciclo tantas veces como necesite(<= es para incluir el valor de rFinal).
            esPrimo = true;// i es primo hasta que se demuestre lo contrario, jejejejeje.
            for (j = 2; j < i; j++) {
                //no coloque j = 1 porque ya sabemos que todo numero es divisible por 1.
                /*j < i es para no incluir el numero a evaluar, pues todo numero es divisible
       por si mismo.*/
                if (i % j == 0) {//Si además del 1 y el mismo hay otro divisor, ya no es primo.
                    //% devuelve el residuo de i/j
                    esPrimo = false;//se demostró que i no es primo.
                }
            }
            if (esPrimo) {//Si es primo lo imprimo.
                break;
            }
        }
        this.size = i;
        return i;
    }

    public String SHA256(String password) {
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
