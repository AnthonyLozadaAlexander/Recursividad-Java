package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack08 {
    public static void main(String[] args) {
        TadPila<String> miPila = new TadPila<>("Pila Integers");
        miPila.apilar("C");
        miPila.apilar("B");
        miPila.apilar("A");
        // cima

        System.out.println("Pila Actual");
        miPila.imprimirPila();
        try {
            System.out.println("Actualizar Elemento ");
            AlgoritmosPila.actualizarEnPosicion(miPila, 2, "W");
            miPila.imprimirPila();
        } catch (PilaVacia e) {

        }
    }

}
