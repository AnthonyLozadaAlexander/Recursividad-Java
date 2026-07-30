package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack14 {
    public static void main(String[] args) {
        TadPila<String> miPila = new TadPila<>("Pila Integers");
        miPila.apilar("DocC");
        miPila.apilar("DocA");
        miPila.apilar("DocB");
        miPila.apilar("DocA");

        System.out.println("Pila Actual");
        miPila.imprimirPila();

        try {
            AlgoritmosPila.remplazarElementoCercaBase(miPila, "DocA", "Nuevo_A");
            System.out.println("\nPila despues de remplazar");
            miPila.imprimirPila();
        } catch (PilaVacia e) {

        }
    }

}
