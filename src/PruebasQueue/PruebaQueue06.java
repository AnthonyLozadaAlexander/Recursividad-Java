package PruebasQueue;

import AlgoritmosQueue.AlgoritmoCola;
import Queue.ColaVacia;
import Queue.TadCola;

public class PruebaQueue06 {
    public static void main(String[] args) {
        TadCola<Integer> cola = new TadCola<>("Cola Integers");
        cola.encolar(5);
        cola.encolar(6);
        cola.encolar(7);
        cola.encolar(8);
        cola.encolar(1);
        cola.imprimirCola();

        try {
            AlgoritmoCola.intercambiarParesMA(cola);
            cola.imprimirCola();

        } catch (ColaVacia e) {

        }
    }

}
