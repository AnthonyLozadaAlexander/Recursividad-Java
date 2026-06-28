package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack13 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(1);
        miPila.apilar(2);
        miPila.apilar(3);
        miPila.apilar(4);
        miPila.apilar(5);

        System.out.println("Pila Actual");
        miPila.imprimirPila();

        try {
            AlgoritmosPila.invertirPila(miPila);
            System.out.println("Pila despues de invertir");
            miPila.imprimirPila();
        } catch (PilaVacia e) {

        }

    }
}
