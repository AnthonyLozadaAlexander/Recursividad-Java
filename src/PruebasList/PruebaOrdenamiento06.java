package PruebasList;

import Algoritmos.Ordenacion;
import AlgoritmosListas.AlgoritmosListas;
import List.Lista;
import List.TadLista;

/**
 * EJERCICIO 6 — Fusionar dos listas ORDENADAS (Merge)
 * ─────────────────────────────────────────────────────
 * CONCEPTO: dado que ambas listas YA están ordenadas, no necesitamos
 * volver a ordenar. Solo comparamos las "cabezas" de ambas listas
 * y tomamos siempre el menor.
 *
 * ALGORITMO MERGE (base del MergeSort):
 *   mientras lista1 no vacía Y lista2 no vacía:
 *       si cabeza(lista1) <= cabeza(lista2):
 *           agregar cabeza(lista1) a resultado
 *           avanzar lista1
 *       si no:
 *           agregar cabeza(lista2) a resultado
 *           avanzar lista2
 *   agregar resto de la lista que quede con elementos
 *
 * PARA EL EXAMEN: este patrón "dos punteros comparando cabezas"
 * es fundamental en algoritmos de listas ordenadas.
 */
public class PruebaOrdenamiento06 {

    public static void main(String[] args) {

        // ── CREAR Y LLENAR LISTA 1 ────────────────────────────────────────────
        TadLista<Integer> lista1 = new TadLista<>("lista1");
        int[] datos1 = {7, 3, 20, 12};  // datos desordenados
        for (int d : datos1) AlgoritmosListas.insertarAlFinal(lista1, d);

        // ── CREAR Y LLENAR LISTA 2 ────────────────────────────────────────────
        TadLista<Integer> lista2 = new TadLista<>("lista2");
        int[] datos2 = {25, 1, 9, 5, 15};  // datos desordenados
        for (int d : datos2) AlgoritmosListas.insertarAlFinal(lista2, d);

        // ── ORDENAR AMBAS LISTAS (prerequisito del merge) ─────────────────────
        ordenarLista(lista1);
        ordenarLista(lista2);

        System.out.println("Lista 1 ordenada:");
        AlgoritmosListas.imprimirLista(lista1);   // [3], [7], [12], [20]

        System.out.println("Lista 2 ordenada:");
        AlgoritmosListas.imprimirLista(lista2);   // [1], [5], [9], [15], [25]
        System.out.println();

        // ── FUSIONAR ─────────────────────────────────────────────────────────
        TadLista<Integer> resultado = new TadLista<>("resultado");
        fusionar(lista1, lista2, resultado);

        System.out.println("=== Lista fusionada ===");
        AlgoritmosListas.imprimirLista(resultado);
        // Esperado: [1], [3], [5], [7], [9], [12], [15], [20], [25]
    }

    /**
     * FUSIONAR dos listas ordenadas en una lista resultado ordenada
     * ──────────────────────────────────────────────────────────────
     * TRUCO: usamos dos "punteros" auxiliares (aux1, aux2) para leer
     * las listas sin destruirlas.
     */
    public static <T extends Comparable<T>> void fusionar(
            Lista<T> lista1, Lista<T> lista2, Lista<T> resultado) {

        // Crear punteros auxiliares apuntando al inicio de cada lista
        TadLista<T> aux1 = new TadLista<>();
        aux1.asignarReferencia(lista1.devolverReferencia()); // aux1 → primer nodo de lista1

        TadLista<T> aux2 = new TadLista<>();
        aux2.asignarReferencia(lista2.devolverReferencia()); // aux2 → primer nodo de lista2

        // ── FASE 1: comparar cabezas mientras ambas tengan elementos ─────────
        while (!aux1.esNulo() && !aux2.esNulo()) {
            T val1 = aux1.devolverClave(); // cabeza de lista1
            T val2 = aux2.devolverClave(); // cabeza de lista2

            if (val1.compareTo(val2) <= 0) {
                // val1 es menor o igual → va primero en resultado
                AlgoritmosListas.insertarAlFinal(resultado, val1);
                aux1.asignarReferencia(aux1.devolverSiguiente()); // avanzar lista1
            } else {
                // val2 es menor → va primero en resultado
                AlgoritmosListas.insertarAlFinal(resultado, val2);
                aux2.asignarReferencia(aux2.devolverSiguiente()); // avanzar lista2
            }
        }

        // ── FASE 2: vaciar lo que quede de lista1 (si sobró algo) ────────────
        // Una lista terminó antes; la otra puede tener elementos restantes
        while (!aux1.esNulo()) {
            AlgoritmosListas.insertarAlFinal(resultado, aux1.devolverClave());
            aux1.asignarReferencia(aux1.devolverSiguiente());
        }

        // ── FASE 3: vaciar lo que quede de lista2 (si sobró algo) ────────────
        while (!aux2.esNulo()) {
            AlgoritmosListas.insertarAlFinal(resultado, aux2.devolverClave());
            aux2.asignarReferencia(aux2.devolverSiguiente());
        }
    }

    /**
     * MÉTODO AUXILIAR: ordena una TadLista<Integer> usando el patrón
     * Lista→Arreglo → Ordenacion.insercion → Arreglo→Lista
     * (patrón base aprendido en Ejercicio 1)
     */
    private static void ordenarLista(TadLista<Integer> lista) {
        int n = AlgoritmosListas.contar(lista);
        Integer[] arreglo = new Integer[n];

        // Lista → Arreglo
        TadLista<Integer> aux = new TadLista<>();
        aux.asignarReferencia(lista.devolverReferencia());
        for (int i = 0; i < n; i++) {
            arreglo[i] = aux.devolverClave();
            aux.asignarReferencia(aux.devolverSiguiente());
        }

        // Ordenar
        Ordenacion.insercion(arreglo);

        // Vaciar y reconstruir
        for (int i = 0; i < n; i++) AlgoritmosListas.eliminarPrimero(lista);
        for (int i = 0; i < n; i++) AlgoritmosListas.insertarAlFinal(lista, arreglo[i]);
    }
}
