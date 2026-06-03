package PruebasList;

import Algoritmos.Ordenacion;
import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;

/**
 * EJERCICIO 4 — Lista de estudiantes ordenada por nota (InsertionSort)
 * ─────────────────────────────────────────────────────────────────────
 * CONCEPTO NUEVO: Ordenar OBJETOS propios (no solo Integer/String).
 *
 * REQUISITO: la clase del objeto DEBE implementar Comparable<T>
 * → ver Estudiante.java donde compareTo ordena por nota ascendente
 *
 * PATRÓN IDÉNTICO al Ejercicio 1, solo cambia el tipo T:
 *   Integer → Estudiante
 *   bubbleSort → insercion  (InsertionSort es más eficiente en listas casi ordenadas)
 */
public class PruebaOrdenamiento04 {

    public static void main(String[] args) {

        // ── 1. CREAR LA LISTA ────────────────────────────────────────────────
        TadLista<Estudiante> salon = new TadLista<>("salon");

        // ── 2. INSERTAR LOS ESTUDIANTES AL FINAL ─────────────────────────────
        // insertarAlFinal → los nodos quedan en el mismo orden de inserción
        AlgoritmosListas.insertarAlFinal(salon, new Estudiante("Ana",   8.5));
        AlgoritmosListas.insertarAlFinal(salon, new Estudiante("Luis",  6.0));
        AlgoritmosListas.insertarAlFinal(salon, new Estudiante("Maria", 9.2));
        AlgoritmosListas.insertarAlFinal(salon, new Estudiante("Pedro", 7.1));
        AlgoritmosListas.insertarAlFinal(salon, new Estudiante("Sofia", 5.8));
        AlgoritmosListas.insertarAlFinal(salon, new Estudiante("Jorge", 8.9));

        // ── 3. IMPRIMIR ANTES DE ORDENAR ─────────────────────────────────────
        System.out.println("=== Salón sin ordenar ===");
        AlgoritmosListas.imprimirLista(salon);
        // Llama a Estudiante.toString() automáticamente para cada nodo
        System.out.println();

        // ── 4. LISTA → ARREGLO ───────────────────────────────────────────────
        // PATRÓN FIJO (mismo en todos los ejercicios):
        //   contar → new T[n] → aux apunta a inicio → for: leer clave + avanzar
        int n = AlgoritmosListas.contar(salon);
        Estudiante[] arreglo = new Estudiante[n];   // tipo cambia, lógica igual

        TadLista<Estudiante> aux = new TadLista<>();
        aux.asignarReferencia(salon.devolverReferencia()); // aux → primer nodo

        for (int i = 0; i < n; i++) {
            arreglo[i] = aux.devolverClave();               // guardar referencia al objeto
            aux.asignarReferencia(aux.devolverSiguiente()); // avanzar nodo
        }

        // ── 5. APLICAR INSERTION SORT ────────────────────────────────────────
        // Ordenacion.insercion usa compareTo() de Estudiante internamente
        // → compara notas y coloca en orden ascendente
        Ordenacion.insercion(arreglo);
        // arreglo ahora: Sofia(5.8), Luis(6.0), Pedro(7.1), Ana(8.5), Jorge(8.9), Maria(9.2)

        // ── 6. VACIAR LISTA ───────────────────────────────────────────────────
        // eliminarPrimero: lista.inicio = lista.inicio.sig  (desconecta la cabeza)
        for (int i = 0; i < n; i++) {
            AlgoritmosListas.eliminarPrimero(salon);
        }

        // ── 7. RECONSTRUIR LISTA ORDENADA ────────────────────────────────────
        for (int i = 0; i < n; i++) {
            AlgoritmosListas.insertarAlFinal(salon, arreglo[i]);
        }

        // ── 8. IMPRIMIR RANKING ───────────────────────────────────────────────
        System.out.println("=== Ranking (menor a mayor nota) ===");

        // Recorremos la lista para imprimir con numeración
        TadLista<Estudiante> aux2 = new TadLista<>();
        aux2.asignarReferencia(salon.devolverReferencia());

        int posicion = 1;
        while (!aux2.esNulo()) {
            Estudiante e = aux2.devolverClave();
            // printf para alinear columnas: %-10s = izquierda, 10 caracteres
            System.out.printf("%d. %-10s → %.1f%n", posicion, e.getNombre(), e.getNota());
            aux2.asignarReferencia(aux2.devolverSiguiente());
            posicion++;
        }
    }
}
