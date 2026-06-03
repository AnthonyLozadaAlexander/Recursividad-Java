package AlgoritmosListas;

import listaCalificadaOrdenada.Lista;
import listaCalificadaOrdenada.NodoLista;

public class AlgoritmosListasOrdenadosCalificados {

    private AlgoritmosListasOrdenadosCalificados() {
        // clase de utilidades
    }

    // =========================
    // CREATE
    // =========================

    public static <T extends Comparable<T>> boolean insertarOrdenado(Lista<T> lista, T dato) {
        boolean res = false;
        if (lista != null && dato != null) {
            if (!buscar(lista, dato)) {
                lista.insertar(dato);
                res = true;
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> boolean copiarLista(Lista<T> origen, Lista<T> destino) {
        boolean res = false;
        if (origen != null && destino != null) {
            copiarListaR(origen.getInicio(), destino);
            res = true;
        }
        return res;
    }

    private static <T extends Comparable<T>> void copiarListaR(NodoLista<T> nodo, Lista<T> destino) {
        if (nodo != null) {
            destino.insertar(nodo.getClave());
            copiarListaR(nodo.getSig(), destino);
        }
    }

    // =========================
    // READ
    // =========================

    public static <T extends Comparable<T>> boolean buscar(Lista<T> lista, T dato) {
        boolean res = false;
        if (lista != null && dato != null) {
            res = buscarR(lista.getInicio(), dato);
        }
        return res;
    }

    private static <T extends Comparable<T>> boolean buscarR(NodoLista<T> nodo, T dato) {
        boolean res = false;
        if (nodo != null) {
            int comparacion = nodo.getClave().compareTo(dato);
            if (comparacion == 0) {
                res = true;
            } else if (comparacion < 0) {
                res = buscarR(nodo.getSig(), dato);
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> int contar(Lista<T> lista) {
        int res = 0;
        if (lista != null) {
            res = contarR(lista.getInicio());
        }
        return res;
    }

    private static <T extends Comparable<T>> int contarR(NodoLista<T> nodo) {
        int res = 0;
        if (nodo != null) {
            res = 1 + contarR(nodo.getSig());
        }
        return res;
    }

    public static <T extends Comparable<T>> T leerEnPosicion(Lista<T> lista, int posicion) {
        T res = null;
        if (lista != null && posicion >= 1) {
            res = leerEnPosicionR(lista.getInicio(), posicion, 1);
        }
        return res;
    }

    private static <T extends Comparable<T>> T leerEnPosicionR(NodoLista<T> nodo, int objetivo, int actual) {
        T res = null;
        if (nodo != null) {
            if (actual == objetivo) {
                res = nodo.getClave();
            } else {
                res = leerEnPosicionR(nodo.getSig(), objetivo, actual + 1);
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> T obtenerPrimero(Lista<T> lista) {
        T res = null;
        if (lista != null && lista.getInicio() != null) {
            res = lista.getInicio().getClave();
        }
        return res;
    }

    public static <T extends Comparable<T>> T obtenerUltimo(Lista<T> lista) {
        T res = null;
        if (lista != null) {
            res = obtenerUltimoR(lista.getInicio());
        }
        return res;
    }

    private static <T extends Comparable<T>> T obtenerUltimoR(NodoLista<T> nodo) {
        T res = null;
        if (nodo != null) {
            if (nodo.getSig() == null) {
                res = nodo.getClave();
            } else {
                res = obtenerUltimoR(nodo.getSig());
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> T obtenerMenor(Lista<T> lista) {
        T res = obtenerPrimero(lista);
        return res;
    }

    public static <T extends Comparable<T>> T obtenerMayor(Lista<T> lista) {
        T res = obtenerUltimo(lista);
        return res;
    }

    // =========================
    // UPDATE
    // =========================

    public static <T extends Comparable<T>> boolean actualizarPorValor(Lista<T> lista, T viejo, T nuevo) {
        boolean res = false;
        if (lista != null && viejo != null && nuevo != null) {
            if (buscar(lista, viejo)) {
                if (viejo.compareTo(nuevo) == 0) {
                    res = true;
                } else if (!buscar(lista, nuevo)) {
                    lista.eliminar(viejo);
                    lista.insertar(nuevo);
                    res = true;
                }
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> boolean actualizarEnPosicion(Lista<T> lista, int posicion, T nuevo) {
        boolean res = false;
        if (lista != null && nuevo != null && posicion >= 1) {
            T actual = leerEnPosicion(lista, posicion);
            if (actual != null) {
                res = actualizarPorValor(lista, actual, nuevo);
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> boolean limpiarYReinsertar(Lista<T> lista, T dato) {
        boolean res = false;
        if (lista != null && dato != null) {
            if (buscar(lista, dato)) {
                lista.eliminar(dato);
                lista.insertar(dato);
                res = true;
            }
        }
        return res;
    }

    // =========================
    // DELETE
    // =========================

    public static <T extends Comparable<T>> boolean eliminarPorValor(Lista<T> lista, T dato) {
        boolean res = false;
        if (lista != null && dato != null) {
            if (buscar(lista, dato)) {
                lista.eliminar(dato);
                res = true;
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> boolean eliminarPrimero(Lista<T> lista) {
        boolean res = false;
        if (lista != null && lista.getInicio() != null) {
            lista.eliminar(lista.getInicio().getClave());
            res = true;
        }
        return res;
    }

    public static <T extends Comparable<T>> boolean eliminarUltimo(Lista<T> lista) {
        boolean res = false;
        if (lista != null && lista.getInicio() != null) {
            T ultimo = obtenerUltimo(lista);
            if (ultimo != null) {
                lista.eliminar(ultimo);
                res = true;
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> boolean eliminarMenoresQue(Lista<T> lista, T limite) {
        boolean res = false;
        if (lista != null && limite != null) {
            res = eliminarMenoresQueR(lista, limite);
        }
        return res;
    }

    private static <T extends Comparable<T>> boolean eliminarMenoresQueR(Lista<T> lista, T limite) {
        boolean res = false;
        if (lista != null && lista.getInicio() != null) {
            if (lista.getInicio().getClave().compareTo(limite) < 0) {
                lista.eliminar(lista.getInicio().getClave());
                res = true;
                if (lista.getInicio() != null && lista.getInicio().getClave().compareTo(limite) < 0) {
                    res = eliminarMenoresQueR(lista, limite) || res;
                }
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> boolean eliminarMayoresQue(Lista<T> lista, T limite) {
        boolean res = false;
        if (lista != null && limite != null) {
            res = eliminarMayoresQueR(lista, limite);
        }
        return res;
    }

    private static <T extends Comparable<T>> boolean eliminarMayoresQueR(Lista<T> lista, T limite) {
        boolean res = false;
        if (lista != null && lista.getInicio() != null) {
            if (lista.getInicio().getClave().compareTo(limite) > 0) {
                lista.eliminar(lista.getInicio().getClave());
                res = true;
                if (lista.getInicio() != null && lista.getInicio().getClave().compareTo(limite) > 0) {
                    res = eliminarMayoresQueR(lista, limite) || res;
                }
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> boolean eliminarRango(Lista<T> lista, T minimo, T maximo) {
        boolean res = false;
        if (lista != null && minimo != null && maximo != null) {
            if (minimo.compareTo(maximo) <= 0) {
                res = eliminarRangoR(lista, minimo, maximo);
            }
        }
        return res;
    }

    private static <T extends Comparable<T>> boolean eliminarRangoR(Lista<T> lista, T minimo, T maximo) {
        boolean res = false;
        if (lista != null && lista.getInicio() != null) {
            T actual = lista.getInicio().getClave();
            if (actual.compareTo(maximo) > 0) {
                res = false;
            } else if (actual.compareTo(minimo) < 0) {
                res = eliminarRangoR(lista, minimo, maximo);
            } else {
                lista.eliminar(actual);
                res = true;
                if (lista.getInicio() != null) {
                    res = eliminarRangoR(lista, minimo, maximo) || res;
                }
            }
        }
        return res;
    }

    // =========================
    // UTILIDADES DE EXAMEN
    // =========================

    public static <T extends Comparable<T>> boolean contieneSoloValoresMayoresQue(Lista<T> lista, T limite) {
        boolean res = false;
        if (lista != null && limite != null) {
            res = contieneSoloValoresMayoresQueR(lista.getInicio(), limite);
        }
        return res;
    }

    private static <T extends Comparable<T>> boolean contieneSoloValoresMayoresQueR(NodoLista<T> nodo, T limite) {
        boolean res = true;
        if (nodo != null) {
            if (nodo.getClave().compareTo(limite) <= 0) {
                res = false;
            } else {
                res = contieneSoloValoresMayoresQueR(nodo.getSig(), limite);
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> boolean estaOrdenada(Lista<T> lista) {
        boolean res = false;
        if (lista != null) {
            res = estaOrdenadaR(lista.getInicio());
        }
        return res;
    }

    private static <T extends Comparable<T>> boolean estaOrdenadaR(NodoLista<T> nodo) {
        boolean res = true;
        if (nodo != null && nodo.getSig() != null) {
            if (nodo.getClave().compareTo(nodo.getSig().getClave()) >= 0) {
                res = false;
            } else {
                res = estaOrdenadaR(nodo.getSig());
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> int contarMayoresQue(Lista<T> lista, T limite) {
        int res = 0;
        if (lista != null && limite != null) {
            res = contarMayoresQueR(lista.getInicio(), limite);
        }
        return res;
    }

    private static <T extends Comparable<T>> int contarMayoresQueR(NodoLista<T> nodo, T limite) {
        int res = 0;
        if (nodo != null) {
            res = contarMayoresQueR(nodo.getSig(), limite);
            if (nodo.getClave().compareTo(limite) > 0) {
                res = res + 1;
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> int contarMenoresQue(Lista<T> lista, T limite) {
        int res = 0;
        if (lista != null && limite != null) {
            res = contarMenoresQueR(lista.getInicio(), limite);
        }
        return res;
    }

    private static <T extends Comparable<T>> int contarMenoresQueR(NodoLista<T> nodo, T limite) {
        int res = 0;
        if (nodo != null) {
            if (nodo.getClave().compareTo(limite) < 0) {
                res = 1 + contarMenoresQueR(nodo.getSig(), limite);
            } else {
                res = contarMenoresQueR(nodo.getSig(), limite);
            }
        }
        return res;
    }

}
