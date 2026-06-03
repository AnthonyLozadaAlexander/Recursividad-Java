package PruebasList;

import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

/**
 * EJERCICIO 5 — BubbleSort TOTALMENTE recursivo (sin for ni while)
 * ─────────────────────────────────────────────────────────────────
 * CONCEPTO: BubbleSort tiene DOS niveles de iteración:
 *   - Nivel externo: "pasadas" (i de 0 a n-1)
 *   - Nivel interno: "comparaciones dentro de la pasada" (j de 0 a n-2-i)
 *
 * En la versión recursiva de Ordenacion.java (bubbleSortR):
 *   → el nivel externo (pasadas) es recursivo
 *   → el nivel interno (j) sigue siendo un for
 *
 * En este ejercicio: AMBOS niveles son recursivos → bubbleSortDobleR(v, i, j)
 *
 * REGLA PARA CONVERTIR UN FOR EN RECURSIÓN:
 *   for (int i = inicio; i < limite; i++) { cuerpo }
 *   →  método(i):
 *        if (i >= limite) return;   ← caso base
 *        cuerpo
 *        método(i + 1);             ← avance recursivo
 */
public class PruebaOrdenamiento05 {

    public static void main(String[] args) {

        // ── DATOS DE PRUEBA ───────────────────────────────────────────────────
        Integer[] arreglo = {64, 25, 12, 22, 11};

        System.out.print("Antes:   ");
        imprimirArreglo(arreglo);

        // Llamada inicial: pasada 0, comparación 0
        // i=0 → primera pasada
        // j=0 → primera comparación dentro de la pasada
        bubbleSortDobleR(arreglo, 0, 0);

        System.out.print("Después: ");
        imprimirArreglo(arreglo);
    }

    /**
     * BubbleSort con DOBLE RECURSIÓN (sin ningún bucle)
     * ────────────────────────────────────────────────────────────────────
     * PARÁMETROS:
     *   v  → arreglo a ordenar
     *   i  → pasada actual  (equivale al for externo)
     *   j  → comparación actual dentro de la pasada (equivale al for interno)
     *
     * CASOS BASE:
     *   1) i >= v.length - 1  → ya completamos todas las pasadas, fin
     *   2) j >= v.length - 1 - i → terminamos la pasada actual,
     *                               iniciamos la siguiente (i+1, j=0)
     *
     * CASO RECURSIVO:
     *   - Comparar v[j] con v[j+1]
     *   - Intercambiar si v[j] > v[j+1]
     *   - Avanzar j en la misma pasada: llamar con (v, i, j+1)
     */
    public static <T extends Comparable<T>> void bubbleSortDobleR(T[] v, int i, int j) {

        // CASO BASE 1: ya hicimos todas las pasadas → lista ordenada
        if (i >= v.length - 1) {
            return; // condición de parada del nivel externo (pasadas)
        }

        // CASO BASE 2: terminamos la pasada i → pasar a la siguiente
        if (j >= v.length - 1 - i) {
            // Iniciamos pasada i+1 desde j=0
            bubbleSortDobleR(v, i + 1, 0);
            return;
        }

        // CASO RECURSIVO: comparar elementos adyacentes en la posición j
        if (v[j].compareTo(v[j + 1]) > 0) {
            // INTERCAMBIO: v[j] es mayor → debe ir después de v[j+1]
            T temp  = v[j];
            v[j]    = v[j + 1];
            v[j + 1] = temp;
        }

        // Avanzar al siguiente par de la misma pasada (j+1)
        bubbleSortDobleR(v, i, j + 1);
    }

    // ── MÉTODO AUXILIAR: imprimir arreglo ────────────────────────────────
    private static <T> void imprimirArreglo(T[] v) {
        System.out.print("[");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]);
            if (i < v.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
