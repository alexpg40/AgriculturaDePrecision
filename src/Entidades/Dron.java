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
public class Dron {
    
    private int idDron;
    private int idAgricultor;
    
    public Dron(){
        
    }
    
    public Dron(int idDron, int idAgricultor){
        this.idDron = idDron;
        this.idAgricultor = idAgricultor;
    }

    public int getIdDron() {
        return idDron;
    }

    public void setIdDron(int idDron) {
        this.idDron = idDron;
    }

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(int idAgricultor) {
        this.idAgricultor = idAgricultor;
    }
    
    public static Dron registarDron(Agricultor a){
        Dron ret = new Dron();
        ret.setIdAgricultor(a.getIdAgricultor());
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce la id del dron: ");
        ret.setIdDron(in.nextInt());
    return ret;}
    
}
