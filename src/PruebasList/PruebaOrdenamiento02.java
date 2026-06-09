package PruebasList;

import Algoritmos.Ordenacion;
import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

/**
 * EJERCICIO 2 — Ordenar lista de Strings con Insertion Sort
 * ─────────────────────────────────────────────────────────
 * PATRON GENERAL (sirve para cualquier tipo T):
 *   1. Crear TadLista<T>
 *   2. Insertar datos (al principio o al final)
 *   3. Lista → Arreglo T[]  (con aux que recorre sin destruir)
 *   4. Ordenacion.insercion(arreglo)   ← el algoritmo hace el trabajo
 *   5. Vaciar lista  (eliminarPrimero n veces)
 *   6. Arreglo → Lista (insertarAlFinal en orden)
 *   7. Imprimir resultado
 */
public class PruebaOrdenamiento02 {

    public static void main(String[] args) {

        // ── 1. CREAR LA LISTA ────────────────────────────────────────────────
        // TadLista<T>(String nombre) → lista enlazada vacía con etiqueta
        TadLista<String> palabras = new TadLista<>("palabras");

        // ── 2. INSERTAR AL PRINCIPIO ─────────────────────────────────────────
        // insertarAlPrincipio agrega ANTES del nodo actual
        // => el último en insertarse queda primero en la lista
        // Orden de inserción: "mango" → "apple" → "kiwi" → "banana" → "uva"
        // Orden resultante en lista: [uva] → [banana] → [kiwi] → [apple] → [mango]
        AlgoritmosListas.insertarAlPrincipio(palabras, "mango");
        AlgoritmosListas.insertarAlPrincipio(palabras, "apple");
        AlgoritmosListas.insertarAlPrincipio(palabras, "kiwi");
        AlgoritmosListas.insertarAlPrincipio(palabras, "banana");
        AlgoritmosListas.insertarAlPrincipio(palabras, "uva");

        // ── 3. IMPRIMIR LISTA ORIGINAL ───────────────────────────────────────
        System.out.println("=== Lista original ===");
        AlgoritmosListas.imprimirLista(palabras);   // imprime [uva],[banana],[kiwi],[apple],[mango]
        System.out.println();

        // ── 4. LISTA → ARREGLO (RECURSIVO) ──────────────────────────────────────
        int n = AlgoritmosListas.contar(palabras);  // cuenta cuántos nodos tiene
        String[] arreglo = new String[n];           // arreglo del mismo tamaño

        // TRUCO CLAVE: crear un TadLista auxiliar que apunte al primer nodo
        // así recorremos la lista SIN mover el puntero original de 'palabras'
        TadLista<String> aux = new TadLista<>();
        aux.asignarReferencia(palabras.devolverReferencia()); // aux → primer nodo

        // Usar método recursivo para copiar lista a arreglo
        listaAArregloRecursivo(aux, arreglo, 0, n);

        // ── 5. APLICAR INSERTION SORT ────────────────────────────────────────
        // Ordenacion.insercion trabaja sobre arreglos genéricos T[]
        // Strings se comparan con compareTo → orden alfabético
        Ordenacion.insercion(arreglo);
        // arreglo ahora: ["apple", "banana", "kiwi", "mango", "uva"]

        // ── 6. VACIAR LA LISTA (RECURSIVO) ──────────────────────────────────────
        // Usar método recursivo para eliminar todos los nodos
        vaciarListaRecursivo(palabras, n);

        // ── 7. RECONSTRUIR LISTA DESDE ARREGLO ORDENADO (RECURSIVO) ────────────
        // Usar método recursivo para insertar arreglo en lista
        arregloAListaRecursivo(palabras, arreglo, 0, n);

        // ── 8. IMPRIMIR LISTA ORDENADA ───────────────────────────────────────
        System.out.println("=== Lista ordenada (alfabéticamente) ===");
        AlgoritmosListas.imprimirLista(palabras);
        System.out.println();

        // REFLEXIÓN: ¿insertarAlPrincipio vs insertarAlFinal antes de ordenar?
        // → Da igual, porque el ordenamiento trabaja sobre el ARREGLO, no sobre la lista.
        //   La diferencia solo afecta la impresión ORIGINAL (antes de ordenar).
    }

    /**
     * Copia recursivamente los elementos de una lista enlazada a un arreglo
     * @param aux    referencia actual en la lista
     * @param arreglo arreglo destino
     * @param indice posición actual en el arreglo
     * @param n      tamaño máximo del arreglo (caso base)
     */
    private static void listaAArregloRecursivo(TadLista<String> aux,
                                               String[] arreglo,
                                               int indice,
                                               int n) {
        // CASO BASE: si ya copiamos todos los elementos
        if (indice >= n) {
            return;
        }

        // CASO RECURSIVO: copiar elemento actual y avanzar
        arreglo[indice] = aux.devolverClave();               // leer valor del nodo actual
        aux.asignarReferencia(aux.devolverSiguiente());      // avanzar al siguiente nodo
        listaAArregloRecursivo(aux, arreglo, indice + 1, n); // llamada recursiva
    }

    /**
     * Vacía recursivamente una lista eliminando el primer nodo n veces
     * @param lista lista a vaciar
     * @param n     cantidad de nodos a eliminar
     */
    private static void vaciarListaRecursivo(TadLista<String> lista, int n) {
        // CASO BASE: si ya eliminamos todos los nodos
        if (n <= 0) {
            return;
        }

        // CASO RECURSIVO: eliminar el primer nodo y continuar
        AlgoritmosListas.eliminarPrimero(lista);      // elimina un nodo
        vaciarListaRecursivo(lista, n - 1);           // llamada recursiva
    }

    /**
     * Reconstruye recursivamente una lista insertando elementos de un arreglo al final
     * @param lista lista destino
     * @param arreglo arreglo origen
     * @param indice posición actual en el arreglo
     * @param n      tamaño del arreglo (caso base)
     */
    private static void arregloAListaRecursivo(TadLista<String> lista,
                                               String[] arreglo,
                                               int indice,
                                               int n) {
        // CASO BASE: si ya insertamos todos los elementos
        if (indice >= n) {
            return;
        }

        // CASO RECURSIVO: insertar elemento actual y continuar
        AlgoritmosListas.insertarAlFinal(lista, arreglo[indice]); // insertar elemento
        arregloAListaRecursivo(lista, arreglo, indice + 1, n);    // llamada recursiva
    }
}
