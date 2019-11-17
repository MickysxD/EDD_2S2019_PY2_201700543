/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.*;

/**
 *
 * @author Micky
 */
public class Matriz {

    private NodoMatriz root;

    public Matriz() {
        this.root = new NodoMatriz("root", "root", null, null);
        this.root.setAbajo(new NodoMatriz("/", "/", null, null));
        this.root.setSiguiente(new NodoMatriz("/", "/", null, null));
    }

    public NodoMatriz buscarSub(String ruta) {
        NodoMatriz temp = this.root;
        while (temp != null) {
            if (temp.getRuta().equals(ruta)) {
                return temp;
            }
            temp = temp.getSiguiente();
        }
        return temp;
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

    public NodoMatriz agregarSub(NodoMatriz nuevo) {
        NodoMatriz temp = this.root;

        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }

        temp.setSiguiente(nuevo);
        nuevo.setAnterior(temp);

        return nuevo;
    }

    public NodoMatriz agregarPadre(NodoMatriz nuevo) {
        NodoMatriz temp = this.root;

        while (temp.getAbajo() != null) {
            temp = temp.getAbajo();
        }

        temp.setAbajo(nuevo);
        nuevo.setArriba(temp);

        return nuevo;
    }

    public NodoMatriz agregarPadreHijo(NodoMatriz padre, NodoMatriz hijo) {
        NodoMatriz temp = padre;
        NodoMatriz nuevo = hijo;
        boolean bandera = false;
        boolean entra = false;

        if (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
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

//        temp.setSiguiente(nuevo);
//        nuevo.setAnterior(temp);
        
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

    public NodoMatriz agregarSubHijo(NodoMatriz hijo, NodoMatriz sub) {
        NodoMatriz nuevo = hijo;
        NodoMatriz temp = sub;

        if (temp != null) {
            temp.setAbajo(nuevo);
            nuevo.setArriba(temp);
        } else {
            return null;
        }

        return nuevo;
    }

    public boolean agregarCarpeta(NodoMatriz padre, String nombre) {
        NodoMatriz nodoHijo = buscarHijo(padre, nombre);

        if (nodoHijo == null) {
            NodoMatriz nuevo;
            NodoMatriz sub;
            NodoMatriz pad;
            if (padre.getRuta().equals("/")) {
                sub = agregarSub(new NodoMatriz(nombre, padre.getRuta() + nombre, padre, null));
                pad = agregarPadre(new NodoMatriz(nombre, padre.getRuta() + nombre, padre, null));
                nuevo = new NodoMatriz(nombre, padre.getRuta() + nombre, padre, pad);
            } else {
                sub = agregarSub(new NodoMatriz(nombre, padre.getRuta() + "/" + nombre, padre, null));
                pad = agregarPadre(new NodoMatriz(nombre, padre.getRuta() + "/" + nombre, padre, null));
                nuevo = new NodoMatriz(nombre, padre.getRuta() + "/" + nombre, padre, pad);
            }
            NodoMatriz hijo = agregarPadreHijo(padre, nuevo);
            agregarSubHijo(hijo, sub);
            padre.setCarpetas(padre.getCarpetas()+1);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificarCarpeta(NodoMatriz padre, String nombre, String nuevo) {
        NodoMatriz existe = buscarHijo(padre, nuevo);

        if (existe == null) {
            NodoMatriz hijo = buscarHijo(padre, nombre);
            NodoMatriz sub;
            NodoMatriz pad;
            if (padre.getNombre().equals("/")) {
                sub = buscarSub("/" + nombre);
                pad = buscarPadre("/" + nombre);

                pad.setRuta("/" + nuevo);
                sub.setRuta("/" + nuevo);
                hijo.setRuta("/" + nuevo);
            } else {
                sub = buscarSub(padre.getRuta() + "/" + nombre);
                pad = buscarPadre(padre.getRuta() + "/" + nombre);
                
                pad.setRuta(padre.getRuta() + "/" + nuevo);
                sub.setRuta(padre.getRuta() + "/" + nuevo);
                hijo.setRuta(padre.getRuta() + "/" + nuevo);
            }
            
            hijo.setNombre(nuevo);
            pad.setNombre(nuevo);
            sub.setNombre(nuevo);
            
            if(pad.getSiguiente() != null){
                modificarRutas(pad);
            }
            
        } else {
            return false;
        }

        return true;
    }

    public void modificarRutas(NodoMatriz padre){
        NodoMatriz temp = padre.getSiguiente();
        while(temp != null){
            if(temp.getMismo().getSiguiente() != null){
                temp.getMismo().setRuta(padre.getRuta()+"/"+temp.getMismo().getNombre());
                modificarRutas(temp.getMismo());
            }else{
                temp.getMismo().setRuta(padre.getRuta()+"/"+temp.getMismo().getNombre());
            }
            temp = temp.getSiguiente();
        }
    
    }
    
    public boolean eliminarCarpeta(NodoMatriz padre, String nombre) {
        NodoMatriz sub;
        NodoMatriz mismo;
        NodoMatriz pad = padre;

        //Busca la carpeta sub-X y su mismo-Y
        if (padre.getNombre().equals("/")) {
            sub = buscarSub("/" + nombre);
            mismo = buscarPadre("/" + nombre);
            while (pad != null && !pad.getRuta().equals("/" + nombre)) {
                pad = pad.getSiguiente();
            }
        } else {
            sub = buscarSub(padre.getRuta() + "/" + nombre);
            mismo = buscarPadre(padre.getRuta() + "/" + nombre);
            while (pad != null && !pad.getRuta().equals(padre.getRuta() + "/" + nombre)) {
                pad = pad.getSiguiente();
            }
        }

        if (mismo.getSiguiente() != null) {
            NodoMatriz temp = mismo.getSiguiente();
            while (temp != null) {
                eliminarCarpeta(mismo, temp.getNombre());
                temp = temp.getSiguiente();
            }
        }

        if (sub != null) {
            if (sub.getSiguiente() != null) {
                sub.getSiguiente().setAnterior(sub.getAnterior());
                sub.getAnterior().setSiguiente(sub.getSiguiente());
            } else {
                sub.getAnterior().setSiguiente(null);
            }
        } else {
            return false;
        }

        if (mismo != null) {
            if (mismo.getAbajo() != null) {
                mismo.getAbajo().setArriba(mismo.getArriba());
                mismo.getArriba().setAbajo(mismo.getAbajo());
            } else {
                mismo.getArriba().setAbajo(null);
            }
        } else {
            return false;
        }

        if (pad != null) {
            if (pad.getSiguiente() != null) {
                pad.getSiguiente().setAnterior(pad.getAnterior());
                pad.getAnterior().setSiguiente(pad.getSiguiente());
            } else {
                pad.getAnterior().setSiguiente(null);
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean graficarMatriz() {
        FileWriter fichero;
        PrintWriter pw;
        try {
            fichero = new FileWriter("ReporteMatriz.txt");
            pw = new PrintWriter(fichero);

            pw.write("digraph grafico{\ngraph [nodesep=2];\nnode [shape=record]\nrankdir=TB;\n");
            NodoMatriz tempS = this.root.getSiguiente();
            NodoMatriz tempP = this.root.getAbajo();

            //Creacion de nodos
            while (tempS != null) {
                pw.append("\"" + tempS.getRuta() + "1\"[label=\"" + tempS.getNombre() + "\"];\n");
                tempS = tempS.getSiguiente();
            }

            while (tempP != null) {
                pw.append("\"" + tempP.getRuta() + "\"[label=\"" + tempP.getNombre() + "\"];\n");

                tempS = tempP.getSiguiente();

                while (tempS != null) {
                    if (tempS.getPadre().getNombre().equals("/")) {
                        pw.append("\"" + tempS.getRuta() + "2\"[label=\"" + tempS.getPadre().getNombre() + tempS.getNombre() + "\"];\n");
                    } else {
                        pw.append("\"" + tempS.getRuta() + "2\"[label=\"" + tempS.getPadre().getNombre() + "/" + tempS.getNombre() + "\"];\n");
                    }
                    tempS = tempS.getSiguiente();
                }

                tempP = tempP.getAbajo();
            }

            //Union de nodos
            tempS = this.root.getSiguiente();
            tempP = this.root.getAbajo();
            while (tempS != null) {
                if (tempS.getAbajo() != null) {
                    pw.append("\"" + tempS.getRuta() + "1\"->\"" + tempS.getAbajo().getRuta() + "2\";\n");
                }
                if (tempS.getSiguiente() != null) {
                    pw.append("\"" + tempS.getRuta() + "1\"->\"" + tempS.getSiguiente().getRuta() + "1\";\n");
                }
                tempS = tempS.getSiguiente();
            }

            while (tempP != null) {
                if (tempP.getSiguiente() != null) {
                    pw.append("\"" + tempP.getRuta() + "\"->\"" + tempP.getSiguiente().getRuta() + "2\";\n");
                }
                if (tempP.getAbajo() != null) {
                    pw.append("\"" + tempP.getRuta() + "\"->\"" + tempP.getAbajo().getRuta() + "\";\n");
                }

                tempS = tempP.getSiguiente();

                while (tempS != null) {
                    if (tempS.getSiguiente() != null) {
                        pw.append("\"" + tempS.getRuta() + "2\"->\"" + tempS.getSiguiente().getRuta() + "2\";\n");
                    }
                    tempS = tempS.getSiguiente();
                }

                tempP = tempP.getAbajo();
            }

            //Agrupacion de nodos
            tempS = this.root.getSiguiente();
            tempP = this.root.getAbajo();

            pw.append("\"Micky\"[label=\"\", shape=point];\n");
            pw.append("\"Micky\"->\"/1\";\n");
            pw.append("\"Micky\"->\"/\";\n");

            pw.append("{ rank=same; ");

            pw.append("\"Micky\" ");

            while (tempS != null) {
                pw.append("\"" + tempS.getRuta() + "1\" ");
                tempS = tempS.getSiguiente();
            }

            pw.append("}\n");

            while (tempP != null) {
                pw.append("{ rank=same; ");
                pw.append("\"" + tempP.getRuta() + "\" ");

                tempS = tempP.getSiguiente();

                while (tempS != null) {
                    pw.append("\"" + tempS.getRuta() + "2\" ");
                    tempS = tempS.getSiguiente();
                }

                pw.append("}\n");

                tempP = tempP.getAbajo();
            }

            pw.append("}");

            pw.close();

            try {
                Runtime.getRuntime().exec("dot -Tjpg ReporteMatriz.txt -o ReporteMatriz.jpg");
                //Runtime.getRuntime().exec("cmd /c start ReporteUsuarios.dot");
                //Runtime.getRuntime().exec("cmd /c start ReporteUsuarios.jpg");
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
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
