/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkipList;

import java.util.Random;

/**
 *
 * @author hca
 */
public class SkipList<T extends Comparable<T>>{
    
    private int cont;
    private NodoS<T> cabeza, cola;
    
    public SkipList(){
        cont = 0;
        cabeza.setRigth(cola);
        cola.setLeft(cabeza);
    }
    
    public SkipList(T elem){
        this();
        if(elem != null){
            cont = 1;
            NodoS<T> nuevo = new NodoS(elem);
            nuevo.setRigth(cola);
            nuevo.setLeft(cabeza);
            cabeza.setRigth(nuevo);
            cola.setLeft(nuevo);
        }
    }
    
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    public NodoS<T> find(T elem){
        NodoS aux = cabeza.getRigth();
        return find(aux, elem);
    }
    
    private NodoS<T> find(NodoS<T> aux, T elem){
        if(aux.getElem().equals(elem)){             //SI LO ENCONTRÉ
            if(aux.getDown() == null)               //SI NO TIENE ABAJO
                return aux;                     
            else{
                while(aux.getDown() != null)        //SI TIENE ABAJO
                    aux = aux.getDown();
                return aux;
            }
        }
        else{
            if(elem.compareTo(aux.getElem()) > 0 && aux.getRigth() != null)     //SI ELEMENTO ES MAYOR AL NODO Y TIENE DERECHA - SE RECORRE
                return find(aux.getRigth(), elem);
            if(aux.getDown() != null)                                           //SI TIENE ABAJO - SE RECORRE ABAJO
                return find(aux.getDown(), elem); 
            else                                                                //SI ELEMENTO ES MENOR AL NODO Y NO TIENE ABAJO = NO LO ENCONTRÓ - REGRESA DONDE DEBERÍA IR
                return aux.getLeft();
            
        }
    }
    
    private void acomoda(NodoS<T> izq, NodoS<T> nuevo, NodoS<T> der){
        izq.setRigth(nuevo);
        nuevo.setLeft(izq);
        nuevo.setRigth(der);
        der.setLeft(nuevo);
    }
    
    public void insert(T elem){
        NodoS<T> nuevo = new NodoS(elem);;
        NodoS<T> ant = find(elem);
        NodoS<T> aux = cabeza;
        int niveles = 0;
        if(ant == null){ //SKIPLIST VACÍA
            acomoda(cabeza, nuevo, cola);
            //FLIP-COIN
        } else{ //ENCONTRÓ EL ELEMENTO ANTERIOR
            acomoda(ant, nuevo, ant.getRigth());
            cont++;
        }
        //FLIP COIN
        while(aux.getDown() != null)
            niveles++;
        Random r = new Random();
        if(r.nextBoolean()){
            
        }
        //ELSE, TERMINÓ DE INSERTAR
    }
    
    public void insert2(T elem){
        NodoS<T> nuevo = new NodoS(elem);
        NodoS<T> ant = find(elem);
        NodoS<T> escalera, index;
        int contSub = 0;
        
        nuevo.setLeft(ant);
        nuevo.setRigth(ant.getRigth());
        ant.getRigth().setLeft(ant);
        
    }
    
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextBoolean());
    }
}