package PruebasStack;

import Stack.PilaVacia;
import Stack.TadPila;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO PILA 1 — Operaciones básicas + PATRÓN FUNDAMENTAL
 * ═══════════════════════════════════════════════════════════════════
 *
 * CONCEPTO CLAVE — PILA (Stack): LIFO = Last In, First Out
 *   → El ÚLTIMO en entrar es el PRIMERO en salir
 *   → apilar(dato)    = agregar EN LA CIMA  (como una pila de platos)
 *   → desapilar()     = sacar DE LA CIMA    (el último que llegó sale primero)
 *   → cima()          = ver la cima SIN sacar
 *   → pilaVacia()     = true si no hay elementos
 *
 * OPERACIONES DE TadPila (las que usarás en examen):
 *   pila.apilar(dato)           → agrega en la cima (arriba)
 *   pila.desapilar()            → extrae de la cima (lanza PilaVacia si vacía)
 *   pila.cima()                 → lee la cima sin extraer
 *   pila.pilaVacia()            → boolean: ¿está vacía?
 *   pila.getTamanio()           → cantidad de elementos
 *   pila.imprimirPila()         → imprime desde cima hasta base
 *   pila.vaciarPila()           → vacía la pila (nodoCima = null)
 *
 * DIFERENCIA CLAVE PILA vs COLA (para examen):
 *   COLA: encolar→final, desencolar→frente  (FIFO)
 *   PILA: apilar→cima,   desapilar→cima     (LIFO)
 *
 * PATRÓN FUNDAMENTAL DE PILA (memorizar para examen):
 *   Para recorrer sin destruir → desapilar + guardar + apilar de vuelta
 *   Pero OJO: al reencolar, el orden se INVIERTE si no usas pila auxiliar.
 *
 *   PATRÓN SEGURO (con pila auxiliar):
 *   TadPila<T> aux = new TadPila<>("aux");
 *   while (!pila.pilaVacia()) {
 *       T dato = pila.desapilar();
 *       // ... procesar dato ...
 *       aux.apilar(dato);        // guardar en auxiliar (invierte)
 *   }
 *   while (!aux.pilaVacia()) {
 *       pila.apilar(aux.desapilar()); // restaurar (invierte de vuelta)
 *   }
 *   // La pila queda IGUAL que al inicio.
 */
public class RefPila01_Basicos {

    public static void main(String[] args) throws PilaVacia {

        // ── CREAR LA PILA ─────────────────────────────────────────────────────
        // TadPila<T>(String nombre) → pila vacía con etiqueta
        TadPila<Integer> pila = new TadPila<>("mi_pila");

        // ── APILAR ELEMENTOS ──────────────────────────────────────────────────
        // Los elementos se apilan EN LA CIMA (arriba)
        // Orden de apilar: 10, 20, 30, 40, 50
        // Estado visual (cima arriba):
        //   [50] ← cima
        //   [40]
        //   [30]
        //   [20]
        //   [10] ← base
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);
        pila.apilar(40);
        pila.apilar(50);

        System.out.println("=== Estado inicial (cima → base) ===");
        pila.imprimirPila();   // imprime desde cima: 50, 40, 30, 20, 10
        System.out.println("Tamaño: " + pila.getTamanio());
        System.out.println();

        // ── VER LA CIMA SIN EXTRAER ───────────────────────────────────────────
        System.out.println("Cima (sin extraer): " + pila.cima());
        // → 50 (el último en apilar está en la cima)

        // ── DESAPILAR (LIFO) ──────────────────────────────────────────────────
        System.out.println("Desapilado: " + pila.desapilar());
        // → 50 sale primero (LIFO: último en entrar, primero en salir)
        System.out.println("Nueva cima: " + pila.cima());
        // → 40
        System.out.println();

        // ── PATRÓN: RECORRER SIN DESTRUIR (con pila auxiliar) ─────────────────
        System.out.println("=== Recorrer sin destruir (con auxiliar) ===");
        TadPila<Integer> aux = new TadPila<>("auxiliar");
        int suma = 0;

        // FASE 1: vaciar a auxiliar mientras procesamos
        while (!pila.pilaVacia()) {
            int dato = pila.desapilar();  // extraer de la cima
            suma += dato;
            System.out.print(dato + " "); // sale en orden: 40, 30, 20, 10
            aux.apilar(dato);             // guardar en auxiliar (queda invertida)
        }
        System.out.println("\nSuma: " + suma);

        // FASE 2: restaurar la pila original desde auxiliar
        // auxiliar tiene: [10, 20, 30, 40] → al desapilar: 40, 30, 20, 10
        while (!aux.pilaVacia()) {
            pila.apilar(aux.desapilar()); // vuelve a apilar → pila queda igual
        }

        System.out.println("Pila restaurada:");
        pila.imprimirPila();  // [40, 30, 20, 10] → igual que antes
        System.out.println();

        // ── VACIAR LA PILA ────────────────────────────────────────────────────
        pila.vaciarPila();   // nodoCima = null, tamanio = 0
        System.out.println("¿Pila vacía? " + pila.pilaVacia()); // → true
    }
}
