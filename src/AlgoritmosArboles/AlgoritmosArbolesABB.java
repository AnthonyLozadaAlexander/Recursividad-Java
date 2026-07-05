package AlgoritmosArboles;

import Arboles.Arbol;
import Arboles.NodoArbol;

public class AlgoritmosArbolesABB<T extends Comparable<T>> {

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
                return count;
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



}
