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
public class AVL {

    private NodoAVL root;
    int total;

    public AVL() {
        this.root = null;
        this.total = 0;
    }

    public int factor(NodoAVL root) {
        if (root == null) {
            return -1;
        } else {
            return root.getFactor();
        }
    }

    public int altura(NodoAVL root) {
        if (root == null) {
            return 0;
        } else {
            return root.getAltura();
        }
    }

    public void agregar(NodoAVL nuevo) {
        if (this.root == null) {
            this.root = nuevo;
            this.total += 1;
        } else {
            agregarAVL(this.root, nuevo);
            actualizar(this.root);
            this.total += 1;
        }
    }

    public void actualizar(NodoAVL root){
        
        if(root.getIzq() != null){
            actualizar(root.getIzq());
        }
        
        if(root.getDer() != null){
            actualizar(root.getDer());
        }
        
        if (root.getIzq() == null && root.getDer() != null) {
            root.setAltura(altura(root.getDer()) + 1);
        } else if (root.getIzq() != null && root.getDer() == null) {
            root.setAltura(altura(root.getIzq()) + 1);
        } else {
            root.setAltura(Math.max(altura(root.getIzq()), altura(root.getDer())) + 1);
        }
        
    }
    
    public NodoAVL rotacionI(NodoAVL root) {
        NodoAVL aux = root.getIzq();
        root.setIzq(aux.getDer());
        aux.setDer(root);
        root.setFactor(Math.max(factor(root.getIzq()), factor(root.getDer())));
        root.setAltura(Math.max(altura(root.getIzq()), altura(root.getDer())));
        aux.setFactor(Math.max(factor(aux.getIzq()), factor(aux.getDer())));
        aux.setAltura(Math.max(altura(aux.getIzq()), altura(aux.getDer())));
        return aux;
    }

    public NodoAVL rotacionD(NodoAVL root) {
        NodoAVL aux = root.getDer();
        root.setDer(aux.getIzq());
        aux.setIzq(root);
        root.setFactor(Math.max(factor(root.getIzq()), factor(root.getDer())));
        root.setAltura(Math.max(altura(root.getIzq()), altura(root.getDer())));
        aux.setFactor(Math.max(factor(aux.getIzq()), factor(aux.getDer())));
        aux.setAltura(Math.max(altura(aux.getIzq()), altura(aux.getDer())));
        return aux;
    }

    public NodoAVL rotacionDI(NodoAVL root) {
        root.setIzq(rotacionD(root.getIzq()));
        NodoAVL temp = rotacionI(root);
        return temp;
    }

    public NodoAVL rotacionID(NodoAVL root) {
        root.setDer(rotacionI(root.getDer()));
        NodoAVL temp = rotacionD(root);
        return temp;
    }

    public NodoAVL agregarAVL(NodoAVL root, NodoAVL nuevo) {
        NodoAVL padre = root;
        int max = root.getNombre().compareTo(nuevo.getNombre());
        if (max > 0) {
            if (root.getIzq() == null) {
                root.setIzq(nuevo);
            } else {
                root.setIzq(agregarAVL(root.getIzq(), nuevo));
                if (factor(root.getIzq()) - factor(root.getDer()) == 2) {
                    int maxx = root.getIzq().getNombre().compareTo(nuevo.getNombre());
                    if (maxx > 0) {
                        padre = rotacionI(root);
                    } else {
                        padre = rotacionDI(root);
                    }
                }
            }
        } else if (max < 0) {
            if (root.getDer() == null) {
                root.setDer(nuevo);
            } else {
                root.setDer(agregarAVL(root.getDer(), nuevo));
                if (factor(root.getDer()) - factor(root.getIzq()) == 2) {
                    int maxx = root.getDer().getNombre().compareTo(nuevo.getNombre());
                    if (maxx < 0) {
                        padre = rotacionD(root);
                    } else {
                        padre = rotacionID(root);
                    }
                }
            }
        } else {
            root.setNombre(nuevo.getNombre());
            root.setContenido(nuevo.getContenido());
        }

        if (root.getIzq() == null && root.getDer() != null) {
            root.setFactor(root.getDer().getFactor() + 1);
        } else if (root.getIzq() != null && root.getDer() == null) {
            root.setFactor(root.getIzq().getFactor() + 1);
        } else {
            root.setFactor(Math.max(factor(root.getIzq()), factor(root.getDer())) + 1);
        }

        this.root = padre;
        return padre;

    }

    public NodoAVL getRoot() {
        return root;
    }

    public void inorderArray(NodoAVL array[], NodoAVL root) {
        if (root.getIzq() != null) {
            inorderArray(array, root.getIzq());
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = root;
                break;
            }
        }

