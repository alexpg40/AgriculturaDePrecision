/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAW207
 */
public class Parcela {
    
    private int idParcela;
    private int idAgricultor;
    private int area;
    private Lista<Punto> listaPuntos;

    public Parcela() {
    }

    public Parcela(int idParcela, int idAgricultor, int area, Lista<Punto> listaPuntos) {
        this.idParcela = idParcela;
        this.idAgricultor = idAgricultor;
        this.area = area;
        this.listaPuntos = listaPuntos;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(int idParcela) {
        this.idParcela = idParcela;
    }

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(int idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Lista<Punto> getListaPuntos() {
        return listaPuntos;
    }

    public void setListaPuntos(Lista<Punto> listaPuntos) {
        this.listaPuntos = listaPuntos;
    }
    
    public static Parcela registrarParcelas(Agricultor a){
        Parcela ret = new Parcela();
        Scanner in = new Scanner(System.in);
        ret.setIdAgricultor(a.getIdAgricultor());
        System.out.println("Introduce la idParcela: ");
        ret.setIdParcela(in.nextInt());
        System.out.println("Introduce el area: ");
        ret.setArea(in.nextInt());
        ret.setListaPuntos(Punto.crearListaPuntos());
    return ret;}

    @Override
    public String toString() {
        return "Parcela con id " + this.idParcela + " de area " + this.area + ", es del agricultor con id: " + this.idAgricultor;
    }

}
