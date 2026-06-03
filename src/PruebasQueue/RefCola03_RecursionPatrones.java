package PruebasQueue;

import Queue.ColaVacia;
import Queue.TadCola;
import AlgoritmosQueue.AlgoritmoCola;

/**
 * ═══════════════════════════════════════════════════════════════════
 * EJERCICIO COLA 3 — Recursión en Cola: patrón desencolar → recursión → reencolar
 * ═══════════════════════════════════════════════════════════════════
 *
 * PATRÓN RECURSIVO FUNDAMENTAL DE COLA (para examen):
 *
 *   void metodo(Cola<T> cola) throws ColaVacia {
 *       if (!cola.colaVacia()) {
 *           T dato = cola.desencolar();   // 1. sacar del frente
 *           metodo(cola);                 // 2. llamada recursiva (IDA)
 *           cola.encolar(dato);           // 3. volver a poner al final (VUELTA)
 *       }
 *   }
 *
 * EFECTO de este patrón:
 *   - En la IDA  : vamos desencolar uno a uno hasta vaciar
 *   - En la VUELTA: encolar en orden inverso al de la IDA
 *   → El primer elemento desencolado es el ÚLTIMO en reencolar → cola INVERTIDA
 *
 * Este es exactamente el patrón de invertirCola() en TadCola.java
 * y AlgoritmoCola.invertirCola()
 *
 * EJERCICIOS DE EXAMEN COMUNES CON ESTE PATRÓN:
 *   1. Invertir cola (ya visto)
 *   2. Contar elementos sin destruir
 *   3. Buscar un elemento sin destruir
 *   4. Filtrar elementos (mantener solo los que cumplen condición)
 *   5. Mover último al frente
 */
public class RefCola03_RecursionPatrones {

    public static void main(String[] args) throws ColaVacia {

        // ── SETUP ─────────────────────────────────────────────────────────────
        TadCola<Integer> cola = new TadCola<>("cola");
        int[] valores = {10, 20, 30, 40, 50, 60};
        for (int v : valores) cola.encolar(v);

        System.out.println("Cola original:");
        cola.imprimirCola();
        System.out.println();

        // ── PATRÓN 1: CONTAR SIN DESTRUIR ────────────────────────────────────
        int total = contarSinDestruir(cola, cola.numElemCola());
        System.out.println("Total de elementos: " + total);
        System.out.print("Cola intacta: "); cola.imprimirCola();
        System.out.println();

        // ── PATRÓN 2: BUSCAR ELEMENTO ─────────────────────────────────────────
        boolean encontrado30 = buscarElemento(cola, 30);
        boolean encontrado99 = buscarElemento(cola, 99);
        System.out.println("¿Existe 30? " + encontrado30);  // true
        System.out.println("¿Existe 99? " + encontrado99);  // false
        System.out.print("Cola intacta: "); cola.imprimirCola();
        System.out.println();

        // ── PATRÓN 3: FILTRAR (mantener solo pares) ───────────────────────────
        // Equivale a filtrarImparesDos() de AlgoritmoCola.java
        System.out.println("=== Filtrar: mantener solo pares ===");
        cola.imprimirCola();
        filtrarSoloPares(cola, cola.numElemCola());
        System.out.print("Después del filtro: "); cola.imprimirCola();
        System.out.println();

        // ── PATRÓN 4: INVERTIR ────────────────────────────────────────────────
        // Reconstruir cola con los pares para invertir
        TadCola<Integer> cola2 = new TadCola<>("cola2");
        for (int v : valores) cola2.encolar(v);
        System.out.println("=== Invertir cola (usando AlgoritmoCola) ===");
        System.out.print("Antes:  "); cola2.imprimirCola();
        AlgoritmoCola.invertirCola(cola2);
        System.out.print("Después:"); cola2.imprimirCola();
    }

    /**
     * PATRÓN 1: Contar usando numElemCola como límite de iteraciones
     * ──────────────────────────────────────────────────────────────
     * TRUCO: usar un contador `restantes` que baja en cada llamada recursiva
     * para saber cuándo hemos dado una vuelta completa a la cola
     */
    public static <T> int contarSinDestruir(TadCola<T> cola, int restantes) throws ColaVacia {
        if (restantes == 0) return 0;          // caso base: ya procesamos todos

        T dato = cola.desencolar();            // sacar del frente
        cola.encolar(dato);                    // poner al final (preservar)
        return 1 + contarSinDestruir(cola, restantes - 1); // contar + recursión
    }

    /**
     * PATRÓN 2: Buscar elemento sin destruir la cola
     * ───────────────────────────────────────────────
     * MISMA IDEA: usar numElemCola() como límite para dar una vuelta completa
     */
    public static <T> boolean buscarElemento(TadCola<T> cola, T buscado) throws ColaVacia {
        return buscarR(cola, buscado, cola.numElemCola());
    }

    private static <T> boolean buscarR(TadCola<T> cola, T buscado, int restantes) throws ColaVacia {
        if (restantes == 0) return false;       // caso base: no encontrado

        T dato = cola.desencolar();             // sacar del frente
        boolean esteEsElBuscado = dato.equals(buscado);
        cola.encolar(dato);                     // devolver al final (preservar)

        // si ya lo encontré, no necesito seguir → OR con el resto
        return esteEsElBuscado || buscarR(cola, buscado, restantes - 1);
    }

    /**
     * PATRÓN 3: Filtrar — mantener solo elementos que cumplen condición
     * ──────────────────────────────────────────────────────────────────
     * TRUCO CLAVE: usar `restantes` como límite para no procesar elementos
     * que ya fueron reencolados (evitar bucle infinito)
     *
     * LÓGICA:
     *   - Desencolar elemento
     *   - Si cumple condición → reencolar (mantener)
     *   - Si no cumple → NO reencolar (eliminar)
     *   - Decrementar restantes en cada llamada
     */
    public static void filtrarSoloPares(TadCola<Integer> cola, int restantes) throws ColaVacia {
        if (restantes == 0) return;              // caso base: procesamos todos

        Integer dato = cola.desencolar();        // sacar del frente
        if (dato % 2 == 0) {
            cola.encolar(dato);                  // es par → mantener
        }
        // si es impar → no reencolar → queda eliminado
        filtrarSoloPares(cola, restantes - 1);   // procesar siguiente
    }
}
