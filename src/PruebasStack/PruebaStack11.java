package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack11 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(1);
        miPila.apilar(1);
        miPila.apilar(1);
        miPila.apilar(2);

        System.out.println("Pila Actual");
        miPila.imprimirPila();

        try {
            int contar = AlgoritmosPila.contarOcurrencias(miPila, 1);
            System.out.println("Ocurrencias En La Pila: " + contar);
        } catch (PilaVacia e) {

        }

    }
}
