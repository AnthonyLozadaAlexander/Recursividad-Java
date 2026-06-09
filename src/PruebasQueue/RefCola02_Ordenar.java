package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO COLA 2 — Ordenar una Cola con BubbleSort
 *                    VERSIÓN 100% RECURSIVA (sin for ni while)
 * ═══════════════════════════════════════════════════════════════════
 *
 * PATRÓN COLA → ARREGLO RECURSIVO:
 *   void colaAArregloR(Cola<T> cola, T[] arr, int i) {
 *       if (i >= arr.length) return;       ← caso base: llenamos todo
 *       arr[i] = cola.desencolar();        ← sacar del frente al arreglo
 *       colaAArregloR(cola, arr, i + 1);   ← siguiente posición
 *   }
 *   → La cola queda VACÍA al terminar
 *
 * PATRÓN ARREGLO → COLA RECURSIVO:
 *   void arregloAColaR(Cola<T> cola, T[] arr, int i) {
 *       if (i >= arr.length) return;       ← caso base
 *       cola.encolar(arr[i]);              ← encolar elemento
 *       arregloAColaR(cola, arr, i + 1);   ← siguiente
 *   }
 *
 * BUBBLESORT DOBLE RECURSIVO (sin ningún for/while):
 *   bubbleSortR(v, i, j):
 *     i = pasada exterior, j = comparación interior
 *     → mismo patrón que el Ejercicio 5 de Listas
 */
public class RefCola02_Ordenar {

    public static void main(String[] args) throws ColaVacia {

        // ── 1. CREAR Y LLENAR LA COLA (recursivo) ─────────────────────────────
        TadCola<Integer> cola = new TadCola<>("cola_numeros");
        Integer[] valoresInit = {42, 15, 8, 73, 27, 5, 61};
        encolarArregloR(cola, valoresInit, 0);
        // FRENTE [42 → 15 → 8 → 73 → 27 → 5 → 61] FINAL

        System.out.println("=== Cola original ===");
        cola.imprimirCola();
        System.out.println();

        // ── 2. COLA → ARREGLO (recursivo, vacía la cola) ──────────────────────
        int n = cola.numElemCola();         // contar ANTES de desencolar
        Integer[] arreglo = new Integer[n];
        colaAArregloR(cola, arreglo, 0);    // cola queda vacía
        // arreglo: [42, 15, 8, 73, 27, 5, 61]

        // ── 3. BUBBLESORT DOBLE RECURSIVO ─────────────────────────────────────
        // bubbleSortR(arreglo, i=0, j=0): i=pasada, j=comparación
        bubbleSortR(arreglo, 0, 0);
        // arreglo: [5, 8, 15, 27, 42, 61, 73]

        // ── 4. ARREGLO → COLA ASCENDENTE (recursivo) ──────────────────────────
        arregloAColaR(cola, arreglo, 0);

        System.out.println("=== Cola ordenada ASCENDENTE ===");
        cola.imprimirCola();
        // FRENTE [5, 8, 15, 27, 42, 61, 73] FINAL
        System.out.println();

        // ── BONUS: orden DESCENDENTE ──────────────────────────────────────────
        // Vaciar y reencolar desde el FINAL del arreglo
        vaciarColaR(cola);
        arregloAColaDescR(cola, arreglo, arreglo.length - 1);

        System.out.println("=== Cola ordenada DESCENDENTE ===");
        cola.imprimirCola();
        // FRENTE [73, 61, 42, 27, 15, 8, 5] FINAL
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MÉTODOS RECURSIVOS
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * Encolar todos los elementos de un arreglo genérico (recursivo)
     * CASO BASE : i >= arr.length
     * CASO REC. : encolar arr[i] → i+1
     */
    public static <T> void encolarArregloR(TadCola<T> cola, T[] arr, int i) {
        if (i >= arr.length) return;
        cola.encolar(arr[i]);
        encolarArregloR(cola, arr, i + 1);
    }

    /**
     * Cola → Arreglo (recursivo) — la cola queda VACÍA
     * CASO BASE : i >= arr.length (llenamos todo el arreglo)
     * CASO REC. : arr[i] = desencolar() → i+1
     */
    public static <T> void colaAArregloR(TadCola<T> cola, T[] arr, int i) throws ColaVacia {
        if (i >= arr.length) return;        // caso base
        arr[i] = cola.desencolar();         // sacar del frente → posición i
        colaAArregloR(cola, arr, i + 1);    // siguiente posición
    }

    /**
     * Arreglo → Cola ASCENDENTE (recursivo, desde i=0)
     * arreglo[0] queda al FRENTE, arreglo[n-1] al FINAL
     */
    public static <T> void arregloAColaR(TadCola<T> cola, T[] arr, int i) {
        if (i >= arr.length) return;
        cola.encolar(arr[i]);
        arregloAColaR(cola, arr, i + 1);
    }

    /**
     * Arreglo → Cola DESCENDENTE (recursivo, desde i=n-1 hasta 0)
     * arreglo[n-1] queda al FRENTE (menor va al final en orden desc)
     */
    public static <T> void arregloAColaDescR(TadCola<T> cola, T[] arr, int i) {
        if (i < 0) return;
        cola.encolar(arr[i]);
        arregloAColaDescR(cola, arr, i - 1);
    }

    /**
     * Vaciar cola recursivamente
     */
    public static <T> void vaciarColaR(TadCola<T> cola) throws ColaVacia {
        if (cola.colaVacia()) return;
        cola.desencolar();
        vaciarColaR(cola);
    }

    /**
     * BubbleSort DOBLE RECURSIVO (sin for, sin while)
     * ─────────────────────────────────────────────────
     * PARÁMETROS:
     *   i → pasada actual   (equivale al for externo)
     *   j → comparación actual (equivale al for interno)
     *
     * CASOS BASE:
     *   1) i >= v.length - 1 → terminamos todas las pasadas
     *   2) j >= v.length - 1 - i → terminamos la pasada i, pasar a i+1
     *
     * CASO RECURSIVO:
     *   Comparar v[j] con v[j+1], intercambiar si hace falta,
     *   luego llamar bubbleSortR(v, i, j+1)
     */
    public static <T extends Comparable<T>> void bubbleSortR(T[] v, int i, int j) {
        // CASO BASE 1: completamos todas las pasadas
        if (i >= v.length - 1) return;

        // CASO BASE 2: terminamos la pasada i → iniciar pasada i+1
        if (j >= v.length - 1 - i) {
            bubbleSortR(v, i + 1, 0);
            return;
        }

        // CASO RECURSIVO: comparar e intercambiar adyacentes
        if (v[j].compareTo(v[j + 1]) > 0) {
            T temp    = v[j];
            v[j]      = v[j + 1];
            v[j + 1]  = temp;
        }

        // Avanzar j dentro de la misma pasada
        bubbleSortR(v, i, j + 1);
    }
}
