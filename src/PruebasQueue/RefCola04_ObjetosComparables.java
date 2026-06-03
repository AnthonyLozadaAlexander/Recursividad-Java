package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;
import Algoritmos.Ordenacion;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO COLA 4 — Cola de Objetos (Comparable) + BubbleSort
 * ═══════════════════════════════════════════════════════════════════
 *
 * CONCEPTO: ordenar una cola de objetos propios.
 * REQUISITO: el objeto DEBE implementar Comparable<T>.
 *
 * PATRÓN COMPLETO (igual que en listas, pero con cola):
 *   1. Encolar objetos
 *   2. Cola → Objeto[] (desencolar en loop)
 *   3. Ordenacion.bubbleSort(arreglo)  ← usa compareTo del objeto
 *   4. Objeto[] → Cola (encolar en orden)
 *
 * CASO DE USO: cola de atención en hospital, ordenada por prioridad
 */
public class RefCola04_ObjetosComparables {

    // ── CLASE INTERNA: Paciente ──────────────────────────────────────────────
    // Implementa Comparable para poder usar Ordenacion.bubbleSort
    static class Paciente implements Comparable<Paciente> {
        private String nombre;
        private int prioridad; // 1 = más urgente, 10 = menos urgente

        public Paciente(String nombre, int prioridad) {
            this.nombre    = nombre;
            this.prioridad = prioridad;
        }

        // compareTo: orden ASCENDENTE por prioridad (1 va primero → más urgente)
        @Override
        public int compareTo(Paciente otro) {
            return Integer.compare(this.prioridad, otro.prioridad);
        }

        @Override
        public String toString() {
            return "[" + nombre + " P:" + prioridad + "]";
        }
    }

    public static void main(String[] args) throws ColaVacia {

        // ── 1. CREAR LA COLA DE PACIENTES ────────────────────────────────────
        TadCola<Paciente> colaPacientes = new TadCola<>("hospital");

        // Pacientes llegan en desorden de prioridad
        colaPacientes.encolar(new Paciente("Carlos",  7));
        colaPacientes.encolar(new Paciente("Ana",     2));
        colaPacientes.encolar(new Paciente("Pedro",   9));
        colaPacientes.encolar(new Paciente("Maria",   1));  // más urgente
        colaPacientes.encolar(new Paciente("Jorge",   5));
        colaPacientes.encolar(new Paciente("Sofia",   3));

        System.out.println("=== Cola de llegada (sin ordenar) ===");
        colaPacientes.imprimirCola();
        System.out.println();

        // ── 2. COLA → ARREGLO ────────────────────────────────────────────────
        int n = colaPacientes.numElemCola();
        Paciente[] arreglo = new Paciente[n];

        for (int i = 0; i < n; i++) {
            arreglo[i] = colaPacientes.desencolar(); // vacía la cola
        }

        // ── 3. BUBBLE SORT SOBRE ARREGLO DE OBJETOS ──────────────────────────
        // Ordenacion.bubbleSort usa compareTo de Paciente
        // → orden ascendente por prioridad (1=más urgente al frente)
        Ordenacion.bubbleSort(arreglo);

        // ── 4. ARREGLO → COLA ────────────────────────────────────────────────
        for (int i = 0; i < n; i++) {
            colaPacientes.encolar(arreglo[i]);
        }

        System.out.println("=== Cola ordenada por PRIORIDAD (más urgente al frente) ===");
        colaPacientes.imprimirCola();
        System.out.println();

        // ── 5. ATENDER PACIENTES (desencolar en orden) ────────────────────────
        System.out.println("=== Orden de atención ===");
        int turno = 1;
        while (!colaPacientes.colaVacia()) {
            Paciente p = colaPacientes.desencolar();
            System.out.printf("Turno %d: %s (prioridad %d)%n",
                              turno++, p.nombre, p.prioridad);
        }
    }
}
