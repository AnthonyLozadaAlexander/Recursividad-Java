package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;
import Algoritmos.Ordenacion;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO COLA 4 — Cola de Objetos (Comparable) + BubbleSort
 *                    VERSIÓN 100% RECURSIVA (sin for ni while)
 * ═══════════════════════════════════════════════════════════════════
 */
public class RefCola04_ObjetosComparables {

    // ── CLASE INTERNA: Paciente ──────────────────────────────────────────────
    static class Paciente implements Comparable<Paciente> {
        String nombre;
        int prioridad; // 1 = más urgente, 10 = menos urgente

        public Paciente(String nombre, int prioridad) {
            this.nombre    = nombre;
            this.prioridad = prioridad;
        }

        // compareTo ascendente: prioridad 1 va antes que prioridad 10
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

        // ── 1. CREAR Y LLENAR LA COLA (recursivo) ─────────────────────────────
        TadCola<Paciente> cola = new TadCola<>("hospital");
        Paciente[] pacientes = {
            new Paciente("Carlos",  7),
            new Paciente("Ana",     2),
            new Paciente("Pedro",   9),
            new Paciente("Maria",   1),
            new Paciente("Jorge",   5),
            new Paciente("Sofia",   3)
        };
        encolarArregloR(cola, pacientes, 0);  // sin for

        System.out.println("=== Cola de llegada (sin ordenar) ===");
        cola.imprimirCola();
        System.out.println();

        // ── 2. COLA → ARREGLO (recursivo) ────────────────────────────────────
        int n = cola.numElemCola();
        Paciente[] arreglo = new Paciente[n];
        colaAArregloR(cola, arreglo, 0);    // cola queda vacía

        // ── 3. BUBBLESORT DOBLE RECURSIVO ─────────────────────────────────────
        // Usa compareTo de Paciente → ordena por prioridad ascendente
        bubbleSortR(arreglo, 0, 0);

        // ── 4. ARREGLO → COLA (recursivo) ────────────────────────────────────
        arregloAColaR(cola, arreglo, 0);

        System.out.println("=== Cola ordenada por PRIORIDAD (más urgente al frente) ===");
        cola.imprimirCola();
        System.out.println();

        // ── 5. ATENDER PACIENTES (recursivo) ──────────────────────────────────
        System.out.println("=== Orden de atención ===");
        atenderPacientesR(cola, 1);
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MÉTODOS RECURSIVOS
    // ══════════════════════════════════════════════════════════════════════════

    /** Encolar arreglo genérico recursivamente */
    public static <T> void encolarArregloR(TadCola<T> cola, T[] arr, int i) {
        if (i >= arr.length) return;
        cola.encolar(arr[i]);
        encolarArregloR(cola, arr, i + 1);
    }

    /** Cola → Arreglo (recursivo), cola queda vacía */
    public static <T> void colaAArregloR(TadCola<T> cola, T[] arr, int i) throws ColaVacia {
        if (i >= arr.length) return;
        arr[i] = cola.desencolar();
        colaAArregloR(cola, arr, i + 1);
    }

    /** Arreglo → Cola (recursivo), arreglo[0] queda al FRENTE */
    public static <T> void arregloAColaR(TadCola<T> cola, T[] arr, int i) {
        if (i >= arr.length) return;
        cola.encolar(arr[i]);
        arregloAColaR(cola, arr, i + 1);
    }

    /**
     * BubbleSort DOBLE RECURSIVO (sin for ni while)
     * i = pasada exterior, j = comparación interior
     */
    public static <T extends Comparable<T>> void bubbleSortR(T[] v, int i, int j) {
        if (i >= v.length - 1) return;           // caso base: todas las pasadas hechas
        if (j >= v.length - 1 - i) {             // caso base: pasada i terminada
            bubbleSortR(v, i + 1, 0);
            return;
        }
        if (v[j].compareTo(v[j + 1]) > 0) {      // comparar adyacentes
            T temp    = v[j];
            v[j]      = v[j + 1];
            v[j + 1]  = temp;
        }
        bubbleSortR(v, i, j + 1);                // siguiente comparación
    }

    /**
     * Atender pacientes recursivamente (desencolar hasta vaciar)
     * CASO BASE : cola vacía → todos atendidos
     * CASO REC. : desencolar + imprimir + atender siguiente
     */
    public static void atenderPacientesR(TadCola<Paciente> cola,
                                         int turno) throws ColaVacia {
        if (cola.colaVacia()) return;             // caso base
        Paciente p = cola.desencolar();
        System.out.printf("Turno %d: %-10s (prioridad %d)%n",
                          turno, p.nombre, p.prioridad);
        atenderPacientesR(cola, turno + 1);       // siguiente turno
    }
}
