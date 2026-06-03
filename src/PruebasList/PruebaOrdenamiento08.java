package PruebasList;

import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

/**
 * EJERCICIO 8 — BubbleSort sobre NODOS: detectar lista ya ordenada
 * ──────────────────────────────────────────────────────────────────
 * CONCEPTO: BubbleSort sobre nodos SIN convertir a arreglo.
 *   → Intercambiamos claves (valores) entre nodos adyacentes.
 *   → Retorna true si la lista ya estaba ordenada (cero intercambios).
 *
 * OPTIMIZACIÓN DEL BUBBLESORT:
 *   - Flag `yaOrdenado` = true al inicio de cada pasada
 *   - Si hay algún intercambio → yaOrdenado = false
 *   - Si una pasada completa sin intercambios → ya terminamos (break)
 *   - Esto reduce de O(n²) a O(n) en el mejor caso (lista ya ordenada)
 *
 * PARA EL EXAMEN:
 *   - Si ves "detectar si una lista está ordenada" → piensa en este flag
 *   - La primera pasada sin intercambios = lista ordenada
 */
public class PruebaOrdenamiento08 {

    public static void main(String[] args) {

        // ── CASO A: lista DESORDENADA ──────────────────────────────────────
        TadLista<Integer> casoA = new TadLista<>("casoA");
        AlgoritmosListas.insertarAlFinal(casoA, 5);
        AlgoritmosListas.insertarAlFinal(casoA, 1);
        AlgoritmosListas.insertarAlFinal(casoA, 4);
        AlgoritmosListas.insertarAlFinal(casoA, 2);
        AlgoritmosListas.insertarAlFinal(casoA, 8);

        System.out.println("=== CASO A ===");
        System.out.print("Antes: ");
        AlgoritmosListas.imprimirLista(casoA);

        boolean estabaOrdenadaA = bubbleSortLista(casoA);

        System.out.print("Después: ");
        AlgoritmosListas.imprimirLista(casoA);
        System.out.println("¿Ya estaba ordenada? " + estabaOrdenadaA);
        // Esperado: false  →  lista final: [1, 2, 4, 5, 8]
        System.out.println();

        // ── CASO B: lista YA ORDENADA ──────────────────────────────────────
        TadLista<Integer> casoB = new TadLista<>("casoB");
        AlgoritmosListas.insertarAlFinal(casoB, 1);
        AlgoritmosListas.insertarAlFinal(casoB, 2);
        AlgoritmosListas.insertarAlFinal(casoB, 3);
        AlgoritmosListas.insertarAlFinal(casoB, 4);
        AlgoritmosListas.insertarAlFinal(casoB, 5);

        System.out.println("=== CASO B ===");
        System.out.print("Antes: ");
        AlgoritmosListas.imprimirLista(casoB);

        boolean estabaOrdenadaB = bubbleSortLista(casoB);

        System.out.print("Después: ");
        AlgoritmosListas.imprimirLista(casoB);
        System.out.println("¿Ya estaba ordenada? " + estabaOrdenadaB);
        // Esperado: true  →  lista sin cambios
    }

    /**
     * BubbleSort intercambiando CLAVES en los nodos (sin arreglo auxiliar)
     * ──────────────────────────────────────────────────────────────────────
     * RETORNA:
     *   true  → la lista YA estaba ordenada (cero intercambios en primera pasada)
     *   false → se realizó al menos un intercambio
     *
     * ESTRUCTURA (equivalente al bubbleSort de Ordenacion.java pero sobre nodos):
     *   pasada exterior: while (hubo cambios)   ← equivale al for i
     *   pasada interior: recorrer nodos adyacentes ← equivale al for j
     */
    public static <T extends Comparable<T>> boolean bubbleSortLista(TadLista<T> lista) {

        if (lista.esNulo()) return true; // lista vacía → considerada ordenada

        boolean yaOrdenada = true;    // resultado final: ¿estaba ordenada desde el inicio?
        boolean huboIntercambio;      // flag para cada pasada

        // ── PASADA EXTERIOR (equivale al for i de bubbleSort) ────────────────
        // Se repite mientras en la última pasada hubo al menos un intercambio
        do {
            huboIntercambio = false; // asumimos que esta pasada no tendrá intercambios

            // Puntero que recorre los nodos uno a uno
            TadLista<T> actual = new TadLista<>();
            actual.asignarReferencia(lista.devolverReferencia()); // empieza en el primer nodo

            // ── PASADA INTERIOR: comparar nodo actual con su siguiente ────────
            while (!actual.esNulo() && actual.devolverSiguiente() != null) {

                // Crear puntero al siguiente nodo para comparar
                TadLista<T> siguiente = new TadLista<>();
                siguiente.asignarReferencia(actual.devolverSiguiente());

                // Si el nodo actual es MAYOR que el siguiente → intercambiar claves
                if (actual.devolverClave().compareTo(siguiente.devolverClave()) > 0) {

                    // INTERCAMBIO DE CLAVES (no de nodos, solo de valores)
                    T temp = actual.devolverClave();
                    actual.asignarClave(siguiente.devolverClave());
                    siguiente.asignarClave(temp);

                    huboIntercambio = true; // hubo al menos un intercambio en esta pasada
                    yaOrdenada = false;     // la lista NO estaba ordenada desde el inicio
                }

                // Avanzar al siguiente nodo
                actual.asignarReferencia(actual.devolverSiguiente());
            }

        } while (huboIntercambio); // si no hubo intercambios → lista ya ordenada → salir

        return yaOrdenada;
    }
}
