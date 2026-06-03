package PruebasList;

import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

public class PruebaList06 {
    public static void main(String[] args) {
        boolean resul = false;
        TadLista<String> miLista = new TadLista<>();
        AlgoritmosListas.insertarAlFinal(miLista, "Ana");
        AlgoritmosListas.insertarAlFinal(miLista, "Luis");
        AlgoritmosListas.insertarAlFinal(miLista, "Mia");
        miLista.imprimirLista();

        resul = AlgoritmosListas.contiene(miLista, "Ana");
        System.out.println(resul ? "Elemento Existente: " + resul : "No Encontrado");


    }
}
