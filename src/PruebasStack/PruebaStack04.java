package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack04 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(5);
        miPila.apilar(9);
        miPila.apilar(3);
        // cima

        System.out.println("Pila Actual");
        miPila.imprimirPila();
        try {
            System.out.println("El numero mayor de una pila");
            Integer max = AlgoritmosPila.buscarElementoMax(miPila);
            miPila.imprimirPila();
            System.out.println(max);
        } catch (PilaVacia e) {

        }
    }

}
