package PruebasStack;

import Stack.PilaVacia;
import Stack.TadPila;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO PILA 2 — Ordenar una Pila con InsertionSort
 * ═══════════════════════════════════════════════════════════════════
 *
 * PATRÓN PILA → ARREGLO:
 *   int n = pila.getTamanio();
 *   T[] arreglo = new T[n];
 *   for (int i = 0; i < n; i++) {
 *       arreglo[i] = pila.desapilar();  // sale desde la CIMA
 *   }
 *   // i=0 → cima (50), i=1 → 40, ... i=n-1 → base (10)
 *   // La pila queda VACÍA
 *
 * DIFERENCIA COLA vs PILA al convertir a arreglo:
 *   COLA: arreglo[0] = frente (el que entró primero = más pequeño si estaba ordenada)
 *   PILA: arreglo[0] = cima  (el que entró último)
 *   → El orden en el arreglo depende de cuál estructura usas
 *
 * RECONSTRUIR DESDE ARREGLO:
 *   Para que la pila quede con arreglo[0] en la BASE y arreglo[n-1] en la CIMA:
 *   → apilar desde índice 0 hasta n-1 (el último apilado queda en la cima)
 */
public class RefPila02_Ordenar {

    public static void main(String[] args) throws PilaVacia {

        // ── 1. CREAR Y LLENAR LA PILA ─────────────────────────────────────────
        // Orden de apilar: 42, 15, 8, 73, 27, 5, 61
        // Estado (cima arriba):
        //   [61] ← cima
        //   [ 5]
        //   [27]
        //   [73]
        //   [ 8]
        //   [15]
        //   [42] ← base
        TadPila<Integer> pila = new TadPila<>("pila_numeros");
        pila.apilar(42);
        pila.apilar(15);
        pila.apilar(8);
        pila.apilar(73);
        pila.apilar(27);
        pila.apilar(5);
        pila.apilar(61);

        System.out.println("=== Pila original (cima → base) ===");
        pila.imprimirPila();
        System.out.println("Cima: " + pila.cima());
        System.out.println();

        // ── 2. PILA → ARREGLO ────────────────────────────────────────────────
        int n = pila.getTamanio();      // contar ANTES de desapilar
        Integer[] arreglo = new Integer[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = pila.desapilar(); // sale desde la cima
            // arreglo[0]=61(cima), arreglo[1]=5, arreglo[2]=27...
        }
        // PILA QUEDA VACÍA

        // ── 3. INSERTION SORT SOBRE EL ARREGLO ───────────────────────────────
        insertionSortArreglo(arreglo);
        // arreglo: [5, 8, 15, 27, 42, 61, 73] → orden ascendente

        // ── 4. ARREGLO → PILA ────────────────────────────────────────────────
        // Queremos: cima = mayor (73), base = menor (5)
        // → apilar desde índice 0 (menor) hasta n-1 (mayor)
        // → el último apilado (arreglo[n-1] = 73) queda en la cima
        for (int i = 0; i < n; i++) {
            pila.apilar(arreglo[i]);
        }

        System.out.println("=== Pila ordenada, CIMA=mayor, BASE=menor ===");
        pila.imprimirPila();
        // Cima [73, 61, 42, 27, 15, 8, 5] Base
        System.out.println();

        // ── VARIANTE: cima = menor, base = mayor ─────────────────────────────
        pila.vaciarPila();
        for (int i = n - 1; i >= 0; i--) {  // apilar desde el mayor al menor
            pila.apilar(arreglo[i]);
        }
        System.out.println("=== Pila: CIMA=menor, BASE=mayor ===");
        pila.imprimirPila();
        // Cima [5, 8, 15, 27, 42, 61, 73] Base
    }

    /**
     * InsertionSort sobre arreglo Integer[] (estructura base para examen)
     * ──────────────────────────────────────────────────────────────────
     * ESTRUCTURA A MEMORIZAR:
     *   for i de 1 a n-1:           ← elemento a insertar
     *       aux = v[i]              ← guardar la "clave"
     *       j = i
     *       while j>0 y v[j-1]>aux: ← retroceder mientras haya elementos mayores
     *           v[j] = v[j-1]      ← desplazar hacia la derecha
     *           j--
     *       v[j] = aux             ← insertar en la posición correcta
     */
    private static void insertionSortArreglo(Integer[] v) {
        for (int i = 1; i < v.length; i++) {
            int aux = v[i];  // guardar la clave a insertar
            int j = i;

            // retroceder mientras haya elemento anterior mayor que la clave
            while (j > 0 && v[j - 1] > aux) {
                v[j] = v[j - 1];  // desplazar elemento mayor hacia la derecha
                j--;
            }
            v[j] = aux;  // insertar la clave en su posición correcta
        }
    }
}
