package PruebasList;

import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

public class PruebaList03 {
    public static void main(String[] args) {
        TadLista<String> miLista = new TadLista<>();
        AlgoritmosListas.insertarAlFinal(miLista, "Hola");
        AlgoritmosListas.insertarAlFinal(miLista, "Como estas?");
        AlgoritmosListas.insertarAlFinal(miLista, "Bien");
        miLista.imprimirLista();

        String ultimo = AlgoritmosListas.obtenerUltimo(miLista);
        System.out.print("El ultimo elemento de la lista: " + ultimo + "\n");
        miLista.imprimirLista();
    }
}
