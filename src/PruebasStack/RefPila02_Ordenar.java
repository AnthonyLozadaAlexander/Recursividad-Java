package PruebasStack;

import Stack.PilaVacia;
import Stack.TadPila;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO PILA 2 — Ordenar una Pila con InsertionSort
 *                    VERSIÓN 100% RECURSIVA (sin for ni while)
 * ═══════════════════════════════════════════════════════════════════
 *
 * PATRÓN PILA → ARREGLO RECURSIVO:
 *   void pilaAArregloR(Pila<T> pila, T[] arr, int i) {
 *       if (i >= arr.length) return;
 *       arr[i] = pila.desapilar();          ← i=0 recibe la CIMA
 *       pilaAArregloR(pila, arr, i + 1);
 *   }
 *   → La pila queda VACÍA al terminar
 *   → arreglo[0] = cima original
 *
 * PATRÓN ARREGLO → PILA RECURSIVO:
 *   Para que arreglo[0] quede en la BASE y arreglo[n-1] en la CIMA:
 *   void arregloAPilaR(Pila<T> pila, T[] arr, int i) {
 *       if (i >= arr.length) return;
 *       pila.apilar(arr[i]);                ← apilar arr[i]
 *       arregloAPilaR(pila, arr, i + 1);   ← el último apilado = CIMA
 *   }
 *
 * INSERTIONSORT DOBLE RECURSIVO:
 *   insercionR(v, i):       ← loop externo (pasada i=1..n-1)
 *   desplazarR(v, j, key):  ← loop interno (retroceder j mientras v[j-1]>key)
 */
public class RefPila02_Ordenar {

    public static void main(String[] args) throws PilaVacia {

        // ── 1. CREAR Y LLENAR LA PILA (recursivo) ─────────────────────────────
        // Apilar [42, 15, 8, 73, 27, 5, 61]
        // → cima = 61 (el último apilado)
        TadPila<Integer> pila = new TadPila<>("pila_numeros");
        Integer[] valoresInit = {42, 15, 8, 73, 27, 5, 61};
        apilarArregloR(pila, valoresInit, 0);

        System.out.println("=== Pila original (cima → base) ===");
        pila.imprimirPila();
        System.out.println("Cima: " + pila.cima());
        System.out.println();

        // ── 2. PILA → ARREGLO (recursivo, vacía la pila) ──────────────────────
        int n = pila.getTamanio();
        Integer[] arreglo = new Integer[n];
        pilaAArregloR(pila, arreglo, 0);
        // arreglo[0] = 61 (cima), arreglo[1] = 5, ... arreglo[6] = 42 (base)
        // Pila VACÍA

        // ── 3. INSERTION SORT DOBLE RECURSIVO ─────────────────────────────────
        insercionR(arreglo, 1);
        // arreglo: [5, 8, 15, 27, 42, 61, 73] → orden ascendente

        // ── 4. ARREGLO → PILA (recursivo, cima = mayor) ───────────────────────
        // apilar desde i=0 (menor=5) hasta i=n-1 (mayor=73)
        // → arreglo[n-1] = 73 queda en la CIMA
        apilarArregloR(pila, arreglo, 0);

        System.out.println("=== Pila ordenada (CIMA=mayor, BASE=menor) ===");
        pila.imprimirPila();
        System.out.println();

        // ── VARIANTE: CIMA = menor, BASE = mayor ──────────────────────────────
        // Apilar desde i=n-1 hasta i=0 (invertir el orden de apilado)
        vaciarPilaR(pila);
        apilarArregloDescR(pila, arreglo, arreglo.length - 1);

        System.out.println("=== Pila ordenada (CIMA=menor, BASE=mayor) ===");
        pila.imprimirPila();
        System.out.println("Cima (primero a atender): " + pila.cima()); // 5
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MÉTODOS RECURSIVOS
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * Apilar arreglo en orden ascendente de índice (recursivo)
     * arreglo[0] → BASE, arreglo[n-1] → CIMA
     */
    public static <T> void apilarArregloR(TadPila<T> pila, T[] arr, int i) {
        if (i >= arr.length) return;
        pila.apilar(arr[i]);
        apilarArregloR(pila, arr, i + 1);
    }

    /**
     * Apilar arreglo en orden DESCENDENTE de índice (recursivo)
     * arreglo[n-1] → BASE, arreglo[0] → CIMA
     */
    public static <T> void apilarArregloDescR(TadPila<T> pila, T[] arr, int i) {
        if (i < 0) return;
        pila.apilar(arr[i]);
        apilarArregloDescR(pila, arr, i - 1);
    }

    /**
     * Pila → Arreglo (recursivo) — la pila queda VACÍA
     * arreglo[0] = cima original, arreglo[n-1] = base original
     */
    public static <T> void pilaAArregloR(TadPila<T> pila, T[] arr, int i) throws PilaVacia {
        if (i >= arr.length) return;
        arr[i] = pila.desapilar();          // sacar de la cima → posición i
        pilaAArregloR(pila, arr, i + 1);
    }

    /**
     * Vaciar pila recursivamente
     */
    public static <T> void vaciarPilaR(TadPila<T> pila) throws PilaVacia {
        if (pila.pilaVacia()) return;
        pila.desapilar();
        vaciarPilaR(pila);
    }

    /**
     * InsertionSort — NIVEL EXTERNO recursivo (equivale al for i=1..n-1)
     * ──────────────────────────────────────────────────────────────────
     * CASO BASE : i >= v.length → ya insertamos todos los elementos
     * CASO REC. :
     *   1. Guardar v[i] como "clave"
     *   2. Llamar a desplazarR para buscar su posición correcta
     *   3. Llamar a insercionR(v, i+1) para el siguiente elemento
     */
    public static <T extends Comparable<T>> void insercionR(T[] v, int i) {
        if (i >= v.length) return;          // caso base: procesamos todo

        T clave = v[i];                     // guardar el elemento a insertar
        desplazarR(v, i, clave);            // encontrar posición e insertar
        insercionR(v, i + 1);               // siguiente elemento
    }

    /**
     * InsertionSort — NIVEL INTERNO recursivo (equivale al while j>0 && v[j-1]>clave)
     * ─────────────────────────────────────────────────────────────────────────
     * CASO BASE : j <= 0 O v[j-1] <= clave → insertar clave en v[j]
     * CASO REC. : v[j-1] > clave → desplazar v[j-1] a v[j] → retroceder j
     */
    private static <T extends Comparable<T>> void desplazarR(T[] v, int j, T clave) {
        if (j > 0 && v[j - 1].compareTo(clave) > 0) {
            v[j] = v[j - 1];               // desplazar elemento mayor a la derecha
            desplazarR(v, j - 1, clave);   // retroceder un paso más
        } else {
            v[j] = clave;                  // caso base: insertar clave en su lugar
        }
    }
}
