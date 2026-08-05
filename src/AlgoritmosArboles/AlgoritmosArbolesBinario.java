package AlgoritmosArboles;

import Arboles.Arbol;
import Arboles.NodoArbol;

public class AlgoritmosArbolesBinario<T extends Comparable<T>> {

    public static <T> int contarNodos(Arbol arbol) {
        int total = 0;
        if (arbol != null) { // si arbol existe
            if (arbol.getRaiz() != null) { // si arbol no esta vacio
                total = contarNodosR(arbol.getRaiz());
            }
        }
        return (1 + total); // 1 + por la raiz
    }

    private static <T> int contarNodosR(NodoArbol nodo) {
        int countN = 0;

        if (!(nodo == null)) {

            if (nodo.getIz() != null) {
                countN = (countN + 1) + contarNodosR(nodo.getIz());
            }

            if (nodo.getDe() != null) {
                countN = (countN + 1) + contarNodosR(nodo.getDe());
            }
        }

        return countN;
    }

    public static <T> int contarHojas(Arbol arbol) {
        int cant = 0;
        int count = 0;

        if (arbol != null) {
            if (arbol.getRaiz() != null)
                cant = contarHojasR(arbol.getRaiz(), count);
        }

        return cant;
    }

    private static <T> int contarHojasR(NodoArbol nodo, int count) {

        if (nodo != null) {
            if (nodo.getIz() == null && nodo.getDe() == null) {
                count = count + 1;
            } else {

                // nodo izquierdo existe?
                if (nodo.getIz() != null) {
                    count = contarHojasR(nodo.getIz(), count);
                }

                // nodo derecho existe?
                if (nodo.getDe() != null) {
                    count = contarHojasR(nodo.getDe(), count);
                }
            }
        }

        return count;
    }

    public static <T> int altura(Arbol arbol) {
        int altura = 0;
        if (arbol != null) {
            altura = alturaR(arbol.getRaiz());
        }

        return altura;
    }

    private static <T> int alturaR(NodoArbol nodo) {
        int alto = 0;
        if (nodo != null) {

            alto = 1 + Math.max(alturaR(nodo.getIz()), alturaR(nodo.getDe()));
        }

        return alto;
    }

    public static <T extends Comparable<T>> boolean buscar(Arbol<T> arbol, T dato) {
        boolean encontrado = false;
        if (arbol != null && arbol.getRaiz() != null) {
            encontrado = buscarR(arbol.getRaiz(), dato);
        }

        return encontrado;
    }

    private static <T extends Comparable<T>> boolean buscarR(NodoArbol<T> nodo, T dato) {
        boolean encontrado = false;

        if (nodo != null) {
            if (nodo.getClave().compareTo(dato) == 0) {
                encontrado = true;
            } else {
                encontrado = buscarR(nodo.getIz(), dato);

                if (!encontrado) {
                    encontrado = buscarR(nodo.getDe(), dato);
                }
            }
        }

        return encontrado;
    }

    public static <T extends Comparable<T>> void imprimirHojas(Arbol<T> arbol) {
        if (arbol != null) {
            if (arbol.getRaiz() != null) {
                imprimirHojasR(arbol.getRaiz());
            }
        }
    }

    private static <T extends Comparable<T>> void imprimirHojasR(NodoArbol<T> nodo) {
        if (nodo != null) {

            if (nodo.getIz() == null && nodo.getDe() == null) {
                System.out.println(nodo.getClave());
            } else {
                imprimirHojasR(nodo.getIz());
                imprimirHojasR(nodo.getDe());
            }
        }
    }

    public static <T extends Comparable<T>> boolean esHoja(Arbol<T> arbol, T dato) {
        boolean result = false;
        if (arbol != null) {
            if (arbol.getRaiz() != null) {
                result = esHojaR(arbol.getRaiz(), dato);
            }
        }

        return result;
    }

    private static <T extends Comparable<T>> boolean esHojaR(NodoArbol<T> nodo, T dato) {
        boolean resul = false;
        if (nodo != null) {
            // si la clave del nodo es igual al dato
            if (nodo.getClave().compareTo(dato) == 0) {
                if (nodo.getIz() == null && nodo.getDe() == null) { // si es hoja
                    resul = true;
                }
                // si no, sigo buscando en las claves de los hijos para saber si el dato es
                // igual.
            } else {
                resul = esHojaR(nodo.getIz(), dato); // busca en rama izquierda
                if (!resul) { // si no encontro en rama izquierda, busca en derecha
                    resul = esHojaR(nodo.getDe(), dato);
                }
            }
        }

        return resul;
    }

    public static <T extends Comparable<T>> int contar(Arbol<T> arbol) {
        int resul = 0;
        int count = 0;

        if (arbol == null) {
            resul = -1;
        } else {
            if (arbol.getRaiz() == null) {
                resul = 0;
            } else {
                resul = contarR(arbol.getRaiz(), count);
            }
        }

        return resul;
    }

    private static <T extends Comparable<T>> int contarR(NodoArbol<T> nodo, int count) {
        if (nodo != null) {
            count = count + 1;
            count = contarR(nodo.getIz(), count); // pasa el count a nodo.getIz()
            count = contarR(nodo.getDe(), count); // pasa el count a nodo.getDe()
        }
        return count;
    }

    public static <T extends Comparable<T>> T aleatorio(Arbol<T> arbol) {
        T resul = null;
        int total = 0;
        int index = 0;

        if (arbol != null) {
            if (arbol.getRaiz() != null) {
                total = contar(arbol);
                index = Algoritmos.Algoritmos.aleatorio(0, total - 1); // elige un indice al azar
                resul = aleatorioR(arbol.getRaiz(), index); // busca el  elemento
            }
        }

        return resul;
    }

    private static <T extends Comparable<T>> T aleatorioR(NodoArbol<T> nodo, int index) {
        int cantIzquierda = 0;
        T resul = null;
        if (nodo != null) {
            cantIzquierda = contarR(nodo.getIz(), 0); // cuenta los nodos de la rama izquierda
            if (index < cantIzquierda) {
                resul = aleatorioR(nodo.getIz(), index); // busca en la izquierda de la rama del arbol
            }

            if (index == cantIzquierda) {
                resul = nodo.getClave();
            }

            if (index > cantIzquierda) {
                resul = aleatorioR(nodo.getDe(), index - cantIzquierda - 1); // busca en la derecha y resta el indice descontando los nodos ya explorados con el nodo actual (-1).
            }
        }

        return resul;
    }

}
