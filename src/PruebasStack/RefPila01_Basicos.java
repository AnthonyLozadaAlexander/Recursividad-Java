package PruebasStack;

import Stack.PilaVacia;
import Stack.TadPila;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO PILA 1 — Operaciones básicas + PATRÓN FUNDAMENTAL
 *                    VERSIÓN 100% RECURSIVA (sin for ni while)
 * ═══════════════════════════════════════════════════════════════════
 *
 * CONCEPTO CLAVE — PILA (Stack): LIFO = Last In, First Out
 *   → apilar(dato)    = agregar EN LA CIMA
 *   → desapilar()     = sacar DE LA CIMA
 *   → cima()          = ver la cima SIN sacar
 *   → pilaVacia()     = true si no hay elementos
 *   → getTamanio()    = cantidad de elementos
 *
 * PATRÓN RECURSIVO FUNDAMENTAL DE PILA (IDA / VUELTA):
 *
 *   void metodo(Pila<T> pila) throws PilaVacia {
 *       if (pila.pilaVacia()) return;       ← caso base
 *       T dato = pila.desapilar();          ← IDA: sacar de la cima
 *       metodo(pila);                       ← bajar hasta la base
 *       pila.apilar(dato);                  ← VUELTA: restaurar
 *   }
 *
 * DIFERENCIA con COLA: en la VUELTA apilamos → pila queda IGUAL.
 * En COLA: reencolamos → cola queda INVERTIDA si no usamos límite.
 */
public class RefPila01_Basicos {

    public static void main(String[] args) throws PilaVacia {

        // ── CREAR LA PILA ─────────────────────────────────────────────────────
        TadPila<Integer> pila = new TadPila<>("mi_pila");

        // ── APILAR ELEMENTOS CON RECURSIVIDAD ────────────────────────────────
        // En vez de: for (int v : valores) pila.apilar(v);
        // Apilamos [10, 20, 30, 40, 50] → cima = 50
        int[] valores = {10, 20, 30, 40, 50};
        apilarArregloR(pila, valores, 0);
        // Estado (cima → base): [50, 40, 30, 20, 10]

        System.out.println("=== Pila inicial (cima → base) ===");
        pila.imprimirPila();
        System.out.println("Tamaño: " + pila.getTamanio());
        System.out.println();

        // ── VER LA CIMA ────────────────────────────────────────────────────
        System.out.println("Cima (sin extraer): " + pila.cima());
        // → 50

        // ── DESAPILAR ──────────────────────────────────────────────────────
        System.out.println("Desapilado: " + pila.desapilar());
        // → 50 (LIFO)
        System.out.println("Nueva cima: " + pila.cima());
        // → 40
        System.out.println();

        // ── PATRÓN: RECORRER + SUMAR SIN DESTRUIR (recursivo) ─────────────
        // En vez de: TadPila<Integer> aux; while (!pila.pilaVacia()) {...}
        System.out.println("=== Recorrer sin destruir (recursivo IDA/VUELTA) ===");
        int[] acumulador = {0};
        recorrerSinDestruirR(pila, acumulador);
        System.out.println("\nSuma: " + acumulador[0]);
        System.out.println("Pila restaurada:");
        pila.imprimirPila();
        System.out.println();

        // ── IMPRIMIR DE BASE A CIMA (recursivo) ───────────────────────────
        System.out.println("=== Orden BASE → CIMA ===");
        imprimirDesdeLaBaseR(pila);
        System.out.println();
        System.out.println();

        // ── VACIAR LA PILA RECURSIVAMENTE ─────────────────────────────────
        vaciarPilaR(pila);
        System.out.println("¿Pila vacía? " + pila.pilaVacia()); // → true
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MÉTODOS RECURSIVOS
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * Apilar todos los elementos de un arreglo (recursivo)
     * ─────────────────────────────────────────────────────
     * CASO BASE : i >= arr.length → ya apilamos todo
     * CASO REC. : apilar arr[i] → llamar con i+1
     * → arreglo[0] apilado primero → queda en la BASE
     * → arreglo[n-1] apilado último → queda en la CIMA
     */
    public static void apilarArregloR(TadPila<Integer> pila, int[] arr, int i) {
        if (i >= arr.length) return;       // caso base
        pila.apilar(arr[i]);               // apilar elemento actual
        apilarArregloR(pila, arr, i + 1);  // recursión: siguiente
    }

    /**
     * Recorrer la pila sin destruirla, acumulando suma (IDA/VUELTA)
     * ──────────────────────────────────────────────────────────────
     * IDA  : desapilar → bajar hasta la base
     * VUELTA: imprimir + apilar → restaurar la pila
     * → al restaurar en VUELTA, el orden queda IGUAL al original
     */
    public static void recorrerSinDestruirR(TadPila<Integer> pila,
                                            int[] acumulador) throws PilaVacia {
        if (pila.pilaVacia()) return;              // caso base: llegamos al fondo
        int dato = pila.desapilar();               // IDA: sacar de la cima
        recorrerSinDestruirR(pila, acumulador);    // bajar más
        acumulador[0] += dato;                     // VUELTA: acumular
        System.out.print(dato + " ");              // VUELTA: imprimir (base→cima)
        pila.apilar(dato);                         // VUELTA: restaurar
    }

    /**
     * Imprimir pila desde la BASE hasta la CIMA
     * ───────────────────────────────────────────
     * IDA  : bajar hasta la base
     * VUELTA: imprimir al subir → sale BASE primero, luego CIMA
     */
    public static <T> void imprimirDesdeLaBaseR(TadPila<T> pila) throws PilaVacia {
        if (pila.pilaVacia()) return;          // caso base
        T dato = pila.desapilar();             // IDA
        imprimirDesdeLaBaseR(pila);            // bajar
        System.out.print(dato + " ");          // VUELTA: imprimir (base→cima)
        pila.apilar(dato);                     // VUELTA: restaurar
    }

    /**
     * Vaciar la pila recursivamente
     */
    public static <T> void vaciarPilaR(TadPila<T> pila) throws PilaVacia {
        if (pila.pilaVacia()) return;          // caso base: ya está vacía
        pila.desapilar();                      // eliminar la cima
        vaciarPilaR(pila);                     // recursión con el resto
    }
}
