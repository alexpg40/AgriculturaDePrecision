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
    
    
    
}
