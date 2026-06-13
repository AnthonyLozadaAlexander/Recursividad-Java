package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack10 {
    public static void main(String[] args) {
        TadPila<Integer> miPila = new TadPila<>("Pila Integers");
        miPila.apilar(40);
        miPila.apilar(30);
        miPila.apilar(20);
        miPila.apilar(10);

        System.out.println("Pila Actual");
        miPila.imprimirPila();

        try {
            System.out.println("Obtener Elemento En Posicion");
            int pos = 3;
            System.out.println("Obtener Elemento En Posicion["+pos+"]");
            int obtener = AlgoritmosPila.obtenerElementoEnPosicion(miPila, pos);
            System.out.println("Pila Posicion["+ pos +"]: " + obtener);
        } catch (PilaVacia e) {

        }

    }
}


