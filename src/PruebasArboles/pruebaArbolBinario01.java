package PruebasArboles;

import AlgoritmosArboles.AlgoritmosArboles;
import Arboles.Arbol;

public class pruebaArbolBinario01 {
    public static void main(String[] args) {
        Arbol<Integer> a1 = new Arbol<>(1);
        Arbol<Integer> a4 = new Arbol<>(4);
        Arbol<Integer> a6 = new Arbol<>(6);
        Arbol<Integer> a9 = new Arbol<>(9);

        Arbol<Integer> a3 = new Arbol<>();
        Arbol<Integer> a7 = new Arbol<>();
        Arbol<Integer> a5 = new Arbol<>();

        Arbol.juntar(a3, 3, a1, a4);
        Arbol.juntar(a7, 7, a6, a9);
        Arbol.juntar(a5, 5, a3, a7);

        int count = AlgoritmosArboles.contarNodos(a5);
        System.out.println(count);
    }
}
