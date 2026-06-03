package PruebasList;

import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

/**
 * EJERCICIO 7 — InsertionSort directamente sobre NODOS de la lista
 * ──────────────────────────────────────────────────────────────────
 * DIFERENCIA CLAVE respecto a los ejercicios anteriores:
 *   - Ej 1-6: convertimos a arreglo, ordenamos, reconstruimos (patrón seguro)
 *   - Este ejercicio: ordenamos INTERCAMBIANDO CLAVES dentro de los nodos
 *                     sin convertir a arreglo nunca
 *
 * ALGORITMO InsertionSort sobre lista:
 *   - Tenemos una "sublista ordenada" (izquierda) y una "sin ordenar" (derecha)
 *   - Tomamos el primer nodo de la parte desordenada
 *   - Lo "insertamos" en la posición correcta intercambiando claves hacia atrás
 *   - Repetimos hasta que toda la lista esté ordenada
 *
 * VENTAJA: no necesitamos arreglo auxiliar ni contar nodos.
 * LIMITACIÓN: solo funciona intercambiando claves (no reordena nodos físicamente).
 *
 * PARA EL EXAMEN: si te piden ordenar SIN arreglo auxiliar, usa este patrón.
 */
public class PruebaOrdenamiento07 {

    public static void main(String[] args) {

        // ── CREAR Y LLENAR LA LISTA ───────────────────────────────────────────
        TadLista<Integer> lista = new TadLista<>("lista");
        AlgoritmosListas.insertarAlFinal(lista, 33);
        AlgoritmosListas.insertarAlFinal(lista, 10);
        AlgoritmosListas.insertarAlFinal(lista, 55);
        AlgoritmosListas.insertarAlFinal(lista, 2);
        AlgoritmosListas.insertarAlFinal(lista, 48);
        AlgoritmosListas.insertarAlFinal(lista, 17);

        System.out.println("=== Lista original ===");
        AlgoritmosListas.imprimirLista(lista);
        System.out.println();

        // ── APLICAR INSERTION SORT DIRECTO SOBRE NODOS ───────────────────────
        insertionSortLista(lista);

        System.out.println("=== Lista ordenada (InsertionSort sobre nodos) ===");
        AlgoritmosListas.imprimirLista(lista);
    }

    /**
     * InsertionSort intercambiando CLAVES de los nodos (sin arreglo auxiliar)
     * ─────────────────────────────────────────────────────────────────────────
     * VISUALIZACIÓN paso a paso con [33, 10, 55, 2, 48, 17]:
     *
     *   i apunta al nodo "clave" (el que queremos insertar en la sublista ordenada)
     *   j retrocede desde i comparando e intercambiando
     *
     *   Pasada 1 (i=nodo10): clave=10 < 33 → intercambiar → [10, 33, 55, 2, 48, 17]
     *   Pasada 2 (i=nodo55): clave=55 > 33 → sin cambio   → [10, 33, 55, 2, 48, 17]
     *   Pasada 3 (i=nodo2):  clave=2  < 55 → intercambiar ... → [2, 10, 33, 55, 48, 17]
     *   ... y así sucesivamente
     */
    public static <T extends Comparable<T>> void insertionSortLista(TadLista<T> lista) {

        if (lista.esNulo()) return; // lista vacía, nada que ordenar

        // PUNTERO "i": recorre los nodos desde el SEGUNDO hasta el final
        // Representa el elemento que vamos a insertar en la sublista ordenada
        TadLista<T> i = new TadLista<>();
        i.asignarReferencia(lista.devolverSiguiente()); // empezamos en el segundo nodo

        while (!i.esNulo()) { // mientras haya nodos sin procesar

            // PUNTERO "j": retrocede desde i hacia el inicio
            // Compara j-1 con j e intercambia si están en orden incorrecto
            TadLista<T> j = new TadLista<>();
            j.asignarReferencia(i.devolverReferencia()); // j empieza donde está i

            // Retroceder mientras haya nodo anterior Y la clave anterior sea mayor
            // Usamos un puntero "anterior" para poder comparar con el nodo previo
            TadLista<T> jAnterior = new TadLista<>();
            jAnterior.asignarReferencia(lista.devolverReferencia()); // jAnterior empieza al inicio

            // Avanzar jAnterior hasta que su SIGUIENTE sea j
            // (necesitamos el nodo ANTERIOR para poder intercambiar claves)
            while (jAnterior.devolverSiguiente() != null &&
                   jAnterior.devolverSiguiente() != j.devolverReferencia()) {
                jAnterior.asignarReferencia(jAnterior.devolverSiguiente());
            }

            // RETROCEDER: mientras jAnterior exista y su clave > clave de j
            while (!jAnterior.esNulo() && !j.esNulo() &&
                   jAnterior.devolverClave().compareTo(j.devolverClave()) > 0) {

                // INTERCAMBIAR claves entre nodo anterior y nodo actual
                T temp = jAnterior.devolverClave();
                jAnterior.asignarClave(j.devolverClave());
                j.asignarClave(temp);

                // Retroceder j y jAnterior una posición
                j.asignarReferencia(jAnterior.devolverReferencia());

                // Reubicar jAnterior: debe apuntar al nodo ANTES de j (nuevo)
                // Buscamos desde el inicio de la lista
                TadLista<T> temp2 = new TadLista<>();
                temp2.asignarReferencia(lista.devolverReferencia());
                TadLista<T> nuevoAnterior = new TadLista<>();

                while (temp2.devolverReferencia() != j.devolverReferencia()) {
                    nuevoAnterior.asignarReferencia(temp2.devolverReferencia());
                    temp2.asignarReferencia(temp2.devolverSiguiente());
                }

                // Si no hay nodo anterior → j llegó al inicio, detenerse
                if (nuevoAnterior.esNulo()) break;
                jAnterior.asignarReferencia(nuevoAnterior.devolverReferencia());
            }

            // Avanzar i al siguiente nodo sin ordenar
            i.asignarReferencia(i.devolverSiguiente());
        }
    }
}
