package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack09 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(6);
        miPila.apilar(5);
        miPila.apilar(4);

        System.out.println("Pila Actual");
        miPila.imprimirPila();

        try {
            System.out.println("Sumar Elementos");
            int totalSuma = AlgoritmosPila.sumarElementos(miPila);
            System.out.println(totalSuma);
        } catch (PilaVacia e) {

        }
    }
}


