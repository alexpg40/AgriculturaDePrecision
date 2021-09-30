/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agriculturadeprecision;

import Entidades.*;
import java.util.Scanner;
public class AgriculturaDePrecision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Lista<Agricultor> agricultores = new Lista<>();
        agricultores.add(new Agricultor("1234567A", "1234"));
        
        boolean continuar = true;
        do{
            Scanner in = new Scanner(System.in);
            menuLogging();
            int opcion = in.nextInt();
            boolean inicio = Logging(opcion, agricultores);            
        }while(continuar);
        
    }
    
    private static void menuLogging(){
        System.out.println("Pulsa 1 para Iniciar Sesion");
        System.out.println("Pulsa 2 para Registrar Sesion");
        System.out.println("Pulsa 3 para Salir");
    }
    
    private static boolean Logging(int opcion, Lista<Agricultor> agricultores){
        switch (opcion) {
            case 1:
                Agricultor a = Agricultor.crearAgricultor();
                boolean inicio = a.iniciarSesion(agricultores);
                if(inicio){
                    System.out.println("Has iniciado sesión correctamente!");
                } else{
                    System.out.println("No se ha podido iniciar sesión!");
                }
                return true;
            case 2:
                Agricultor nuevo = Agricultor.regristrarSesion();
                agricultores.add(nuevo);
                return true;
            case 3:
                return false;
            default:
                System.out.println("Opción no valida!");
                return true;
        }
    }
}
