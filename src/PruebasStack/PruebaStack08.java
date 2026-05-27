package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack08 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(5);
        miPila.apilar(9);
        miPila.apilar(3);
        // cima

        System.out.println("Pila Actual");
        miPila.imprimirPila();
        try {
            AlgoritmosPila.actualizarPosicionN(miPila, 2, 7);
            System.out.println("Pila Actualizada");
            miPila.imprimirPila();
        } catch (PilaVacia e) {

        }
    }
}
