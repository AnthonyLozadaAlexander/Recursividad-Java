package PruebasList;

import AlgoritmosListas.*;
import List.TadLista;

public class PruebaList04 {
    public static void main(String[] args) {
        TadLista<Integer> miLista = new TadLista<>();
        AlgoritmosListas.insertarAlFinal(miLista, 85);
        AlgoritmosListas.insertarAlFinal(miLista, 90);
        AlgoritmosListas.insertarAlFinal(miLista, 70);

        AlgoritmosListas.imprimirLista(miLista);
    }

}
