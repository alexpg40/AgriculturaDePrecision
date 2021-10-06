/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agriculturadeprecision;

import Entidades.*;
import Utilidades.Utilidad;
import java.util.Scanner;

public class AgriculturaDePrecision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Lista<Agricultor> agricultores = new Lista<>();
        agricultores.add(new Agricultor(1, "a", "Alex", "Perez", "a"));
        agricultores.add(new Agricultor(2, "b", "Alex", "Perez", "b"));
        Lista<Punto> puntos = new Lista<>();
        puntos.addFinal(new Punto(1, 1, 1));
        puntos.addFinal(new Punto(2, 1, 2));
        puntos.addFinal(new Punto(2, 2, 1));
        puntos.addFinal(new Punto(2, 2, 2));
        Lista<Parcela> parcelas = new Lista<>();
        parcelas.add(new Parcela(1, 1, 200, puntos));
        parcelas.add(new Parcela(2, 2, 600, puntos));
        Cola<Trabajo> trabajos = new Cola<>();
        trabajos.encolar(new Trabajo(1, 1, "Abonar", "En espera", 1));
        trabajos.encolar(new Trabajo(2, 1, "Fumigar", "En espera", 1));
        trabajos.encolar(new Trabajo(3, 1, "Abonar", "En espera", 1));
        trabajos.encolar(new Trabajo(4, 1, "Fumigar", "En espera", 1));
        trabajos.encolar(new Trabajo(5, 2, "Fumigar", "En espera", 2));
        Lista<Dron> drones = new Lista<>();
        drones.add(new Dron(1, 1));
        drones.add(new Dron(2, 2));

        boolean continuar = true;
        do {
            Scanner in = new Scanner(System.in);
            menuLogging();
            int opcion = in.nextInt();
            continuar = Logging(opcion, agricultores, parcelas, trabajos, drones);
        } while (continuar);

    }

    private static void menuLogging() {
        System.out.println("----------------------------");
        System.out.println("Pulsa 1 para Iniciar Sesion");
        System.out.println("Pulsa 2 para Registrar Sesion");
        System.out.println("Pulsa 3 para Salir");
        System.out.println("----------------------------");
    }

    private static boolean Logging(int opcion, Lista<Agricultor> agricultores, Lista<Parcela> parcelas, Cola<Trabajo> trabajos, Lista<Dron> drones) {
        switch (opcion) {
            case 1:
                Agricultor a = Agricultor.crearAgricultor();
                boolean inicio = a.iniciarSesion(agricultores);
                Lista<Parcela> conseguirParcelas = a.conseguirParcelas(parcelas);
                Cola<Trabajo> conseguirTrabajos = a.conseguirTrabajos(trabajos);
                if (inicio) {
                    System.out.println("Has iniciado sesión correctamente!");
                    boolean continuar = false;
                    do {
                        menuGestionAgricultor();
                        Scanner in = new Scanner(System.in);
                        continuar = gestionAgricultor(in.nextInt(), conseguirTrabajos, conseguirParcelas, drones, a);
                    } while (continuar);
                } else {
                    System.out.println("No se ha podido iniciar sesión!");
                }
                return true;
            case 2:
                Agricultor nuevo = Agricultor.regristrarSesion();
                agricultores.add(nuevo);
                return true;
            case 3:
                System.out.println("Has cerrado salido del programa");
                return false;
            default:
                System.out.println("Opción no valida!");
                return true;
        }
    }

    public static void menuGestionAgricultor() {
        System.out.println("----------------------------");
        System.out.println("Pulsa 1 para añadir trabajos");
        System.out.println("Pulsa 2 para resgistrar drones");
        System.out.println("Pulsa 3 para mostrar tus parcelas");
        System.out.println("Pulsa 4 para ejecutar todos los trabajos");
        System.out.println("Pulsa 5 para mostrar trabajos");
        System.out.println("Pulsa 6 para ejercutar un trabajo");
        System.out.println("Pulsa 7 para salir");
        System.out.println("----------------------------");
    }

    public static boolean gestionAgricultor(int opcion, Cola<Trabajo> conseguirTrabajos, Lista<Parcela> conseguirParcelas, Lista<Dron> drones, Agricultor a) {
        switch (opcion) {
            case 1:
                conseguirTrabajos.encolar(Trabajo.crearTrabajo(conseguirParcelas, a.getIdAgricultor()));
                return true;
            case 2:
                drones.add(Dron.registarDron(a));
                return true;
            case 3:
                Utilidad.mostrar(a.conseguirParcelas(conseguirParcelas));
                return true;
            case 4:
                if (conseguirTrabajos.isVacio()) {
                    System.out.println("No hay trabajos en cola!");
                } else {
                    while (!conseguirTrabajos.isVacio()) {
                        Trabajo desencolar = conseguirTrabajos.desencolar();
                        desencolar.ejecutarTrabajo(conseguirParcelas);
                    }
                }
                return true;
            case 5:
                Utilidades.Utilidad.mostrar(conseguirTrabajos);
                return true;
            case 6:
                if (!conseguirTrabajos.isVacio()) {
                    conseguirTrabajos.desencolar().ejecutarTrabajo(conseguirParcelas);
                } else{
                    System.out.println("No hay tareas en cola!");
                }
                return true;
            case 7:
                return false;
            default:
                System.out.println("Opción no valida!");
                return true;
        }
    }

}
