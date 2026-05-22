package AlgoritmosQueue;

import Queue.*;

public class AlgoritmoCola<T> {

    public static <T> void invertirCola(Cola<T> cola) throws ColaVacia {
        Cola<T> aux;
        aux = cola;

        if(!cola.colaVacia()){
            T elem = aux.desencolar();
            invertirCola(aux);
            aux.encolar(elem);
        }
    }

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
            T elem = aux.desencolar();
            ultimoAPrimeroR(aux); // invocacion recursiva para desencolar toda la cola
            if (cola.colaVacia()) {
                resul = elem; // guardamos el ultimo elemento de la cola
            }
        }

        return resul; // retorna el ultimo elemento de la cola

    }

}
