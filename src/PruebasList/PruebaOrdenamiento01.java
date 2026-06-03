package PruebasList;

import Algoritmos.Ordenacion;
import AlgoritmosListas.AlgoritmosListas;
import List.TadLista;
import List.Lista;

public class PruebaOrdenamiento01 {

    public static void main(String[] args) {

        // ── PASO 1: Crear la lista ──────────────────────────────────────────
        TadLista<Integer> numeros = new TadLista<>("numeros");

        // ── PASO 2: Insertar los datos AL FINAL en este orden ───────────────
        // Valores: 42, 15, 8, 73, 27, 5, 61
        // TODO: usa AlgoritmosListas.insertarAlFinal(numeros, valor);
        AlgoritmosListas.insertarAlFinal(numeros, 42);
        AlgoritmosListas.insertarAlFinal(numeros, 15);
        AlgoritmosListas.insertarAlFinal(numeros, 8);
        AlgoritmosListas.insertarAlFinal(numeros, 73);
        AlgoritmosListas.insertarAlFinal(numeros, 27);
        AlgoritmosListas.insertarAlFinal(numeros, 5);
        AlgoritmosListas.insertarAlFinal(numeros, 61);


        // ── PASO 3: Imprimir la lista ANTES de ordenar ──────────────────────
        System.out.println("=== Antes de ordenar ===");
        // TODO: usa AlgoritmosListas.imprimirLista(numeros);
        numeros.imprimirLista();


        // ── PASO 4: Pasar la lista a un arreglo Integer[] ───────────────────
        int n = AlgoritmosListas.contar(numeros);
        Integer[] arreglo = new Integer[n];
        Lista<Integer> aux = new TadLista<>();
        aux.asignarReferencia(numeros.devolverReferencia());
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = aux.devolverClave();
            aux.asignarReferencia(aux.devolverSiguiente());
            if(aux.esNulo()){
                i = arreglo.length;
            }
        }
        // TODO: Recorre la lista y llena el arreglo
        // Pista: usa una TadLista auxiliar + un índice i



        // ── PASO 5: Aplicar bubbleSort sobre el arreglo ─────────────────────
        Ordenacion.bubbleSort(arreglo);


        // ── PASO 6: Reconstruir la lista desde el arreglo ordenado ──────────
        // Primero vaciar la lista eliminando nodo a nodo
        // TODO: usa un bucle con AlgoritmosListas.eliminarPrimero(numeros)
        vaciarLista(numeros);

        // Luego insertar desde el arreglo ya ordenado
        // TODO: usa AlgoritmosListas.insertarAlFinal(numeros, arreglo[i])
        reconstruirLista(numeros, arreglo, 0);


        // ── PASO 7: Imprimir la lista DESPUÉS de ordenar ────────────────────
        System.out.println("=== Después de ordenar ===");
        // TODO: usa AlgoritmosListas.imprimirLista(numeros);
        numeros.imprimirLista();
    }

    public static<T> void vaciarLista(Lista<T> lista){
        if(!lista.esNulo()){
            AlgoritmosListas.eliminarPrimero(lista);
            vaciarLista(lista);
        }else{
            System.out.println("La Lista Quedo Vacia");
        }
    }

    public static <T> void reconstruirLista(Lista<T> lista, T[] arreglo, int count){
                if(count >= 0 && count < arreglo.length) {
                    AlgoritmosListas.insertarAlFinal(lista, arreglo[count]);
                    reconstruirLista(lista, arreglo, count + 1);
                }else{
                    System.out.println("Lista Reconstruida");
                }

            }
    }

