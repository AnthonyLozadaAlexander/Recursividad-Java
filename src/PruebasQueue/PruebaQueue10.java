package PruebasQueue;

import AlgoritmosQueue.AlgoritmoCola;
import Queue.ColaVacia;
import Queue.TadCola;

public class PruebaQueue10 {
    public static void main(String[] args) {
        TadCola<Integer> cola = new TadCola<>("Cola Integers");
        cola.encolar(5);
        cola.encolar(8);
        cola.encolar(3);
        cola.encolar(2);
        cola.imprimirCola();

        try {

            AlgoritmoCola.filtrarImparesDos(cola);
            cola.imprimirCola();
        } catch (ColaVacia e) {

        }
    }

}
