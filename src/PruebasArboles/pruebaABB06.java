package PruebasArboles;

import AlgoritmosArboles.AlgoritmosArbolesBinario;
import Arboles.ArbolBB;

public class pruebaABB06 {
    public static void main(String[] args) {
        boolean modificar = false;
        ArbolBB<Integer> abb = new ArbolBB<Integer>("Mi ABB");
        abb.insertar(10);
        abb.insertar(5);
        abb.insertar(15);
        abb.insertar(3);
        abb.insertar(7);
        abb.insertar(20);

        modificar = AlgoritmosArbolesBinario.modificar(abb, 7, 99);
        System.out.println("El arbol abb fue " + (modificar ? "Modificado Con Exito" : "No Se Pudo Modificar"));
        abb.info();
    }
}
