package PruebasQueue;

import AlgoritmosQueue.AlgoritmoCola;
import Queue.ColaVacia;
import Queue.TadCola;

public class PruebaQueue02 {
    public static void main(String[] args) {
        TadCola<Integer> cola = new TadCola<>("Cola Integers");
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        cola.encolar(4);
        cola.encolar(5);
        cola.encolar(6);
        cola.encolar(9);
        System.out.println("Cola Original");
        cola.imprimirCola();

        try {
            AlgoritmoCola.insertarEnMedio(cola, 7);
            cola.imprimirCola();
            AlgoritmoCola.agregarEnPosisionNDelante(cola,99);
            cola.imprimirCola();
            System.out.println(cola.numElemCola()/2);
            
        } catch (ColaVacia e) {

        }

    }

}
