package AlgoritmosStack;

import Queue.Cola;
import Queue.ColaVacia;
import Stack.*;

public class AlgoritmosPila<T> {

    public static int contarPila(Pila<Integer> p) throws PilaVacia {
        int count = 0;
        if (p.pilaVacia()) {
            return 0;
        }

        Integer guardar = p.desapilar();
        count = 1 + contarPila(p);
        p.apilar(guardar);

        return count;
    }

    public static void imprimirPilaInvertida(Pila<Integer> p) throws PilaVacia {
        Integer cima = 0;
        if (p.pilaVacia()) {
            return;
        }

        cima = p.desapilar();
        imprimirPilaInvertida(p);

        System.out.println(cima);
        p.apilar(cima);

    }

    public static <T> void insertarAlFondo(Pila<T> pila, T elemento) throws PilaVacia {

        T elementoExtraido;

        if (pila.pilaVacia()) {
            pila.apilar(elemento);
            return;
        } else {
            elementoExtraido = pila.desapilar();
            insertarAlFondo(pila, elemento); // llamada recursiva
            pila.apilar(elementoExtraido);
        }

    }

    public static <T> void eliminarOcurrencias(Pila<T> p, T x) throws PilaVacia {
        if (p.pilaVacia()) {
            return;
        }

        T actual = p.desapilar();
        eliminarOcurrencias(p, x);

        if (!actual.equals(x)) {
            p.apilar(actual);
        }
    }

    public static <T> Integer buscarElementoMaximoN(Pila<Integer> p) throws PilaVacia {
        //
        if (p.getTamanio() == 1) { // toma el ultimo de la pila para retornar y comparar
            Integer save = p.desapilar();
            p.apilar(save); // apilamos para no perder
            return save;
        }

        Integer actual = p.desapilar();
        Integer maximoResto = buscarElementoMaximoN(p); // trae el return save
        // Recursivo desde 73 hasta 63

        // una vez terminada la recursividad apila el regreso y compara y devuelve
        p.apilar(actual);
        // 2 4
        return Math.max(actual, maximoResto); // compara y devuelve
    }

    public static <T> Integer buscarElementoMaximoE(Pila<Integer> p) throws PilaVacia {
        Integer Max = 0;
        // [5] , 9 , 3
        if (!p.pilaVacia()) {
            if (p.getTamanio() == 1) { // cuando llego al fondo de la pila
                Integer save = p.desapilar();
                p.apilar(save);
                Max = save;
            } else { // cuando no sea el tamanio el fondo
                Integer actual = p.desapilar();
                Integer max = buscarElementoMaximoE(p);
                p.apilar(max);
                Max = Math.max(actual, max);
            }

        }
        return Max;

    }

    public static <T> Integer buscarElementoMax(Pila<Integer> p) throws PilaVacia {
        Integer max = 0;
        if (!p.pilaVacia()) {
            Integer elem = p.desapilar();
            max = buscarElementoMax(p);
            if ((Integer) elem > max) {
                max = (Integer) elem;
            }
            p.apilar(elem);
        }
        return max;
    }

    public static <T> int contarElementosR(Pila<T> p) throws PilaVacia {
        int count = 0;
        if (p.pilaVacia()) {
            return 0;
        } else {
            T guardar = p.desapilar();
            count = 1 + contarElementosR(p);
            p.apilar(guardar);
        }

        return count;
    }

    public static <T> void insertarAlFondoA(Pila<T> p, T dato) throws PilaVacia {
        if (p.pilaVacia()) {
            p.apilar(dato);
        } else {
            T guardar = p.desapilar();
            insertarAlFondo(p, dato);
            p.apilar(guardar);
        }
    }

    public static <T> void eliminarBase(Pila<T> pila) throws PilaVacia {
        if (pila.getTamanio() == 1) {
            T eliminar = pila.desapilar();
        }

        if (pila.getTamanio() > 1) {
            T guardar = pila.desapilar();
            eliminarBase(pila);
            pila.apilar(guardar);
        }
    }

    public static <T> void actualizarEnPosicion(Pila<T> pila, int posicion, T nuevoValor) throws PilaVacia {

        if (posicion == 1) {
            T guardar = pila.desapilar();
            pila.apilar(nuevoValor);
        }

        if (posicion > 1) {
            T save = pila.desapilar();
            actualizarEnPosicion(pila, posicion - 1, nuevoValor);
            pila.apilar(save);
        }

    }

    public static <T> int sumarElementos(Pila<Integer> pila) throws PilaVacia{
        if(pila.pilaVacia()){
            return 0;
        }
        Integer guardar = pila.desapilar();
        Integer suma = (guardar + sumarElementos(pila));
        pila.apilar(guardar);
        return suma;
    }

    public static <T> T obtenerElementoEnPosicion(Pila<T> p, int posicion) throws PilaVacia {
        T guardar = null;
        T actual = null;

        if(!p.pilaVacia()) {
            if (posicion == 1) {
                guardar = p.desapilar();
                p.apilar(guardar);
            }
            if(posicion > 1){
                actual = p.desapilar();
                guardar = obtenerElementoEnPosicion(p, posicion - 1);
                p.apilar(actual);
            }
        }

        return guardar;
    }

    public static <T> int contarOcurrencias(Pila<T> p, T x) throws PilaVacia {
        T elem = null;
        int conteo;
        if(p.pilaVacia()){
            return 0;
        }else{
            elem = p.desapilar();
            conteo = contarOcurrencias(p, x);
            p.apilar(elem);
            if(elem.equals(x)){
                conteo = 1 + conteo;
            }else{
                conteo = 0 + conteo;
            }
        }

        return conteo;
    }

    public static <T> void datoFondo(Pila<T> pila, T dato) throws PilaVacia{
        T actual = null;
        if(pila.pilaVacia()){}
        else if(pila.cima().equals(dato)){
            insertarAlFondoR(pila, dato);
        }else{
            actual = pila.desapilar();
            datoFondo(pila, dato);
            pila.apilar(actual);
        }
    }

    private static <T> void insertarAlFondoR(Pila<T> pila, T dato) throws PilaVacia{
        if(pila.pilaVacia()){
            pila.apilar(dato);
        }else{
            T guardar = pila.desapilar();
            insertarAlFondoR(pila, dato);
            if(!guardar.equals(dato)) {
                pila.apilar(guardar);
            }
        }
    }

}
