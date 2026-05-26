package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaPila06 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(1);
        miPila.apilar(2);
        miPila.apilar(3);
        miPila.apilar(4);
        // cima

        System.out.println("Pila Actual");
        miPila.imprimirPila();
        try {
            System.out.println("Elemento Al Fondo");
            AlgoritmosPila.insertarAlFondoA(miPila, 0);
            miPila.imprimirPila();
        } catch (PilaVacia e) {

        }
    }

}
