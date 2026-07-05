package AlgoritmosArboles;

import Arboles.Arbol;
import Arboles.NodoArbol;

public class AlgoritmosArbolesBinario<T extends Comparable<T>> {

    public static <T> int contarNodos(Arbol arbol){
        if(arbol.getRaiz() == null){
            return 0;
        }else {
            int total = contarNodosR(arbol.getRaiz());
            return (1 + total); // 1 + por la raiz
        }
    }

    private static <T> int contarNodosR(NodoArbol nodo){
        int countN = 0;

        if(nodo == null){
            return 0;
        }else{
            if(nodo.getIz() != null){
                countN = (countN + 1) + contarNodosR(nodo.getIz());
            }else{

            }
            if(nodo.getDe() != null){
                countN = (countN + 1) + contarNodosR(nodo.getDe());
            }
        }

        return countN;
    }

    public static <T> int contarHojas(Arbol arbol){
        int cant = 0;
        int count = 0;

        if(arbol != null) {
            cant = contarHojasR(arbol.getRaiz(), count);
        }

        return cant;
    }

    private static <T> int contarHojasR(NodoArbol nodo, int count){

            if(nodo == null){
                return 0;
            }

            if(nodo.getIz() == null && nodo.getDe() == null){
                count = count + 1;
            }else{

                // nodo izquierdo es hoja?
                if(nodo.getIz() != null){
                    count = contarHojasR(nodo.getIz(), count);
                }

                // nodo derecho es hoja?
                if(nodo.getDe() != null){
                    count = contarHojasR(nodo.getDe(), count);
                }
            }

        return count;
    }

    public static <T> int altura(Arbol arbol){
        int altura = 0;
        if(arbol != null){
            altura = alturaR(arbol.getRaiz());
        }

        return  altura;
    }

    private static <T> int alturaR(NodoArbol nodo){
        int alto = 0;
        if(nodo != null){

            alto = 1 + Math.max(alturaR(nodo.getIz()), alturaR(nodo.getDe()));
        }

        return alto;
    }

    public static <T extends Comparable<T>> boolean buscar(Arbol<T> arbol, T  dato){
        boolean encontrado = false;
        if(arbol != null && arbol.getRaiz() != null){
             encontrado = buscarR(arbol.getRaiz(), dato);
         }

        return encontrado;
    }

    private static <T extends Comparable<T>> boolean buscarR(NodoArbol<T> nodo, T dato){
        boolean encontrado = false;

        if(nodo != null) {

            if (nodo.getClave().compareTo(dato) == 0) {
                encontrado = true;
            }else {
                encontrado = buscarR(nodo.getIz(), dato);

                if (!encontrado) {
                    encontrado = buscarR(nodo.getDe(), dato);
                }
            }
        }

        return encontrado;
    }




}
