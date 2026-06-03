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

        // ── 4. LISTA → ARREGLO ───────────────────────────────────────────────
        int n = AlgoritmosListas.contar(palabras);  // cuenta cuántos nodos tiene
        String[] arreglo = new String[n];           // arreglo del mismo tamaño

        // TRUCO CLAVE: crear un TadLista auxiliar que apunte al primer nodo
        // así recorremos la lista SIN mover el puntero original de 'palabras'
        TadLista<String> aux = new TadLista<>();
        aux.asignarReferencia(palabras.devolverReferencia()); // aux → primer nodo

        for (int i = 0; i < n; i++) {
            arreglo[i] = aux.devolverClave();               // leer valor del nodo actual
            aux.asignarReferencia(aux.devolverSiguiente()); // avanzar al siguiente nodo
        }

        // ── 5. APLICAR INSERTION SORT ────────────────────────────────────────
        // Ordenacion.insercion trabaja sobre arreglos genéricos T[]
        // Strings se comparan con compareTo → orden alfabético
        Ordenacion.insercion(arreglo);
        // arreglo ahora: ["apple", "banana", "kiwi", "mango", "uva"]

        // ── 6. VACIAR LA LISTA ───────────────────────────────────────────────
        // eliminarPrimero desconecta el primer nodo (lista.inicio = lista.inicio.sig)
        for (int i = 0; i < n; i++) {
            AlgoritmosListas.eliminarPrimero(palabras);
        }

        // ── 7. RECONSTRUIR LISTA DESDE ARREGLO ORDENADO ──────────────────────
        // insertarAlFinal mantiene el orden del arreglo
        for (int i = 0; i < n; i++) {
            AlgoritmosListas.insertarAlFinal(palabras, arreglo[i]);
        }

        // ── 8. IMPRIMIR LISTA ORDENADA ───────────────────────────────────────
        System.out.println("=== Lista ordenada (alfabéticamente) ===");
        AlgoritmosListas.imprimirLista(palabras);
        System.out.println();

        // REFLEXIÓN: ¿insertarAlPrincipio vs insertarAlFinal antes de ordenar?
        // → Da igual, porque el ordenamiento trabaja sobre el ARREGLO, no sobre la lista.
        //   La diferencia solo afecta la impresión ORIGINAL (antes de ordenar).
    }
}
