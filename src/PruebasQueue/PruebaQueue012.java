package PruebasQueue;

import AlgoritmosQueue.AlgoritmoCola;
import Queue.ColaVacia;
import Queue.TadCola;

public class PruebaQueue012 {
    public static void main(String[] args) {
        TadCola<String> cola = new TadCola<>("Cola Integers");
        cola.encolar("1");
        cola.encolar("4");
        cola.encolar("5");
        cola.encolar("7");
        cola.encolar("9");
        cola.imprimirCola();

        try {
            AlgoritmoCola.insertarDelanteDe(cola, "2", "8");
            cola.imprimirCola();

        } catch (ColaVacia e) {

        }
    }

}
