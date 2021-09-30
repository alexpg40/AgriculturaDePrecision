/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author DAW207
 */
public class Parcela {
    
    private int idParcela;
    private int idAgricultor;
    private int area;
    private ArrayList listaPuntos;

    public Parcela() {
    }

    public Parcela(int idParcela, int idAgricultor, int area, ArrayList listaPuntos) {
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

    public ArrayList getListaPuntos() {
        return listaPuntos;
    }

    public void setListaPuntos(ArrayList listaPuntos) {
        this.listaPuntos = listaPuntos;
    }
    
    
    
}
