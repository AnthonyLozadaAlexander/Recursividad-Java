package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack05 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(5);
        miPila.apilar(9);
        miPila.apilar(3);
        // cima

        System.out.println("Pila Actual");
        miPila.imprimirPila();
        try {
            Integer count = AlgoritmosPila.contarElementosR(miPila);
            System.out.println("Contar Elementos De La Pila");
            miPila.imprimirPila();
            System.out.println(count);
        } catch (PilaVacia e) {

        }
    }

}
