package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;
import AlgoritmosQueue.*;

public class PruebaQueue01 {
    static void main(String[] args) {
        TadCola<Integer> cola = new TadCola<>("Cola Integers");
        cola.encolar(4);
        cola.encolar(7);
        cola.encolar(1);
        cola.encolar(8);
        cola.encolar(2);
        cola.encolar(5);
        System.out.println("Cola Original");
        cola.imprimirCola();



        try {
            // AlgoritmoCola.invertirCola(cola);
            // System.out.println("Cola Invertida");
            // cola.imprimirCola();

            // System.out.println("Llevar Ultimo Elemento De La Cola Al Inicio");
            // AlgoritmoCola.ultimoAPrimero(cola);

            int tamanio = AlgoritmoCola.contarElementsR(cola, 0);
            System.out.println("La cantidad de la cola es de: " + tamanio);
            System.out.println("Cola Invertida");
            // cola.invertirCola();
            cola.imprimirCola();


        } catch (ColaVacia e) {
            e.getMessage();
        }
    }
}
