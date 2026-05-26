package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaPila07 {
    public static void main(String[] args) {
        TadPila<String> miPila = new TadPila<>("Pila Integers");
        miPila.apilar("C");
        miPila.apilar("B");
        miPila.apilar("A");
        // cima

        System.out.println("Pila Actual");
        miPila.imprimirPila();
        try {
            System.out.println("Eliminar Al Fondo");
            AlgoritmosPila.eliminarBase(miPila);
            miPila.imprimirPila();
        } catch (PilaVacia e) {

        }
    }

}
