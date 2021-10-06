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
public class Cola<T> {
    
    private Nodo<T> principio;
    private Nodo<T> fin;

    public Cola(Nodo<T> principio, Nodo<T> fin) {
        this.principio = principio;
        this.fin = fin;
    }
    
    public Cola(){
        this.principio = null;
        this.fin = null;
    }

    public Nodo<T> getPrincipio() {
        return principio;
    }

    public void setPrincipio(Nodo<T> principio) {
        this.principio = principio;
    }

    public Nodo<T> getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }
    
    public void encolar(T x){
        Nodo nuevo = new Nodo(x, null);
        if (this.principio == null) {
            this.principio = nuevo;
            this.fin = nuevo;
        } else {
            fin.setSig(nuevo);
            fin = nuevo;
        }
    }
    
    public T desencolar(){
        T ret = this.principio.getInfo();
        this.principio = this.principio.getSig();
        return ret;
    }
    
    public T darPrimero(){
        return this.principio.getInfo();
    }
    
    public boolean isVacio(){
        return this.principio == null;
    }
    
    public void mostrar(){
        while(!this.isVacio()){
            System.out.println(this.desencolar());
        }
    }

    public boolean borrar(T x) {
        boolean borrado = false;
        Nodo aux = this.principio;
        Nodo ant = null;
        while (aux != null) {
            if (aux.getInfo() == x) {
                if (ant == null) {
                    this.principio = aux.getSig();
                } else if (this.fin == aux.getSig()) {
                    this.principio = aux;
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
    
}
