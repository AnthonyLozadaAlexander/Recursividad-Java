package PruebasQueue;

import AlgoritmosQueue.AlgoritmoCola;
import Queue.ColaVacia;
import Queue.TadCola;

public class PruebaQueue012 {
    public static void main(String[] args) {
        TadCola<String> cola = new TadCola<>("Cola Integers");
        cola.encolar("X");
        cola.encolar("B");
        cola.encolar("Y");
        cola.imprimirCola();

        try {
            AlgoritmoCola.insertarDelanteDe(cola, "A", "B");
            cola.imprimirCola();

        } catch (ColaVacia e) {

        }
    }

}