        if (root.getDer() != null) {
            inorderArray(array, root.getDer());
        }

    }

    public boolean eliminar(String nombre) {
        AVL nuevo = new AVL();

        if (total == 1 && this.root.getNombre().equals(nombre)) {
            this.root = nuevo.getRoot();
            this.total = nuevo.getTotal();
            return true;
        } else {
            eliminarR(nuevo, this.root, nombre);

            this.root = nuevo.getRoot();
            this.total = nuevo.getTotal();
            return true;
        }

    }

    public void eliminarR(AVL nuevo, NodoAVL root, String nombre) {
        if (!root.getNombre().equals(nombre)) {
            NodoAVL tn = new NodoAVL(root.getNombre(), root.getContenido(), root.getPropietario());
            tn.setTime(root.getTime());
            nuevo.agregar(tn);
        }

        if (root.getIzq() != null) {
            eliminarR(nuevo, root.getIzq(), nombre);
        }

        if (root.getDer() != null) {
            eliminarR(nuevo, root.getDer(), nombre);
        }
    }

    public boolean editar(String nombre, String n, String contenido) {
        AVL nuevo = new AVL();

        editarR(nuevo, this.root, nombre, n, contenido);

        this.root = nuevo.getRoot();
        this.total = nuevo.getTotal();

        return true;
    }

    public void editarR(AVL nuevo, NodoAVL root, String nombre, String n, String contenido) {
        if (root.getNombre().equals(nombre)) {
            NodoAVL nn = new NodoAVL(n, contenido, root.getPropietario());
            nn.setTime(root.getTime());
            nuevo.agregar(nn);
        } else {
            NodoAVL nn = new NodoAVL(root.getNombre(), root.getContenido(), root.getPropietario());
            nn.setTime(root.getTime());
            nuevo.agregar(nn);
        }

        if (root.getIzq() != null) {
            editarR(nuevo, root.getIzq(), nombre, n, contenido);
        }

        if (root.getDer() != null) {
            editarR(nuevo, root.getDer(), nombre, n, contenido);
        }
    }
    
    public String g(NodoAVL root){
        String retorno = "";
        String rank = "";

        if(root.getIzq() != null || root.getDer() != null){
            retorno = "\"" + root.getNombre() + "\"[label= \"<C0>| Nombre: " + root.getNombre() + "\\nNontenido: " + root.getContenido() + "\\nAltura: " + root.getAltura() + "\\nFactor: " + root.getFactor() + "\\nTime: " + root.getTime() + "\\nPropietario: " + root.getPropietario() + "|<C1>\"];\n";
            rank = "{rank=same; ";
        }else{
            retorno = "\"" + root.getNombre() + "\"[label= \"Nombre: " + root.getNombre() + "\\nNontenido: " + root.getContenido() + "\\nAltura: " + root.getAltura() + "\\nFactor: " + root.getFactor() + "\\nTime: " + root.getTime() + "\\nPropietario: " + root.getPropietario() + "\"];\n";
        }
                    
        if(root.getIzq() != null){
            retorno = retorno + g(root.getIzq());
            retorno = retorno + "\"" + root.getNombre() + "\":C0->\"" + root.getIzq().getNombre() + "\";\n";
            rank = rank + "\"" + root.getIzq().getNombre() + "\" ";
        }
            
        if (root.getDer() != null){
            retorno = retorno + g(root.getDer());
            retorno = retorno +  "\"" + root.getNombre() + "\":C1->\"" + root.getDer().getNombre() + "\";\n";
            rank = rank + "\"" + root.getDer().getNombre() + "\" ";
        }
            
        if (root.getIzq() != null || root.getDer() != null){
            rank = rank + "}\n";
        }
        
        retorno = retorno + rank;
        return retorno;
    
    }
    
    public boolean graficar() {
        FileWriter fichero;
        PrintWriter pw;
        try {
            fichero = new FileWriter("ReporteAVL.txt");
            pw = new PrintWriter(fichero);

            pw.write("digraph grafico{\ngraph [nodesep=2];\nnode [shape=record]\nrankdir=TB;\n");

            //Creacion de nodos
            
            if(this.root != null){
                String datos = g(this.root);
                pw.append(datos);
            }
            
            
            //Union de nodos
            

            //Agrupacion de nodos
            

            pw.append("}");

            pw.close();

            try {
                Runtime.getRuntime().exec("dot -Tjpg ReporteAVL.txt -o ReporteAVL.jpg");
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
    
    public void setRoot(NodoAVL root) {
        this.root = root;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public NodoAVL[] getArray() {
        NodoAVL array[];

        if (this.total != 0) {
            array = new NodoAVL[this.total];
            inorderArray(array, this.root);
            return array;
        } else {
            return null;
        }

    }

}
