/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Micky
 */
public class Pila {

    NodoPila cima;

    public Pila() {
        this.cima = null;
    }

    public NodoPila getCima() {
        return cima;
    }

    public void setCima(NodoPila cima) {
        this.cima = cima;
    }

    public void meter(NodoPila nuevo) {
        if (this.cima == null) {
            this.cima = nuevo;
        } else {
            nuevo.setAbajo(this.cima);
            this.cima = nuevo;
        }
    }

    public NodoPila sacar(NodoPila nuevo) {
        if (this.cima == null) {
            return null;
        } else {
            NodoPila retorno = this.cima;
            this.cima = retorno.getAbajo();
            return retorno;
        }
    }

    public boolean graficarBitacora() {
        FileWriter fichero;
        PrintWriter pw;
        try {
            fichero = new FileWriter("ReporteBitacora.txt");
            pw = new PrintWriter(fichero);

            pw.write("digraph grafico{\ngraph [pad=\"0.5\", nodesep=\"0.5\", ranksep=\"2\"];\nnode [shape=plain]\nrankdir=LR;\n");
            pw.append("Foo [label=<\n<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">\n<tr><td><i><b>No.</b></i></td><td><i><b>Usuario</b></i></td><td><i><b>Operacion</b></i></td><td><i><b>Time</b></i></td></tr>\n");

            NodoPila temp = this.cima;
            int i=0;
            
            while (temp != null) {

                pw.append("<tr><td><b>" + i + ".</b></td><td>" + temp.getUsuario()+ " </td><td>" + temp.getOperacion() + " </td><td>" + temp.getTime() + "</td></tr>\n");
                temp = temp.getAbajo();
                i++;
                
            }

            pw.append("</table>>];\n}");

            pw.close();

            try {
                Runtime.getRuntime().exec("dot -Tjpg ReporteBitacora.txt -o ReporteBitacora.jpg");
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

}
