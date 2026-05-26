package PruebasQueue;

import AlgoritmosQueue.AlgoritmoCola;
import Queue.ColaVacia;
import Queue.TadCola;

public class PruebaQueue11 {
    public static void main(String[] args) {
        TadCola<Integer> cola = new TadCola<>("Cola Integers");
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        cola.imprimirCola();

        try {

            Boolean resul = AlgoritmoCola.encontrar(cola, 2);
            cola.imprimirCola();
            System.out.println(resul);
            
        } catch (ColaVacia e) {

        }
    }

}
