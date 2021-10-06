/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Entidades.*;

public class Utilidad {
    
    public static <T> void mostrar(Lista<T> lista){
        Nodo aux = lista.getNodoPrimero();
        while(aux != null){
            T t = (T) aux.getInfo();
            System.out.println(t);
            aux = aux.getSig();
        }
    }
    
    public static <T> void mostrar(Cola<T> cola){
        if(cola.isVacio()){
            System.out.println("La cola esta vacia!");
        }else{
            Nodo aux = cola.getPrincipio();
        while(aux != null){
            T t = (T) aux.getInfo();
            System.out.println(t);
            aux = aux.getSig();
        }
        }
    }
    
}
