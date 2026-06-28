package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack12 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(1);
        miPila.apilar(2);
        miPila.apilar(3);
        miPila.apilar(4);

        System.out.println("Pila Actual");
        miPila.imprimirPila();

        try {
            AlgoritmosPila.datoFondo(miPila, 3);
            System.out.println("Pila despues de insertar al fondo");
            miPila.imprimirPila();
        } catch (PilaVacia e) {

        }

    }
}
