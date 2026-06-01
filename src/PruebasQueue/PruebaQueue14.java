package PruebasQueue;

import AlgoritmosQueue.AlgoritmoCola;
import Queue.ColaVacia;
import Queue.TadCola;

public class PruebaQueue14 {
    public static void main(String[] args) {
        TadCola<Integer> cola = new TadCola<>("Cola Integers");
        cola.encolar(4);
        cola.encolar(7);
        cola.encolar(2);
        cola.encolar(5);
        cola.encolar(1);
        cola.imprimirCola();

        try {

            AlgoritmoCola.insertarDelanteDe2(cola, 8, 2);
            cola.imprimirCola();


        } catch (ColaVacia e) {

        }
    }
}
