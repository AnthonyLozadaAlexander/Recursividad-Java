package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;
import AlgoritmosQueue.AlgoritmoCola;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO COLA 3 — Patrones recursivos de Cola
 *                    VERSIÓN 100% RECURSIVA (sin for ni while)
 * ═══════════════════════════════════════════════════════════════════
 *
 * PATRÓN RECURSIVO FUNDAMENTAL DE COLA:
 *
 *   void metodo(Cola<T> cola, int restantes) throws ColaVacia {
 *       if (restantes == 0) return;           ← caso base
 *       T dato = cola.desencolar();           ← sacar del frente
 *       // ...procesar dato...
 *       cola.encolar(dato);                   ← devolver al final
 *       metodo(cola, restantes - 1);          ← siguiente
 *   }
 *   Llamada: metodo(cola, cola.numElemCola())
 *
 * REGLA CLAVE DEL LÍMITE:
 *   Sin el parámetro `restantes`, si reencolamos, la cola nunca
 *   termina (el mismo elemento vuelve al frente infinitamente).
 *   Con `restantes` bajando en cada llamada → exactamente N iteraciones.
 */
public class RefCola03_RecursionPatrones {

    public static void main(String[] args) throws ColaVacia {

        // ── SETUP CON RECURSIVIDAD ────────────────────────────────────────────
        TadCola<Integer> cola = new TadCola<>("cola");
        Integer[] valores = {10, 20, 30, 40, 50, 60};
        encolarArregloR(cola, valores, 0);   // sin for

        System.out.println("Cola original:");
        cola.imprimirCola();
        System.out.println();

        // ── PATRÓN 1: CONTAR SIN DESTRUIR ────────────────────────────────────
        int total = contarSinDestruirR(cola, cola.numElemCola());
        System.out.println("Total de elementos: " + total);
        System.out.print("Cola intacta: "); cola.imprimirCola();
        System.out.println();

        // ── PATRÓN 2: BUSCAR ELEMENTO ─────────────────────────────────────────
        boolean encontrado30 = buscarElementoR(cola, 30, cola.numElemCola());
        boolean encontrado99 = buscarElementoR(cola, 99, cola.numElemCola());
        System.out.println("¿Existe 30? " + encontrado30);  // true
        System.out.println("¿Existe 99? " + encontrado99);  // false
        System.out.print("Cola intacta: "); cola.imprimirCola();
        System.out.println();

        // ── PATRÓN 3: FILTRAR (mantener solo pares) ───────────────────────────
        System.out.println("=== Filtrar: mantener solo pares ===");
        System.out.print("Antes: "); cola.imprimirCola();
        filtrarSoloPares(cola, cola.numElemCola());
        System.out.print("Después: "); cola.imprimirCola();
        System.out.println();

        // ── PATRÓN 4: INVERTIR (desencolar→recursión→reencolar) ───────────────
        TadCola<Integer> cola2 = new TadCola<>("cola2");
        encolarArregloR(cola2, valores, 0);
        System.out.println("=== Invertir cola ===");
        System.out.print("Antes:  "); cola2.imprimirCola();
        AlgoritmoCola.invertirCola(cola2);
        System.out.print("Después:"); cola2.imprimirCola();
    }

    // ══════════════════════════════════════════════════════════════════════════
    // MÉTODOS RECURSIVOS
    // ══════════════════════════════════════════════════════════════════════════

    /** Encolar arreglo genérico (recursivo) */
    public static <T> void encolarArregloR(TadCola<T> cola, T[] arr, int i) {
        if (i >= arr.length) return;
        cola.encolar(arr[i]);
        encolarArregloR(cola, arr, i + 1);
    }

    /**
     * PATRÓN 1: Contar sin destruir usando límite `restantes`
     * ─────────────────────────────────────────────────────────
     * CASO BASE : restantes == 0 → retornar 0
     * CASO REC. : desencolar + reencolar + 1 + contar(restantes-1)
     */
    public static <T> int contarSinDestruirR(TadCola<T> cola, int restantes) throws ColaVacia {
        if (restantes == 0) return 0;
        T dato = cola.desencolar();
        cola.encolar(dato);
        return 1 + contarSinDestruirR(cola, restantes - 1);
    }

    /**
     * PATRÓN 2: Buscar elemento sin destruir
     * ────────────────────────────────────────
     * CASO BASE : restantes == 0 → no encontrado → false
     * CASO REC. : desencolar → comparar → reencolar → buscar en resto
     * TRUCO: usar OR (||) para propagar el true si se encuentra
     */
    public static <T> boolean buscarElementoR(TadCola<T> cola, T buscado,
                                              int restantes) throws ColaVacia {
        if (restantes == 0) return false;
        T dato = cola.desencolar();
        boolean esteEs = dato.equals(buscado);
        cola.encolar(dato);
        // si ya encontré no sigo comparando (cortocircuito con ||)
        return esteEs || buscarElementoR(cola, buscado, restantes - 1);
    }

    /**
     * PATRÓN 3: Filtrar — mantener solo pares, eliminar impares
     * ───────────────────────────────────────────────────────────
     * CASO BASE : restantes == 0 → procesamos exactamente N elementos originales
     * CASO REC. :
     *   - desencolar elemento
     *   - si es par → reencolar (mantener)
     *   - si es impar → NO reencolar (eliminar)
     *   - llamar con restantes - 1
     *
     * PORQUÉ restantes: después de filtrar, los pares reencolados volverán
     * al frente. Sin límite los procesaríamos infinitamente.
     */
    public static void filtrarSoloPares(TadCola<Integer> cola, int restantes) throws ColaVacia {
        if (restantes == 0) return;
        Integer dato = cola.desencolar();
        if (dato % 2 == 0) cola.encolar(dato);   // par: mantener
        // impar: no reencolar → eliminado
        filtrarSoloPares(cola, restantes - 1);
    }
}
