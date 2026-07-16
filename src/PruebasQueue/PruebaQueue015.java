package PruebasQueue;

import AlgoritmosQueue.AlgoritmoCola;
import Queue.ColaVacia;
import Queue.TadCola;

public class PruebaQueue015 {
    public static void main(String[] args) {
        TadCola<Integer> cola = new TadCola<>("Cola Integers");
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        cola.encolar(4);
        cola.encolar(5);
        cola.encolar(6);

        cola.imprimirCola();

        try {

            AlgoritmoCola.eliminarPrimeraOcurrencia(cola,  3);
            cola.imprimirCola();

        } catch (ColaVacia e) {

        }
    }
}
