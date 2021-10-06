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
    private int idAgricultor;
    private String tipoTarea;
    private String estado;
    
    public Trabajo(){
        
    }
    
    public Trabajo(int idTrabajo, int idParcela, String tipoTarea, String estado, int Agricultor){
        this.idTrabajo = idTrabajo;
        this.idParcela = idParcela;
        this.tipoTarea = tipoTarea;
        this.estado = estado;
        this.idAgricultor = Agricultor;
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

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(int idAgricultor) {
        this.idAgricultor = idAgricultor;
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
                System.out.println("Empezando la tarea con id " + this.idTrabajo);
                Nodo<Punto> aux2 = aux.getInfo().getListaPuntos().getNodoPrimero();
                while(aux2 != null){
                    System.out.println("Estoy en el " + aux2.getInfo());
                    aux2 = aux2.getSig();
                }
                this.estado = "Terminada";
                System.out.println("Tarea terminada!");
            aux = aux.getSig();
        }
    return false;}
    
    public static Trabajo crearTrabajo(Lista<Parcela> parcelas, int idAgricultor){
        Trabajo ret = new Trabajo();
        System.out.println("Introduce el idTrabajo: ");
        Scanner in = new Scanner(System.in);
        ret.setIdTrabajo(in.nextInt());
        int idParcela = 0;
        boolean continuar = true;
        do{
            System.out.println("Introduce la idParcela (La parcela debe pertenercele): ");
            idParcela = in.nextInt();
            Nodo aux = parcelas.getNodoPrimero();
            while(aux != null){
                Parcela p = (Parcela) aux.getInfo();
                if(p.getIdParcela() == idParcela){
                    ret.setIdParcela(idParcela);
                    continuar = false;
                    break;
                }
                aux = aux.getSig();
            }
        }while(continuar);
        ret.setTipoTarea(Trabajo.elegirTarea());
        ret.setEstado("En espera");
        ret.setIdAgricultor(idAgricultor);
    return ret;}

    @Override
    public String toString() {
        return "El Trabajo de " + this.tipoTarea+ " con la id " + this.idTrabajo + ", de la parcela con id " + this.idParcela + ", esta en estado: " + this.estado;
    }
    
    
}
