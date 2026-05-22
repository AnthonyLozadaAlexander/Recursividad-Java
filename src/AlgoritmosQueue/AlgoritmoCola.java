package AlgoritmosQueue;

import Queue.*;

public class AlgoritmoCola<T> {

    public static <T> void invertirCola(Cola<T> cola) throws ColaVacia {
        Cola<T> aux;
        aux = cola;

        if(!cola.colaVacia()){
            T elem = cola.desencolar();
            invertirCola(aux);
            aux.encolar(elem);
        }
    }

    public static <T> void ultimoAPrimero(Cola<T> cola){

    }

}
