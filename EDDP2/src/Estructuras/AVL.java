/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
/**
 *
 * @author Micky
 */
public class AVL {
    private NodoAVL root;

    public AVL() {
        this.root = null;
    }
    
    public int factor(NodoAVL root){
        if(root == null){
            return -1;
        }else{
            return root.getFactor();
        }
    }
    
    public int altura(NodoAVL root){
        if(root == null){
            return 0;
        }else{
            return root.getAltura();
        }
    }
    
    public void agregar(NodoAVL nuevo){
        if(this.root == null){
            this.root = nuevo;
        }else{
            agregarAVL(this.root, nuevo);
        }
    }
    
    public NodoAVL rotacionI(NodoAVL root){
        NodoAVL aux = root.getIzq();
        root.setIzq(aux.getDer());
        aux.setDer(root);
        root.setFactor(Math.max(factor(root.getIzq()), factor(root.getDer())));
        root.setAltura(Math.max(altura(root.getIzq()), altura(root.getDer())));
        aux.setFactor(Math.max(factor(aux.getIzq()), factor(aux.getDer())));
        aux.setAltura(Math.max(altura(aux.getIzq()), altura(aux.getDer())));
        return aux;
    }
    
    public NodoAVL rotacionD(NodoAVL root){
        NodoAVL aux = root.getDer();
        root.setDer(aux.getIzq());
        aux.setIzq(root);
        root.setFactor(Math.max(factor(root.getIzq()), factor(root.getDer())));
        root.setAltura(Math.max(altura(root.getIzq()), altura(root.getDer())));
        aux.setFactor(Math.max(factor(aux.getIzq()), factor(aux.getDer())));
        aux.setAltura(Math.max(altura(aux.getIzq()), altura(aux.getDer())));
        return aux;
    }
    
    public NodoAVL rotacionDI(NodoAVL root){
        root.setIzq(rotacionD(root.getIzq()));
        NodoAVL temp = rotacionI(root);
        return temp;
    }
    
    public NodoAVL rotacionID(NodoAVL root){
        root.setDer(rotacionI(root.getDer()));
        NodoAVL temp = rotacionD(root);
        return temp;
    }
    
    public NodoAVL agregarAVL(NodoAVL root, NodoAVL nuevo){
        NodoAVL padre = root;
        int max = root.getNombre().compareTo(nuevo.getNombre());
        if(max > 0){
            if(root.getIzq() == null){
                root.setIzq(nuevo);
            }else{
                root.setIzq(agregarAVL(root.getIzq(), nuevo));
                if(factor(root.getIzq()) - factor(root.getDer()) == 2){
                    int maxx = root.getIzq().getNombre().compareTo(nuevo.getNombre());
                    if(maxx > 0){
                       padre = rotacionI(root);
                    }else{
                        padre = rotacionDI(root);
                    }
                }
            }
        }else if(max < 0){
            if(root.getDer() == null){
                root.setDer(nuevo);
            }else{
                root.setDer(agregarAVL(root.getDer(), nuevo));
                if(factor(root.getDer()) - factor(root.getIzq()) == 2){
                    int maxx = root.getIzq().getNombre().compareTo(nuevo.getNombre());
                    if(maxx < 0){
                       padre = rotacionD(root);
                    }else{
                        padre = rotacionID(root);
                    }
                }
            }
        } else{
            System.out.println("Nodo duplicado");
        }
        
        if(root.getIzq() == null && root.getDer() != null){
            root.setFactor(root.getDer().getFactor() + 1);
            root.setAltura(altura(root.getDer()) + 1);
        }else if(root.getIzq() != null && root.getDer() == null){
            root.setFactor(root.getIzq().getFactor() + 1);
            root.setAltura(altura(root.getIzq()) + 1);
        }else{
            root.setFactor(Math.max(factor(root.getIzq()), factor(root.getDer())) + 1);
            root.setAltura(Math.max(altura(root.getIzq()), altura(root.getDer())) + 1);
        }
        
        this.root = padre;
        return padre;

    }

    public NodoAVL getRoot() {
        return root;
    }

    public void setRoot(NodoAVL root) {
        this.root = root;
    }
    
    
}
