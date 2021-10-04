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
public class Trabajo {
   
    private int idTrabajo;
    private int idParcela;
    private String tipoTarea;
    private String estado;
    
    public Trabajo(){
        
    }
    
    public Trabajo(int idTrabajo, int idParcela, String tipoTarea, String estado){
        this.idTrabajo = idTrabajo;
        this.idParcela = idParcela;
        this.tipoTarea = tipoTarea;
        this.estado = estado;
    }

    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(int idParcela) {
        this.idParcela = idParcela;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public static String elegirTarea(){
        System.out.println("Introduce 1 para Abonar o 2 para Fumigar");
        Scanner in = new Scanner(System.in);
        int opcion = in.nextInt();
        switch(opcion){
            case 1:
                return "Abonar";
            default:
                return "Fumigar";
        }
    }
    
    public boolean ejecutarTrabajo(Lista<Parcela> parcelas){
        Nodo<Parcela> aux = parcelas.getNodoPrimero();
        while(aux != null){
            if(aux.getInfo().getIdParcela() == this.idParcela){
                System.out.println("Empezando la tarea con id " + this.idTrabajo);
                Nodo<Punto> aux2 = aux.getInfo().getListaPuntos().getNodoPrimero();
                while(aux2 != null){
                    System.out.println("Estoy en el " + aux2.getInfo());
                    aux2 = aux2.getSig();
                }
                this.estado = "Terminada";
                System.out.println("Tarea terminada!");
            }
            aux = aux.getSig();
        }
    return false;}
    
    public static Trabajo crearTrabajo(){
        Trabajo ret = new Trabajo();
        System.out.println("Introduce el idTrabajo: ");
        Scanner in = new Scanner(System.in);
        ret.setIdTrabajo(in.nextInt());
        System.out.println("Introduce la idParcela: ");
        ret.setIdParcela(in.nextInt());
        ret.setTipoTarea(Trabajo.elegirTarea());
        ret.setEstado("En espera");
    return ret;}
    
}
