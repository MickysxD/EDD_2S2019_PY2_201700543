/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;

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

        if (usuarios[pos] == null) {
            usuarios[pos] = nuevo;
            this.uso++;
            ag = true;
        } else {
            while (intento < 2 && ag == false) {
                int n = (pos ^ intento) / this.size;
                if (usuarios[n] == null) {
                    usuarios[n] = nuevo;
                    ag = true;
                    this.uso++;
                    break;
                }
                intento += 1;
            }

            if (!ag) {
                for (int i = 0; i < usuarios.length; i++) {
                    if (usuarios[i] == null) {
                        usuarios[i] = nuevo;
                        ag = true;
                        this.uso++;
                        break;
                    }
                }
            }
        }

        lleno();

        return ag;
    }

    public void lleno() {
        if (this.uso >= (this.size * .75)) {
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
        int rInicial = this.size + 1;//Rango inicial, este debe ser mayor de 1.
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
        this.uso = 0;
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

    public boolean graficar() {
        FileWriter fichero;
        PrintWriter pw;
        try {
            fichero = new FileWriter("ReporteUsuarios.txt");
            pw = new PrintWriter(fichero);

            pw.write("digraph grafico{\ngraph [pad=\"0.5\", nodesep=\"0.5\", ranksep=\"2\"];\nnode [shape=plain]\nrankdir=LR;\n");
            pw.append("Foo [label=<\n<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">\n<tr><td><i><b>No.</b></i></td><td><i><b>Usuario</b></i></td></td><td><i><b>Pass</b></i></td></td><td><i><b>Time</b></i></td></tr>\n");
            int tam = uso;

            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i] != null && tam > 0) {
                    pw.append("<tr><td><b>"+i+".</b></td><td>" + usuarios[i].getNombre() + "</td><td>" + usuarios[i].getPass() + "</td><td>" + usuarios[i].getTime() + "</td></tr>\n");
                    tam -= 1;
                }else{
                    pw.append("<tr><td><b>"+i+".</b></td><td></td></tr>\n");
                }
            }

            pw.append("</table>>];\n}");
            
            pw.close();
            
            try {
                Runtime.getRuntime().exec("dot -Tjpg ReporteUsuarios.txt -o ReporteUsuarios.jpg");
                //Runtime.getRuntime().exec("cmd /c start ReporteUsuarios.dot");
                //Runtime.getRuntime().exec("cmd /c start ReporteUsuarios.jpg");
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean usuario(String nombre){
        for (int i = 0; i < usuarios.length; i++) {
            if(usuarios[i] != null && usuarios[i].getNombre().equals(nombre)){
                return false;
            }
        }
        return true;
    }
    
    public boolean pass(String pass){
        if(pass.length() < 8){
            return false;
        }else{
            return true;
        }
    }
    
    public Usuario validarUsuario(String nombre, String pass){
        for (int i = 0; i < usuarios.length; i++) {
            if(usuarios[i] != null && usuarios[i].getNombre().equals(nombre) && usuarios[i].getPass().equals(SHA256(pass))){
                return usuarios[i];
            }
        }
        return null;
    }

    public Usuario buscar(String nombre){
        for (int i = 0; i < usuarios.length; i++) {
            if(usuarios[i] != null && usuarios[i].getNombre().equals(nombre)){
                return usuarios[i];
            }
        }
        return null;
    }
    
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getUso() {
        return uso;
    }

    public void setUso(int uso) {
        this.uso = uso;
    }
    
    
}
