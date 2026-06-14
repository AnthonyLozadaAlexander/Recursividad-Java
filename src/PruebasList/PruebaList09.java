package PruebasList;

import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

public class PruebaList09 {
    public static void main(String[] args) {
        TadLista<String> miLista = new TadLista<>();
        AlgoritmosListas.insertarAlFinal(miLista, "1");
        AlgoritmosListas.insertarAlFinal(miLista, "2");
        AlgoritmosListas.insertarAlFinal(miLista, "3");
        AlgoritmosListas.insertarAlFinal(miLista, "5");
        miLista.imprimirLista();

        System.out.println("Lista Despues: ");

        AlgoritmosListas.eliminarUltimo(miLista);
        miLista.imprimirLista();
    }
}
