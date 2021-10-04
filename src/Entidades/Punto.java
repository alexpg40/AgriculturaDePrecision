/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author DAW207
 */
public class Punto {
    
    private int idPunto;
    private int x;
    private int y;

    public Punto() {
    }

    public Punto(int idPunto, int x, int y) {
        this.idPunto = idPunto;
        this.x = x;
        this.y = y;
    }

    public int getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(int idPunto) {
        this.idPunto = idPunto;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punto X = " + x + ", e Y = " + y;
    }
    
    public static Lista<Punto> crearListaPuntos(){
        Lista<Punto> ret = new Lista<>();
        Scanner in = new Scanner(System.in);
        System.out.println("¿Cuantos puntos quieres introducir? ");
        int n = in.nextInt();
        while(n>0){
            System.out.println("Introduce la id: ");
            int id = in.nextInt();
            System.out.println("Introduce la x: ");
            int x = in.nextInt();
            System.out.println("Introduce la y: ");
            int y = in.nextInt();
            ret.add(new Punto(id, x, y));
            n--;
        }
    return ret;}
    
}
