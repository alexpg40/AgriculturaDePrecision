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
public class Agricultor {
    
    private int idAgricultor;
    private String DNI;
    private String nombre;
    private String apellido;
    private String contraseña;

    public Agricultor() {
        
    }

    public Agricultor(String DNI, String contraseña) {
        this.DNI = DNI;
        this.contraseña = contraseña;
    }
    
    public Agricultor(int idAgricultor, String DNI, String nombre, String apellido, String contraseña) {
        this.idAgricultor = idAgricultor;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
    }

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(int idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public static Agricultor regristrarSesion(){
        Agricultor ret = new Agricultor();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        ret.setNombre(in.next());
        System.out.println("Introduce tu apellido: ");
        ret.setApellido(in.next());
        System.out.println("Introduce tu DNI: ");
        ret.setDNI(in.next());
        System.out.println("Introduce tu constraseña: ");
        ret.setContraseña(in.next());
    return ret;}
    
    public boolean iniciarSesion(Lista<Agricultor> agricultores){
        Nodo aux = agricultores.getNodoPrimero();
        while(aux != null){
            Agricultor a = (Agricultor) aux.getInfo();
           if(a.getDNI().equals(DNI) && a.getContraseña().equals(contraseña)){
               this.idAgricultor = a.idAgricultor;
               return true;
           }
           aux = aux.getSig();
        }
    return false;}
    
    public static Agricultor crearAgricultor(){
        Agricultor ret = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce tu DNI: ");
        String DNI = in.next();
        System.out.println("Introduce tu contraseña: ");
        in = new Scanner(System.in);
        String contraseña = in.next();
        ret = new Agricultor(DNI, contraseña);
    return ret;}
    
    public Lista<Parcela> conseguirParcelas(Lista<Parcela> parcelas){
        Lista<Parcela> ret = new Lista<>();
        Nodo aux = parcelas.getNodoPrimero();
        while(aux != null){
            Parcela p = (Parcela) aux.getInfo();
            if(p.getIdAgricultor() == this.idAgricultor){
                ret.add(p);
            }
            aux = aux.getSig();
        }
    return ret;}
    
}
