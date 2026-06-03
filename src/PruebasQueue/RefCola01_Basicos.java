package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;
import AlgoritmosQueue.AlgoritmoCola;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO COLA 1 — Operaciones básicas + PATRÓN FUNDAMENTAL
 * ═══════════════════════════════════════════════════════════════════
 *
 * CONCEPTO CLAVE — COLA (Queue): FIFO = First In, First Out
 *   → El PRIMERO en entrar es el PRIMERO en salir
 *   → encolar(dato)   = agregar AL FINAL   (como una fila de supermercado)
 *   → desencolar()    = sacar DEL FRENTE   (el que llegó primero sale primero)
 *   → primero()       = ver el frente SIN sacar
 *   → colaVacia()     = true si no hay elementos
 *
 * OPERACIONES DE TadCola (las que usarás en examen):
 *   cola.encolar(dato)          → agrega al final
 *   cola.desencolar()           → extrae del frente (lanza ColaVacia si está vacía)
 *   cola.primero()              → lee el frente sin extraer
 *   cola.colaVacia()            → boolean: ¿está vacía?
 *   cola.numElemCola()          → cantidad de elementos
 *   cola.imprimirCola()         → imprime todos los elementos
 *   cola.invertirCola()         → invierte el orden (recursivo en TadCola)
 *   cola.eliminarCola()         → vacía la cola (principio = fin = null)
 *
 * PATRÓN FUNDAMENTAL DE COLA (memorizar para examen):
 *   Para recorrer sin destruir → desencolar + guardar + reencolar al final
 *   int n = cola.numElemCola();
 *   for (int i = 0; i < n; i++) {
 *       T dato = cola.desencolar();  // sacar del frente
 *       // ... procesar dato ...
 *       cola.encolar(dato);          // volver a poner al final
 *   }
 *   Después de n iteraciones, la cola queda IGUAL que al inicio.
 */
public class RefCola01_Basicos {

    public static void main(String[] args) throws ColaVacia {

        // ── CREAR LA COLA ─────────────────────────────────────────────────────
        // TadCola<T>(String nombre) → cola vacía con etiqueta
        TadCola<Integer> cola = new TadCola<>("mi_cola");

        // ── ENCOLAR ELEMENTOS ─────────────────────────────────────────────────
        // Los elementos entran por el FINAL
        // Orden de entrada: 10, 20, 30, 40, 50
        // Estado: FRENTE [10 → 20 → 30 → 40 → 50] FINAL
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.encolar(40);
        cola.encolar(50);

        System.out.println("=== Estado inicial ===");
        cola.mostrarEstadoCola();   // muestra tamaño, primero y último
        System.out.println();
        cola.imprimirCola();        // imprime todos los elementos
        System.out.println();

        // ── VER EL FRENTE SIN EXTRAER ─────────────────────────────────────────
        System.out.println("Primero (sin extraer): " + cola.primero());
        // → 10 (el que entró primero está al frente)

        // ── DESENCOLAR (FIFO) ─────────────────────────────────────────────────
        System.out.println("Desencolado: " + cola.desencolar());
        // → 10 sale primero (FIFO)
        System.out.println("Ahora el frente es: " + cola.primero());
        // → 20 pasa a ser el frente
        System.out.println();

        // ── PATRÓN: RECORRER SIN DESTRUIR ─────────────────────────────────────
        // Si desencolo todo, pierdo la cola. Solución: desencolar + reencolar.
        System.out.println("=== Recorrer sin destruir la cola ===");
        int n = cola.numElemCola(); // 4 elementos quedan (sacamos el 10)
        int suma = 0;

        for (int i = 0; i < n; i++) {
            int dato = cola.desencolar();  // extraer del frente
            suma += dato;                  // procesar
            System.out.print(dato + " "); // mostrar
            cola.encolar(dato);            // devolver al final ← CLAVE
        }
        // Después del for la cola es [20, 30, 40, 50] → igual que antes
        System.out.println("\nSuma: " + suma);
        System.out.println("Cola intacta después del recorrido:");
        cola.imprimirCola();
        System.out.println();

        // ── INVERTIR LA COLA ──────────────────────────────────────────────────
        // invertirCola() usa recursión interna de TadCola
        // ANTES:  [20, 30, 40, 50]
        // DESPUÉS:[50, 40, 30, 20]
        System.out.println("=== Después de invertir ===");
        cola.invertirCola();
        cola.imprimirCola();
        System.out.println();

        // ── VACIAR LA COLA ────────────────────────────────────────────────────
        cola.eliminarCola();   // principio = fin = null
        System.out.println("¿Cola vacía? " + cola.colaVacia()); // → true
    }
}
