/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author DAW207
 */
public class Lista <T>{
    
    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoFinal;

    public Lista() {
        this.nodoFinal = null;
        this.nodoPrimero = null;
    }

    public Lista(Nodo<T> nodoPrimero, Nodo<T> nodoFinal) {
        this.nodoPrimero = nodoPrimero;
        this.nodoFinal = nodoFinal;
    }

    public Nodo getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(Nodo<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public Nodo getNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(Nodo<T> nodoFinal) {
        this.nodoFinal = nodoFinal;
    }

    public void mostrar() {
        Nodo aux = this.nodoPrimero;
        while (aux != null) {
            System.out.println("El nodo tiene inf " + aux.getInfo());
            aux = aux.getSig();
        }
    }

    public void add(T x) {
        Nodo nuevo = new Nodo(x, null);
        if (this.nodoFinal == null && this.nodoPrimero == null) {
            this.nodoPrimero = nuevo;
            this.nodoFinal = nuevo;
        } else {
            nuevo.setSig(this.nodoPrimero);
            nodoPrimero = nuevo;
        }
    }

    public void addFinal(T x) {
        Nodo nuevo = new Nodo(x, null);
        if (this.nodoFinal == null && this.nodoPrimero == null) {
            this.nodoPrimero = nuevo;
            this.nodoFinal = nuevo;
        } else {
            nodoFinal.setSig(nuevo);
            nodoFinal = nuevo;
        }
    }

    public boolean borrar(T x) {
        boolean borrado = false;
        Nodo aux = this.nodoPrimero;
        Nodo ant = null;
        while (aux != null) {
            if (aux.getInfo() == x) {
                if (ant == null) {
                    this.nodoPrimero = aux.getSig();
                } else if (this.nodoFinal == aux.getSig()) {
                    this.nodoFinal = aux;
                } else {
                    ant.setSig(aux.getSig());
                }
                borrado = true;
            } else {
                ant = aux;
            }
            aux = aux.getSig();
        }

        return borrado;
    }

    public boolean borrarPrimero() {
        if (this.nodoPrimero == null) {
            return false;
        } else {
            nodoPrimero = nodoPrimero.getSig();
            return true;
        }
    }
    
    public boolean isVacio() {
        return this.nodoPrimero == null;
    }
    
    public boolean borrarUltimo(){
        if (this.nodoFinal == null) {
            return false;
        } else {
            Nodo aux = this.nodoPrimero;
            Nodo ant = null;
            while(aux != null){
                if(aux == this.nodoFinal){
                    this.nodoFinal = ant;
                    ant.setSig(null);
                } else{
                    ant = aux;
                }
            aux = aux.getSig();
            }
        }
    return true;}
    
    public T damePrimero(){
        return this.nodoPrimero.getInfo();
    }
    
    public void concatenar(Lista<T> l){
        Nodo aux = l.getNodoPrimero();
        while(aux != null){
            this.addFinal((T) aux.getInfo());
            aux = aux.getSig();
        }
    }
    
    public void reverse(){
        Nodo aux = this.getNodoPrimero();
        this.borrarTodo();
        while(aux != null){
            this.add((T) aux.getInfo());
            aux = aux.getSig();
        }
    }
    
    public void borrarTodo(){
        this.nodoFinal = null;
        this.nodoPrimero = null;
    }
    
    
}
