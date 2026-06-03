package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;
import AlgoritmosQueue.AlgoritmoCola;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO COLA 2 — Ordenar una Cola con BubbleSort
 * ═══════════════════════════════════════════════════════════════════
 *
 * PROBLEMA: TadCola NO tiene método de ordenamiento propio.
 * SOLUCIÓN: Cola → Arreglo → Ordenar → reconstruir Cola
 *
 * PATRÓN COLA → ARREGLO (equivalente al patrón Lista → Arreglo):
 *   int n = cola.numElemCola();
 *   T[] arreglo = new T[n];
 *   for (int i = 0; i < n; i++) {
 *       arreglo[i] = cola.desencolar();   // sacar del frente y guardar
 *   }
 *   // La cola queda VACÍA después de esto
 *   // Ahora ordenamos el arreglo
 *   // Después reconstruimos la cola desde el arreglo
 *
 * DIFERENCIA CON LISTA:
 *   Lista:  usábamos aux.devolverClave() + aux.asignarReferencia(siguiente) sin destruir
 *   Cola:   desencolar DESTRUYE el elemento del frente → la cola queda vacía
 *           por eso reconstruimos al final con encolar desde el arreglo ordenado
 */
public class RefCola02_Ordenar {

    public static void main(String[] args) throws ColaVacia {

        // ── 1. CREAR Y LLENAR LA COLA ─────────────────────────────────────────
        // FRENTE [42 → 15 → 8 → 73 → 27 → 5 → 61] FINAL
        TadCola<Integer> cola = new TadCola<>("cola_numeros");
        cola.encolar(42);
        cola.encolar(15);
        cola.encolar(8);
        cola.encolar(73);
        cola.encolar(27);
        cola.encolar(5);
        cola.encolar(61);

        System.out.println("=== Cola original ===");
        cola.imprimirCola();
        System.out.println();

        // ── 2. COLA → ARREGLO (vacía la cola) ────────────────────────────────
        int n = cola.numElemCola();    // contar ANTES de desencolar
        Integer[] arreglo = new Integer[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = cola.desencolar(); // desencolar llena el arreglo en orden FIFO
            // arreglo[0]=42, arreglo[1]=15, arreglo[2]=8 ... (orden original)
        }
        // COLA QUEDA VACÍA aquí

        // ── 3. BUBBLE SORT SOBRE EL ARREGLO ──────────────────────────────────
        // Implementamos bubbleSort manualmente (misma estructura que Ej.3 de Lista)
        bubbleSortArreglo(arreglo);
        // arreglo: [5, 8, 15, 27, 42, 61, 73]

        // ── 4. ARREGLO → COLA (reconstruir ordenada) ─────────────────────────
        // encolar desde índice 0 → el menor queda al frente (FIFO)
        for (int i = 0; i < n; i++) {
            cola.encolar(arreglo[i]);
        }

        System.out.println("=== Cola ordenada (BubbleSort) ===");
        cola.imprimirCola();
        // Frente → [5, 8, 15, 27, 42, 61, 73] ← Final
        System.out.println();

        // ── BONUS: ordenar DESCENDENTE ────────────────────────────────────────
        // En el arreglo ordenado ascendente, lo encolar al revés
        cola.eliminarCola();  // vaciar
        for (int i = n - 1; i >= 0; i--) {  // desde el último índice
            cola.encolar(arreglo[i]);
        }
        System.out.println("=== Cola ordenada DESCENDENTE ===");
        cola.imprimirCola();
        // Frente → [73, 61, 42, 27, 15, 8, 5] ← Final
    }

    /**
     * BubbleSort sobre arreglo Integer[] (estructura base para examen)
     * ──────────────────────────────────────────────────────────────────
     * ESTRUCTURA A MEMORIZAR:
     *   for i (pasadas) → for j (comparaciones) → if mayor→intercambiar
     */
    private static void bubbleSortArreglo(Integer[] v) {
        boolean ordenado;
        for (int i = 0; i < v.length; i++) {
            ordenado = true;
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    // intercambio
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    ordenado = false;
                }
            }
            if (ordenado) break; // optimización: ya ordenado
        }
    }
}
