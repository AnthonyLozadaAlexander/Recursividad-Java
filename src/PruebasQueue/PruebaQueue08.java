package PruebasQueue;

import AlgoritmosQueue.AlgoritmoCola;
import Queue.ColaVacia;
import Queue.TadCola;

public class PruebaQueue08 {
    public static void main(String[] args) {
        TadCola<Integer> cola = new TadCola<>("Cola Integers");
        cola.encolar(1);
        cola.encolar(2);
        System.out.println("Cola Original: ");
        cola.imprimirCola();

        try {
            AlgoritmoCola.duplicarElemento(cola);
            cola.imprimirCola();
        } catch (ColaVacia e) {

        }
    }
}
