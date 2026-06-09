package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO COLA 1 — Operaciones básicas + PATRÓN FUNDAMENTAL
 *                    VERSIÓN 100% RECURSIVA (sin for ni while)
 * ═══════════════════════════════════════════════════════════════════
 *
 * CONCEPTO CLAVE — COLA (Queue): FIFO = First In, First Out
 *   → encolar(dato)   = agregar AL FINAL
 *   → desencolar()    = sacar DEL FRENTE
 *   → primero()       = ver el frente SIN sacar
 *   → colaVacia()     = true si no hay elementos
 *   → numElemCola()   = cantidad de elementos
 *
 * PATRÓN RECURSIVO FUNDAMENTAL DE COLA:
 *   En lugar de for (i=0; i<n; i++) { desencolar(); encolar(); }
 *   usamos un método recursivo con límite `restantes`:
 *
 *   void recorrer(Cola<T> cola, int restantes) throws ColaVacia {
 *       if (restantes == 0) return;            ← caso base
 *       T dato = cola.desencolar();            ← sacar del frente
 *       // ...procesar dato...
 *       cola.encolar(dato);                    ← devolver al final
 *       recorrer(cola, restantes - 1);         ← siguiente elemento
 *   }
 *   // Llamada inicial: recorrer(cola, cola.numElemCola())
 */
public class RefCola01_Basicos {

    public static void main(String[] args) throws ColaVacia {

        // ── CREAR LA COLA ─────────────────────────────────────────────────────
        TadCola<Integer> cola = new TadCola<>("mi_cola");

        // ── ENCOLAR ELEMENTOS CON RECURSIVIDAD ────────────────────────────────
        // En vez de: for (int v : valores) cola.encolar(v);
        int[] valores = {10, 20, 30, 40, 50};
        encolarArregloR(cola, valores, 0);
        // Estado: FRENTE [10 → 20 → 30 → 40 → 50] FINAL

        System.out.println("=== Estado inicial ===");
        cola.mostrarEstadoCola();
        System.out.println();
        cola.imprimirCola();
        System.out.println();

        // ── VER EL FRENTE SIN EXTRAER ─────────────────────────────────────────
        System.out.println("Primero (sin extraer): " + cola.primero());
        // → 10

        // ── DESENCOLAR ────────────────────────────────────────────────────────
        System.out.println("Desencolado: " + cola.desencolar());
        // → 10 (FIFO)
        System.out.println("Nuevo frente: " + cola.primero());
        // → 20
        System.out.println();

        // ── PATRÓN: RECORRER + SUMAR SIN DESTRUIR ─────────────────────────────
        // Quedan 4 elementos: [20, 30, 40, 50]
        System.out.println("=== Recorrer sin destruir (recursivo) ===");
        int n = cola.numElemCola();
        int[] acumulador = {0};  // array de 1 posición para pasar por referencia

        recorrerImprimiendoR(cola, n, acumulador);

        System.out.println("\nSuma: " + acumulador[0]);
        System.out.println("Cola intacta:");
        cola.imprimirCola();
        System.out.println();

        // ── INVERTIR LA COLA ──────────────────────────────────────────────────
        System.out.println("=== Después de invertir ===");
        invertirColaR(cola);    // patrón: desencolar → recursión → reencolar
        cola.imprimirCola();
        System.out.println();

        // ── VACIAR LA COLA RECURSIVAMENTE ────────────────────────────────────
        vaciarColaR(cola);
        System.out.println("¿Cola vacía? " + cola.colaVacia()); // → true
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MÉTODOS RECURSIVOS
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * Encolar todos los elementos de un arreglo en la cola (recursivo)
     * ─────────────────────────────────────────────────────────────────
     * CASO BASE : i >= arreglo.length → ya encolare todos
     * CASO REC. : encolar arreglo[i] → llamar con i+1
     */
    public static void encolarArregloR(TadCola<Integer> cola, int[] arr, int i) {
        if (i >= arr.length) return;      // caso base: ya procesamos todo
        cola.encolar(arr[i]);             // encolar elemento actual
        encolarArregloR(cola, arr, i + 1); // recursión: siguiente elemento
    }

    /**
     * Recorrer la cola sin destruirla, acumulando la suma
     * ──────────────────────────────────────────────────────
     * PARÁMETRO restantes: cuántos elementos quedan por procesar
     * → evita dar más vueltas de las necesarias
     */
    public static void recorrerImprimiendoR(TadCola<Integer> cola,
                                            int restantes,
                                            int[] acumulador) throws ColaVacia {
        if (restantes == 0) return;                    // caso base
        int dato = cola.desencolar();                  // sacar del frente
        acumulador[0] += dato;                         // acumular
        System.out.print(dato + " ");                  // imprimir
        cola.encolar(dato);                            // devolver al final
        recorrerImprimiendoR(cola, restantes - 1, acumulador); // siguiente
    }

    /**
     * Invertir la cola usando recursión pura
     * ────────────────────────────────────────────────────────────────
     * IDA  : desencolar uno a uno hasta vaciar
     * VUELTA: encolar en orden inverso (el primero en desencolar
     *         es el último en reencolar → queda al final = invertido)
     */
    public static <T> void invertirColaR(TadCola<T> cola) throws ColaVacia {
        if (cola.colaVacia()) return;          // caso base: cola vacía
        T dato = cola.desencolar();            // IDA: sacar del frente
        invertirColaR(cola);                   // recursión hasta vaciar
        cola.encolar(dato);                    // VUELTA: poner al final
    }

    /**
     * Vaciar la cola recursivamente
     */
    public static <T> void vaciarColaR(TadCola<T> cola) throws ColaVacia {
        if (cola.colaVacia()) return;          // caso base: ya está vacía
        cola.desencolar();                     // eliminar el frente
        vaciarColaR(cola);                     // recursión con el resto
    }
}
