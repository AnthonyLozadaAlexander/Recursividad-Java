package PruebasStack;

import Stack.*;
import AlgoritmosStack.*;

public class PruebaStack02 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(3);
        miPila.apilar(2);
        miPila.apilar(1);

        System.out.println("Pila Actual");
        miPila.imprimirPila();
        try {
            AlgoritmosPila.insertarAlFondo(miPila, 4);
            miPila.imprimirPila();
        } catch (PilaVacia e) {

        }

    }

}
