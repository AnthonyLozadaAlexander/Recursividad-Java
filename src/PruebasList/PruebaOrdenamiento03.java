package PruebasList;

import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

/**
 * EJERCICIO 3 — Contar intercambios del BubbleSort
 * ─────────────────────────────────────────────────
 * CONCEPTO CLAVE — BubbleSort manual:
 *   - Pasada exterior i: de 0 hasta n-1
 *   - Pasada interior j: de 0 hasta n-2-i
 *     (porque los últimos i elementos ya están en su lugar)
 *   - Si vector[j] > vector[j+1] → intercambiar + contar
 *   - Optimización: si en una pasada no hubo intercambios → ya está ordenado
 *
 * PARA EL EXAMEN: si te piden "implementar bubbleSort desde cero",
 * usa exactamente esta estructura doble for + flag `ordenado`.
 */
public class PruebaOrdenamiento03 {

    public static void main(String[] args) {

        // ── 1. CREAR Y LLENAR LA LISTA ───────────────────────────────────────
        TadLista<Integer> numeros = new TadLista<>("numeros");
        AlgoritmosListas.insertarAlFinal(numeros, 9);
        AlgoritmosListas.insertarAlFinal(numeros, 3);
        AlgoritmosListas.insertarAlFinal(numeros, 7);
        AlgoritmosListas.insertarAlFinal(numeros, 1);
        AlgoritmosListas.insertarAlFinal(numeros, 5);

        // ── 2. LISTA → ARREGLO ───────────────────────────────────────────────
        int n = AlgoritmosListas.contar(numeros);
        Integer[] arreglo = new Integer[n];

        TadLista<Integer> aux = new TadLista<>();
        aux.asignarReferencia(numeros.devolverReferencia());

        for (int i = 0; i < n; i++) {
            arreglo[i] = aux.devolverClave();
            aux.asignarReferencia(aux.devolverSiguiente());
        }

        // ── 3. BUBBLE SORT CON CONTADOR ──────────────────────────────────────
        int totalIntercambios = bubbleSortContando(arreglo);

        // ── 4. IMPRIMIR RESULTADOS ───────────────────────────────────────────
        System.out.print("Arreglo ordenado: [");
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Intercambios realizados: " + totalIntercambios);
    }

    /**
     * BubbleSort con conteo de intercambios
     * ──────────────────────────────────────
     * ESTRUCTURA BASE del BubbleSort (memorizar para examen):
     *
     *   for i de 0 a n-1:               ← pasadas totales
     *       ordenado = true
     *       for j de 0 a n-2-i:         ← comparaciones por pasada
     *           if vector[j] > vector[j+1]:
     *               intercambiar(j, j+1)
     *               ordenado = false
     *       if ordenado: salir           ← optimización: ya no hay cambios
     *
     * @param vector arreglo a ordenar (se modifica in-place)
     * @return número total de intercambios realizados
     */
    public static int bubbleSortContando(Integer[] vector) {
        int swaps = 0;         // contador de intercambios
        boolean ordenado;      // flag para la optimización

        // PASADA EXTERIOR: i controla cuántos elementos ya están "fijos" al final
        for (int i = 0; i < vector.length; i++) {
            ordenado = true;   // asumimos que ya está ordenado hasta demostrar lo contrario

            // PASADA INTERIOR: j compara elementos adyacentes
            // vector.length - 1 - i  porque los últimos i ya están en su lugar
            for (int j = 0; j < vector.length - 1 - i; j++) {

                if (vector[j] > vector[j + 1]) {        // comparación: el mayor "burbujea"
                    // INTERCAMBIO manual (sin método auxiliar)
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;

                    swaps++;          // contamos el intercambio
                    ordenado = false; // hubo cambio → no estaba ordenado
                }
            }

            // OPTIMIZACIÓN: si en toda la pasada no hubo intercambios, terminamos
            if (ordenado) break; // equivale a i = vector.length en Ordenacion.java
        }

        return swaps;
    }
}
