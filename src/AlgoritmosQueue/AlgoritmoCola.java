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
            }else{
                resul = ultimoAPrimeroR(aux); // invocacion recursiva
                cola.encolar(elem); // volver a encolar la cola
            }
        }

        return resul; // retorna el ultimo elemento de la cola

    }



    public static <T> int contarElementsR(Cola<T> cola, int count) throws ColaVacia {
        Cola<T> aux;
        aux = cola;

        if(aux.colaVacia()){
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
        if(c.colaVacia()){
            return 0;
        }

        primero = c.desencolar();
        if(primero % 2 == 0){
            count = 1 + contarParesCola(c);

        }else{
            count = 0 + contarParesCola(c);
        }

        c.encolar(primero);

        return count;

    }



}
