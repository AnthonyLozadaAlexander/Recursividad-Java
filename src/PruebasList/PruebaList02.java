package PruebasList;

import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

public class PruebaList02 {
    public static void main(String[] args) {
        TadLista<Integer> miLista = new TadLista<>();
        AlgoritmosListas.insertarAlFinal(miLista, 1);
        AlgoritmosListas.insertarAlFinal(miLista, 2);
        AlgoritmosListas.insertarAlFinal(miLista, 3);
        AlgoritmosListas.insertarAlFinal(miLista, 4);
        miLista.imprimirLista();

        int total = AlgoritmosListas.sumar(miLista);
        System.out.print("La suma total de la lista es de: " + total);
    }
}
