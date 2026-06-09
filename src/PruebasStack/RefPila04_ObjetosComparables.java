package PruebasStack;

import Stack.PilaVacia;
import Stack.TadPila;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO PILA 4 — Pila de Objetos (Comparable) + InsertionSort
 *                    VERSIÓN 100% RECURSIVA (sin for ni while)
 *
 * ┌──────────────────────────────────────────────────────────────────┐
 * │           TABLA COMPARATIVA: PILA vs COLA (para examen)          │
 * ├──────────────┬───────────────────────┬───────────────────────────┤
 * │ Característica│     PILA (Stack)      │      COLA (Queue)         │
 * ├──────────────┼───────────────────────┼───────────────────────────┤
 * │ Orden        │ LIFO (último-primero) │ FIFO (primero-primero)    │
 * │ Agregar      │ apilar → CIMA         │ encolar → FINAL           │
 * │ Extraer      │ desapilar ← CIMA      │ desencolar ← FRENTE       │
 * │ Ver sin sac. │ cima()                │ primero()                 │
 * │ ¿Vacía?      │ pilaVacia()           │ colaVacia()               │
 * │ Tamaño       │ getTamanio()          │ numElemCola()             │
 * ├──────────────┼───────────────────────┼───────────────────────────┤
 * │ Patrón rec.  │ desapilar→rec→apilar  │ desencolar→rec→encolar    │
 * │ Sin límite   │ queda IGUAL (IDA/VTA) │ queda INVERTIDA           │
 * │ Con límite N │ queda IGUAL           │ queda IGUAL               │
 * ├──────────────┼───────────────────────┼───────────────────────────┤
 * │ a Arreglo    │ arr[0] = CIMA         │ arr[0] = FRENTE           │
 * │ Reconstruir  │ apilar i=0..n-1       │ encolar i=0..n-1          │
 * │              │ → arr[n-1] = CIMA     │ → arr[0] = FRENTE         │
 * └──────────────┴───────────────────────┴───────────────────────────┘
 * ═══════════════════════════════════════════════════════════════════
 */
public class RefPila04_ObjetosComparables {

    // ── CLASE INTERNA: Tarea ─────────────────────────────────────────────────
    static class Tarea implements Comparable<Tarea> {
        String descripcion;
        int urgencia;  // 1 = menos urgente, 10 = más urgente

        public Tarea(String descripcion, int urgencia) {
            this.descripcion = descripcion;
            this.urgencia    = urgencia;
        }

        @Override
        public int compareTo(Tarea otra) {
            return Integer.compare(this.urgencia, otra.urgencia);
            // Ascendente: menor urgencia en índice 0
            // Al apilar i=0..n-1 → mayor urgencia queda en la CIMA ✓
        }

        @Override
        public String toString() {
            return "[" + descripcion + " U:" + urgencia + "]";
        }
    }

    public static void main(String[] args) throws PilaVacia {

        // ── 1. CREAR Y LLENAR LA PILA (recursivo) ─────────────────────────────
        TadPila<Tarea> pila = new TadPila<>("tareas");
        Tarea[] tareas = {
            new Tarea("Revisar email",     3),
            new Tarea("Bug crítico prod",  9),
            new Tarea("Reunión equipo",    5),
            new Tarea("Actualizar docs",   1),
            new Tarea("Deploy hotfix",    10),
            new Tarea("Code review",       4)
        };
        apilarArregloR(pila, tareas, 0);   // sin for

        System.out.println("=== Pila de llegada (cima → base) ===");
        pila.imprimirPila();
        System.out.println();

        // ── 2. PILA → ARREGLO (recursivo) ────────────────────────────────────
        int n = pila.getTamanio();
        Tarea[] arreglo = new Tarea[n];
        pilaAArregloR(pila, arreglo, 0);   // pila queda vacía

        // ── 3. INSERTIONSORT DOBLE RECURSIVO ─────────────────────────────────
        insercionR(arreglo, 1);
        // arreglo: [docs(1), email(3), codeReview(4), reunion(5), bug(9), deploy(10)]

        // ── 4. ARREGLO → PILA (recursivo) ────────────────────────────────────
        // Apilar i=0..n-1 → arreglo[n-1] (deploy, U:10) queda en CIMA
        apilarArregloR(pila, arreglo, 0);

        System.out.println("=== Pila ordenada (CIMA = más urgente) ===");
        pila.imprimirPila();
        System.out.println("Próxima tarea: " + pila.cima());
        System.out.println();

        // ── 5. EJECUTAR TAREAS (recursivo) ────────────────────────────────────
        System.out.println("=== Ejecutando tareas por urgencia ===");
        ejecutarTareasR(pila, 1);
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MÉTODOS RECURSIVOS
    // ══════════════════════════════════════════════════════════════════════════

    /** Apilar arreglo genérico (arr[0]=BASE, arr[n-1]=CIMA) */
    public static <T> void apilarArregloR(TadPila<T> pila, T[] arr, int i) {
        if (i >= arr.length) return;
        pila.apilar(arr[i]);
        apilarArregloR(pila, arr, i + 1);
    }

    /** Pila → Arreglo (arr[0]=CIMA original), pila queda vacía */
    public static <T> void pilaAArregloR(TadPila<T> pila, T[] arr, int i) throws PilaVacia {
        if (i >= arr.length) return;
        arr[i] = pila.desapilar();
        pilaAArregloR(pila, arr, i + 1);
    }

    /**
     * InsertionSort — loop externo recursivo (i = 1 .. n-1)
     * CASO BASE : i >= v.length
     * CASO REC. : insertar v[i] en posición correcta + insercionR(v, i+1)
     */
    public static <T extends Comparable<T>> void insercionR(T[] v, int i) {
        if (i >= v.length) return;
        T clave = v[i];
        desplazarR(v, i, clave);      // encontrar posición correcta e insertar
        insercionR(v, i + 1);         // siguiente elemento
    }

    /**
     * InsertionSort — loop interno recursivo (retroceder mientras v[j-1] > clave)
     * CASO BASE : j <= 0 O v[j-1] <= clave → insertar clave en v[j]
     * CASO REC. : desplazar v[j-1] → v[j] y retroceder j
     */
    private static <T extends Comparable<T>> void desplazarR(T[] v, int j, T clave) {
        if (j > 0 && v[j - 1].compareTo(clave) > 0) {
            v[j] = v[j - 1];
            desplazarR(v, j - 1, clave);
        } else {
            v[j] = clave;              // insertar en su posición correcta
        }
    }

    /**
     * Ejecutar tareas desapilando recursivamente
     * CASO BASE : pila vacía → fin
     * CASO REC. : desapilar + imprimir + ejecutar siguiente
     */
    public static void ejecutarTareasR(TadPila<Tarea> pila,
                                       int orden) throws PilaVacia {
        if (pila.pilaVacia()) return;
        Tarea t = pila.desapilar();
        System.out.printf("%d. [Urgencia %2d] %s%n",
                          orden, t.urgencia, t.descripcion);
        ejecutarTareasR(pila, orden + 1);
    }
}
