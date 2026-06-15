package AlgoritmosArboles;

import Arboles.Arbol;
import Arboles.ArbolBB;
import Arboles.NodoArbol;

public class AlgoritmosArboles<T extends Comparable<T>> {

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
}
