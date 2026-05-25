package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack03 {
    public static void main(String[] args) {

        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(1);
        miPila.apilar(3);
        miPila.apilar(2);
        miPila.apilar(3); // cima

        System.out.println("Pila Actual");
        miPila.imprimirPila();
        try {
            System.out.println("Pila Despues De Las Ocurrencias: ");
            AlgoritmosPila.eliminarOcurrencias(miPila, 3);
            miPila.imprimirPila();
        } catch (PilaVacia e) {

        }
    }

}
