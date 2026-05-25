package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;
import AlgoritmosQueue.*;

public class PuebaQueue04 {
    public static void main(String[] args) {
        TadCola<Integer> cola = new TadCola<>("Cola Integers");
        cola.encolar(5);
        cola.encolar(6);
        cola.encolar(7);
        cola.encolar(8);
        cola.encolar(1);
        cola.imprimirCola();

        try {
          
            AlgoritmoCola.intercambairLugares(cola, 1, 3);
            cola.imprimirCola();
        } catch (ColaVacia e) {

        }

    }

}
