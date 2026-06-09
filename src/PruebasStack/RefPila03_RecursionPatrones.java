package PruebasStack;

import Stack.PilaVacia;
import Stack.TadPila;
import AlgoritmosStack.AlgoritmosPila;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO PILA 3 — Patrones recursivos de Pila
 *                    VERSIÓN 100% RECURSIVA (sin for ni while)
 * ═══════════════════════════════════════════════════════════════════
 *
 * PATRÓN RECURSIVO IDA/VUELTA DE PILA:
 *
 *   void metodo(Pila<T> pila) throws PilaVacia {
 *       if (pila.pilaVacia()) return;       ← caso base (fondo)
 *       T dato = pila.desapilar();          ← IDA: bajar nivel
 *       metodo(pila);                       ← seguir bajando
 *       pila.apilar(dato);                  ← VUELTA: restaurar
 *   }
 *
 * CUÁNDO PONER EL PROCESAMIENTO:
 *   ANTES de la llamada recursiva  → procesa en orden CIMA→BASE (IDA)
 *   DESPUÉS de la llamada recursiva → procesa en orden BASE→CIMA (VUELTA)
 *
 * Ejemplos:
 *   Imprimir cima→base: System.out.print(dato) ANTES de recursión
 *   Imprimir base→cima: System.out.print(dato) DESPUÉS de recursión
 */
public class RefPila03_RecursionPatrones {

    public static void main(String[] args) throws PilaVacia {

        // ── SETUP CON RECURSIVIDAD ────────────────────────────────────────────
        // Pila: cima=60, base=10
        TadPila<Integer> pila = new TadPila<>("pila");
        Integer[] valores = {10, 20, 30, 40, 50, 60};
        apilarArregloR(pila, valores, 0);   // sin for

        System.out.println("Pila original (cima → base):");
        pila.imprimirPila();
        System.out.println();

        // ── PATRÓN 1: CONTAR SIN DESTRUIR ────────────────────────────────────
        int total = contarSinDestruirR(pila);
        System.out.println("Total: " + total);
        System.out.println("Cima intacta: " + pila.cima()); // 60
        System.out.println();

        // ── PATRÓN 2: BUSCAR MÁXIMO ───────────────────────────────────────────
        int maximo = AlgoritmosPila.buscarElementoMax(pila);
        System.out.println("Máximo: " + maximo); // 60
        System.out.println("Pila intacta: " + pila.getTamanio() + " elementos");
        System.out.println();

        // ── PATRÓN 3: INSERTAR AL FONDO (BASE) ───────────────────────────────
        System.out.println("=== Insertar 99 en la BASE ===");
        AlgoritmosPila.insertarAlFondo(pila, 99);
        pila.imprimirPila(); // [60, 50, 40, 30, 20, 10, 99]
        System.out.println();

        // ── PATRÓN 4: IMPRIMIR DE BASE A CIMA ────────────────────────────────
        System.out.println("=== Imprimir BASE → CIMA ===");
        imprimirBaseACimaR(pila);
        System.out.println();
        System.out.println();

        // ── PATRÓN 5: ELIMINAR OCURRENCIAS ───────────────────────────────────
        TadPila<Integer> pila2 = new TadPila<>("pila2");
        Integer[] conDups = {10, 30, 10, 50, 10, 20};
        apilarArregloR(pila2, conDups, 0);
        System.out.println("=== Eliminar todas las ocurrencias de 10 ===");
        System.out.print("Antes:  "); pila2.imprimirPila();
        AlgoritmosPila.eliminarOcurrencias(pila2, 10);
        System.out.print("Después:"); pila2.imprimirPila();
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MÉTODOS RECURSIVOS
    // ══════════════════════════════════════════════════════════════════════════

    /** Apilar arreglo genérico (recursivo, arr[0]=BASE, arr[n-1]=CIMA) */
    public static <T> void apilarArregloR(TadPila<T> pila, T[] arr, int i) {
        if (i >= arr.length) return;
        pila.apilar(arr[i]);
        apilarArregloR(pila, arr, i + 1);
    }

    /**
     * PATRÓN 1: Contar sin destruir (IDA/VUELTA)
     * ────────────────────────────────────────────
     * IDA  : desapilar → bajar
     * VUELTA: 1 + count + apilar → pila restaurada
     */
    public static <T> int contarSinDestruirR(TadPila<T> pila) throws PilaVacia {
        if (pila.pilaVacia()) return 0;       // caso base: fondo = 0
        T dato = pila.desapilar();            // IDA
        int count = 1 + contarSinDestruirR(pila); // recursión
        pila.apilar(dato);                    // VUELTA: restaurar
        return count;
    }

    /**
     * PATRÓN 4: Imprimir de BASE a CIMA (procesar en VUELTA)
     * ────────────────────────────────────────────────────────
     * IDA  : bajar hasta la base (sin imprimir)
     * VUELTA: imprimir al subir → sale BASE primero, CIMA al final
     *
     * TRUCO: el System.out está DESPUÉS de la llamada recursiva
     *        → se ejecuta en el camino de VUELTA (BASE → CIMA)
     */
    public static <T> void imprimirBaseACimaR(TadPila<T> pila) throws PilaVacia {
        if (pila.pilaVacia()) return;         // caso base
        T dato = pila.desapilar();            // IDA: bajar
        imprimirBaseACimaR(pila);             // seguir bajando
        System.out.print(dato + " ");         // VUELTA: imprimir al subir
        pila.apilar(dato);                    // VUELTA: restaurar
    }
}
