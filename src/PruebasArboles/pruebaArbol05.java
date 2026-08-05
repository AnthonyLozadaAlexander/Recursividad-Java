package PruebasArboles;

import AlgoritmosArboles.AlgoritmosArbolesBinario;
import Arboles.ArbolBB;

public class pruebaArbol05 {
    public static void main(String[] args) {
        ArbolBB<Integer> abb = new ArbolBB<Integer>("Mi ABB");
        abb.insertar(10);
        abb.insertar(5);
        abb.insertar(15);
        abb.insertar(3);
        abb.insertar(7);
        abb.insertar(20);

        AlgoritmosArbolesBinario.imprimirHojas(abb);
        System.out.println("Cantidad Hojas: " + AlgoritmosArbolesBinario.contarHojas(abb));
        System.out.println("7 es hoja?: " + (AlgoritmosArbolesBinario.esHoja(abb, 7) ? "Si es Hoja" : "No es Hoja"));

        System.out.println("Contar ABB: " + AlgoritmosArbolesBinario.contar(abb));
        System.out.println("Elemento Aleatorio Del Arbol: " + AlgoritmosArbolesBinario.aleatorio(abb));
    }
}
