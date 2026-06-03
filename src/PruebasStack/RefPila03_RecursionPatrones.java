package PruebasStack;

import Stack.PilaVacia;
import Stack.TadPila;
import AlgoritmosStack.AlgoritmosPila;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO PILA 3 — Recursión en Pila: patrón desapilar → recursión → apilar
 * ═══════════════════════════════════════════════════════════════════
 *
 * PATRÓN RECURSIVO FUNDAMENTAL DE PILA (para examen):
 *
 *   void metodo(Pila<T> pila) throws PilaVacia {
 *       if (!pila.pilaVacia()) {
 *           T dato = pila.desapilar();    // 1. sacar de la cima
 *           metodo(pila);                 // 2. llamada recursiva (IDA)
 *           pila.apilar(dato);            // 3. volver a apilar (VUELTA)
 *       }
 *   }
 *
 * EFECTO de este patrón:
 *   - En la IDA  : desapilamos uno a uno hasta llegar a la base (vacía)
 *   - En la VUELTA: apilamos en orden inverso → pila queda IGUAL
 *
 * ¿POR QUÉ QUEDA IGUAL? Porque apilar en la VUELTA reconstruye desde la base.
 *   Si tenemos [C, B, A] (C=cima):
 *   IDA: desapila C, desapila B, desapila A (pila vacía)
 *   VUELTA: apila A (base), apila B, apila C → [C, B, A] ← mismo orden
 *
 * EJERCICIOS DE EXAMEN COMUNES CON ESTE PATRÓN:
 *   1. Contar elementos sin destruir
 *   2. Buscar máximo/mínimo
 *   3. Insertar al fondo (base)
 *   4. Eliminar un elemento específico
 *   5. Imprimir en orden inverso (base → cima)
 */
public class RefPila03_RecursionPatrones {

    public static void main(String[] args) throws PilaVacia {

        // ── SETUP ─────────────────────────────────────────────────────────────
        // Pila: [60, 50, 40, 30, 20, 10] (60=cima, 10=base)
        TadPila<Integer> pila = new TadPila<>("pila");
        int[] valores = {10, 20, 30, 40, 50, 60};
        for (int v : valores) pila.apilar(v);

        System.out.println("Pila original (cima → base):");
        pila.imprimirPila();
        System.out.println();

        // ── PATRÓN 1: CONTAR SIN DESTRUIR ────────────────────────────────────
        int total = contarSinDestruir(pila);
        System.out.println("Total de elementos: " + total);   // 6
        System.out.println("Cima intacta: " + pila.cima());   // 60
        System.out.println();

        // ── PATRÓN 2: BUSCAR MÁXIMO (ya en AlgoritmosPila) ───────────────────
        int maximo = AlgoritmosPila.buscarElementoMax(pila);
        System.out.println("Máximo: " + maximo);       // 60
        System.out.println("Pila intacta: " + pila.getTamanio() + " elementos");
        System.out.println();

        // ── PATRÓN 3: INSERTAR AL FONDO (BASE) ───────────────────────────────
        // insertarAlFondo usa el patrón recursivo para llegar a la base
        System.out.println("=== Insertar 99 en la BASE ===");
        AlgoritmosPila.insertarAlFondo(pila, 99);
        pila.imprimirPila();
        // Resultado: [60, 50, 40, 30, 20, 10, 99] (99 en la base)
        System.out.println();

        // ── PATRÓN 4: IMPRIMIR DE BASE A CIMA ────────────────────────────────
        // Usar recursión: llegar al fondo en la IDA, imprimir en la VUELTA
        System.out.println("=== Imprimir de BASE a CIMA ===");
        imprimirDesdeLaBase(pila);
        System.out.println();
        System.out.println();

        // ── PATRÓN 5: ELIMINAR OCURRENCIAS ───────────────────────────────────
        // Apilar algunos duplicados para probar
        TadPila<Integer> pila2 = new TadPila<>("pila2");
        pila2.apilar(10); pila2.apilar(30); pila2.apilar(10);
        pila2.apilar(50); pila2.apilar(10); pila2.apilar(20);
        System.out.println("=== Eliminar todas las ocurrencias de 10 ===");
        System.out.print("Antes:  "); pila2.imprimirPila();
        AlgoritmosPila.eliminarOcurrencias(pila2, 10);
        System.out.print("Después:"); pila2.imprimirPila();
    }

    /**
     * PATRÓN: Contar elementos sin destruir la pila
     * ──────────────────────────────────────────────
     * IDA  : desapilar → llamada recursiva
     * VUELTA: apilar de vuelta → 1 + resultado
     *
     * La pila queda IGUAL porque apilamos exactamente lo que desapilamos.
     */
    public static <T> int contarSinDestruir(TadPila<T> pila) throws PilaVacia {
        if (pila.pilaVacia()) return 0;        // caso base: pila vacía → 0

        T dato = pila.desapilar();             // IDA: sacar de la cima
        int count = 1 + contarSinDestruir(pila); // recursión + contar
        pila.apilar(dato);                     // VUELTA: restaurar

        return count;
    }

    /**
     * PATRÓN: Imprimir desde la BASE hasta la CIMA (orden inverso al normal)
     * ────────────────────────────────────────────────────────────────────────
     * IDA  : desapilar y bajar hasta la base (sin imprimir)
     * VUELTA: imprimir mientras apilamos de vuelta
     *
     * El System.out DESPUÉS de la llamada recursiva → imprime en la VUELTA
     * → Sale en orden BASE → CIMA (inverso a imprimirPila normal)
     */
    public static <T> void imprimirDesdeLaBase(TadPila<T> pila) throws PilaVacia {
        if (pila.pilaVacia()) return;          // caso base

        T dato = pila.desapilar();             // IDA: bajar hacia la base
        imprimirDesdeLaBase(pila);             // recursión (llega a la base)
        System.out.print(dato + " ");          // VUELTA: imprimir al subir
        pila.apilar(dato);                     // VUELTA: restaurar pila
    }
}
