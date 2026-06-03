package PruebasList;

import AlgoritmosListas.*;
import List.TadLista;

public class PruebaLista04 {
    public static void main(String[] args) {
        TadLista<Integer> miLista = new TadLista<>();
        AlgoritmosListas.insertarAlFinal(miLista, 1);
        AlgoritmosListas.insertarAlFinal(miLista, 2);
        AlgoritmosListas.insertarAlFinal(miLista, 3);
        miLista.imprimirLista();

        int total = AlgoritmosListas.countNodos(miLista);
        System.out.println("Total de nodos: " + total);
    }
}
