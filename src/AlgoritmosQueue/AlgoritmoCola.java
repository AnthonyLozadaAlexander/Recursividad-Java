package AlgoritmosQueue;

import java.util.ArrayList;

import Queue.*;

public class AlgoritmoCola<T> {

    public static <T> void invertirCola(Cola<T> cola) throws ColaVacia {
        Cola<T> aux;
        aux = cola;

        if (!cola.colaVacia()) {
            T elem = aux.desencolar();
            invertirCola(aux);
            aux.encolar(elem);
        }
    }

    // (4) -> (5) -> (6) -> (9)
    // (9) -> (6) -> (5) -> (4)

    public static <T> void ultimoAPrimero(Cola<T> cola) throws ColaVacia {
        T elem = ultimoAPrimeroR(cola);
        cola.encolar(elem);
        cola.invertirCola();

    }

    private static <T> T ultimoAPrimeroR(Cola<T> cola) throws ColaVacia {
        Cola<T> aux;
        aux = cola;
        T resul = null; // variable generica para guardar

        if (!cola.colaVacia()) {
            T elem = aux.desencolar(); // desencolamos la cola
            if (cola.colaVacia()) {
                resul = elem; // guardamos el ultimo elemento de la cola
            } else {
                resul = ultimoAPrimeroR(aux); // invocacion recursiva
                cola.encolar(elem); // volver a encolar la cola
            }
        }

        return resul; // retorna el ultimo elemento de la cola

    }

    public static <T> int contarElementsR(Cola<T> cola, int count) throws ColaVacia {
        Cola<T> aux;
        aux = cola;

        if (aux.colaVacia()) {
            return 0;
        }

        T guardar = aux.desencolar();
        count = 1 + contarElementsR(aux, count);
        aux.encolar(guardar);

        return count;
    }

    public static int contarParesCola(Cola<Integer> c) throws ColaVacia {
        Integer count = 0;
        Integer primero;
        if (c.colaVacia()) {
            return 0;
        }

        primero = c.desencolar();
        if (primero % 2 == 0) {
            count = 1 + contarParesCola(c);

        } else {
            count = 0 + contarParesCola(c);
        }

        c.encolar(primero);

        return count;

    }

    // (1) -> (2) -> (3) -> (4)
    // (4) -> (1) -> (2) -> (3)

    /*
     * guardar = c.desencolar();
     * if(c.colaVacia()){
     * ultimo = guardar;
     * c.encolar(ultimo);
     * }else{
     * ultimoAlFrente(c);
     * c.encolar(guardar);
     * }
     */

    public static void ultimoAlFrente(Cola<Integer> c) throws ColaVacia {
        int totalElementos = c.numElemCola();
        if (totalElementos <= 1) {
            return;
        }
        rotarCola(c, totalElementos - 1);
    }

    private static void rotarCola(Cola<Integer> c, int veces) throws ColaVacia {
        if (veces == 0) {
            return;
        }

        Integer primero = c.desencolar();
        c.encolar(primero);
        rotarCola(c, veces - 1);
    }

    public static <T> void insertarEnMedio(Cola<T> cola, T Elemento) throws ColaVacia {
        T dato = Elemento;
        int mitad = (cola.numElemCola() / 2);
        insertarAux(cola, dato, mitad, 1);
        cola.invertirCola();
    }

    private static <T> void ordenarCola(Cola<T> cola) throws ColaVacia {
        int n = cola.numElemCola();
        ArrayList<T> aux = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            T guardar = cola.desencolar();
            aux.add(i, guardar);
        }

    }

    private static <T> void insertarAux(Cola<T> cola, T elemento, int mitad, int actual) throws ColaVacia {

        if (actual == mitad) { // si el contador ha llegado a la mitad de la cola
            cola.encolar(elemento);
        } else {
            T guardar = cola.desencolar();
            insertarAux(cola, elemento, mitad, actual + 1);
            cola.encolar(guardar);
        }

    }

    public static <T> boolean agregarEnPosisionNDelante(Cola<T> cola, T dato) throws ColaVacia {
        int mitad = cola.numElemCola() / 2;
        boolean res = agregarEnPosisionNDelanteR(cola, mitad, dato, 0);

        cola.invertirCola();
        return res;
    }

    private static <T> boolean agregarEnPosisionNDelanteR(Cola<T> cola, int pos, T dato, int cont) throws ColaVacia {
        boolean aviso = false;
        if (cola != null) {
            if (!cola.colaVacia()) {

                T elem = cola.desencolar();

                agregarEnPosisionNDelanteR(cola, pos, dato, cont + 1);

                cola.encolar(elem);

                if (cont == pos - 1) {
                    cola.encolar(dato);
                }
                aviso = true;
            } else {
                aviso = false;
            }
        } else {
            aviso = false;
        }

        return aviso;
    }

    // de una cola quiero q dos posisiones intercambiennn luagar
    // ejemplo tenngo 5 6 7 8 1 queiro q el de la posision 2 se cambie por la
    // posision [1][2][3][4][5]
    // 4 entonncnes quedaria 5 8 7 6 1 (ojo empiennsa desde la psosisionn 1)

    public static <T> void intercambiarLugar(Cola<T> cola, int pos1, int pos2) throws ColaVacia {

        borrar2PosicionR(cola, pos2, pos1, pos2, null);

    }

    private static <T> void borrarDosPosicionR(Cola<T> cola, int count, int pos1, int pos2) throws ColaVacia {

        T guardar2 = null;
        T guardar4 = null;

        if (!cola.colaVacia()) {
            T guardar = cola.desencolar();

            // count == 2
            if (count == pos1) {
                guardarinter2 = cola.desencolar();
            }
            // count == 4
            if (count == pos2) {
                guardar4 = cola.desencolar();
            }

            borrarDosPosicionR(cola, count + 1, pos1, pos2);
            cola.encolar(guardar);
        }

    }

    public static <T> void intercambairLugares(Cola<T> cola, int pos, int posCamb) throws ColaVacia {

        intercambairLugaresR(cola, pos, posCamb, 1, null);

        cola.invertirCola();
    }

    private static <T> T intercambairLugaresR(Cola<T> cola, int pos, int posCamb, int cont, T d) throws ColaVacia {

        T res = null;
        // guardar caso base
        if (!cola.colaVacia()) {
            T elem = cola.desencolar();
            if (cont == pos) {
                d = elem;
            }

            res = intercambairLugaresR(cola, pos, posCamb, cont + 1, d);

        // Intercambio de los elementos de dichas posiciones
            if (cont == pos) {
                cola.encolar(res);
                res = elem;
            } else if (cont == posCamb) {
                cola.encolar(d);
                res = elem;
            } else {
                cola.encolar(elem);
            }
        }

        return res;
    }

}
