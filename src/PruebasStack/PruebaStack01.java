package PruebasStack;

import AlgoritmosStack.AlgoritmosPila;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaStack01 {
    static void main(String[] args) {
        int tamanio = 0;
        TadPila<Integer> pila = new TadPila("miPila");
        pila.apilar(3);
        pila.apilar(2);
        pila.apilar(1);
        pila.imprimirPila();

        try {
            tamanio = AlgoritmosPila.contarPila(pila);
            System.out.println("Tamanio de la pila es de: " + tamanio);
            System.out.println("Pila Original");
            pila.imprimirPila();

            System.out.println("Pila Invertida");
            AlgoritmosPila.imprimirPilaInvertida(pila);
        }catch(PilaVacia e){

        }
    }
}
