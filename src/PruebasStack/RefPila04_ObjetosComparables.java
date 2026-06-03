package PruebasStack;

import Stack.PilaVacia;
import Stack.TadPila;
import Algoritmos.Ordenacion;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO PILA 4 — Pila de Objetos (Comparable) + InsertionSort
 *                  + TABLA COMPARATIVA PILA vs COLA para examen
 * ═══════════════════════════════════════════════════════════════════
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
 * │ Vaciar       │ vaciarPila()          │ eliminarCola()            │
 * │ Imprimir     │ imprimirPila()        │ imprimirCola()            │
 * ├──────────────┼───────────────────────┼───────────────────────────┤
 * │ Patrón rec.  │ desapilar→rec→apilar  │ desencolar→rec→encolar    │
 * │ Tras recorr. │ queda IGUAL           │ queda IGUAL               │
 * ├──────────────┼───────────────────────┼───────────────────────────┤
 * │ a Arreglo    │ arreglo[0] = CIMA     │ arreglo[0] = FRENTE       │
 * │ desde Arreglo│ apilar i=0..n-1       │ encolar i=0..n-1          │
 * │              │ → arreglo[n-1] = CIMA │ → arreglo[0] = FRENTE     │
 * └──────────────┴───────────────────────┴───────────────────────────┘
 */
public class RefPila04_ObjetosComparables {

    // ── CLASE INTERNA: Tarea ─────────────────────────────────────────────────
    // Pila de tareas pendientes, ordenadas por urgencia
    static class Tarea implements Comparable<Tarea> {
        private String descripcion;
        private int urgencia;  // 1 = menos urgente, 10 = más urgente

        public Tarea(String descripcion, int urgencia) {
            this.descripcion = descripcion;
            this.urgencia    = urgencia;
        }

        // Orden DESCENDENTE: urgencia mayor → va primero en el arreglo
        // (para que quede en la CIMA al reconstruir la pila)
        @Override
        public int compareTo(Tarea otra) {
            return Integer.compare(this.urgencia, otra.urgencia);
            // Ascendente: el de menor urgencia al índice 0
            // Al apilar i=0..n-1 → el de MAYOR urgencia queda en la CIMA ✓
        }

        @Override
        public String toString() {
            return "[" + descripcion + " U:" + urgencia + "]";
        }
    }

    public static void main(String[] args) throws PilaVacia {

        // ── 1. CREAR LA PILA DE TAREAS ────────────────────────────────────────
        TadPila<Tarea> pilaTareas = new TadPila<>("tareas");

        // Tareas en orden de llegada (desordenadas por urgencia)
        pilaTareas.apilar(new Tarea("Revisar email",     3));
        pilaTareas.apilar(new Tarea("Bug crítico prod",  9));  // muy urgente
        pilaTareas.apilar(new Tarea("Reunión equipo",    5));
        pilaTareas.apilar(new Tarea("Actualizar docs",   1));  // poco urgente
        pilaTareas.apilar(new Tarea("Deploy hotfix",     10)); // urgentísimo
        pilaTareas.apilar(new Tarea("Code review",       4));

        System.out.println("=== Pila de tareas (orden de llegada, cima→base) ===");
        pilaTareas.imprimirPila();
        System.out.println();

        // ── 2. PILA → ARREGLO ────────────────────────────────────────────────
        int n = pilaTareas.getTamanio();
        Tarea[] arreglo = new Tarea[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = pilaTareas.desapilar(); // i=0 → cima (code review, U:4)
        }
        // arreglo: [codeReview(4), deploy(10), docs(1), reunion(5), bug(9), email(3)]
        // Pila VACÍA

        // ── 3. INSERTION SORT (ascendente por urgencia) ───────────────────────
        Ordenacion.insercion(arreglo);
        // arreglo ordenado: [docs(1), email(3), codeReview(4), reunion(5), bug(9), deploy(10)]
        // índice 0=menor urgencia, índice n-1=mayor urgencia

        // ── 4. ARREGLO → PILA ────────────────────────────────────────────────
        // Apilar de índice 0 a n-1
        // → el último en apilar (arreglo[n-1] = deploy, urgencia 10) queda en la CIMA
        // → CIMA = tarea más urgente ✓
        for (int i = 0; i < n; i++) {
            pilaTareas.apilar(arreglo[i]);
        }

        System.out.println("=== Pila ordenada (CIMA = más urgente) ===");
        pilaTareas.imprimirPila();
        System.out.println("Próxima tarea (cima): " + pilaTareas.cima());
        System.out.println();

        // ── 5. EJECUTAR TAREAS (desapilar en orden de urgencia) ───────────────
        System.out.println("=== Ejecutando tareas por urgencia ===");
        int orden = 1;
        while (!pilaTareas.pilaVacia()) {
            Tarea t = pilaTareas.desapilar();
            System.out.printf("%d. [Urgencia %2d] %s%n",
                              orden++, t.urgencia, t.descripcion);
        }
    }
}
