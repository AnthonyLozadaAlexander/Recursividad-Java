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

    public static <T> void insertarEnBase(Pila<T> pila, T dato) throws PilaVacia {
        if (pila != null) {
            insertarEnBaseR(pila, dato);
        }
    }

    private static <T> void insertarEnBaseR(Pila<T> pila, T dato) throws PilaVacia {
        if (pila.pilaVacia()) {
            pila.apilar(dato);
        } else {
            T guardar = pila.desapilar();
            insertarEnBaseR(pila, dato);
            pila.apilar(guardar);
        }
    }

    public static <T> T obtenerBase(Pila<T> pila) throws PilaVacia {
        T base = null;
        if (pila != null) {
            base = obtenerBaseR(pila);
        }
        return base;
    }

    private static <T> T obtenerBaseR(Pila<T> pila) throws PilaVacia {
        T base = null;
        if (pila.pilaVacia()) {
            base = null;
        } else {
            T guardar = pila.desapilar();
            if (pila.pilaVacia()) {
                base = guardar;
            } else {
                base = obtenerBaseR(pila);
            }
            pila.apilar(guardar);
        }
        return base;
    }

    public static <T> boolean obtenerContiene(Pila<T> pila, T dato) throws PilaVacia {
        boolean encontrado = false;
        if (pila != null) {
            encontrado = obtenerContieneR(pila, dato);
        }
        return encontrado;
    }

    private static <T> boolean obtenerContieneR(Pila<T> pila, T dato) throws PilaVacia {
        boolean encontrado = false;
        if (!pila.pilaVacia()) {
            T guardar = pila.desapilar();
            encontrado = obtenerContieneR(pila, dato);
            if (!encontrado && mismoDato(guardar, dato)) {
                encontrado = true;
            }
            pila.apilar(guardar);
        }
        return encontrado;
    }

    public static <T> boolean eliminarPrimeraOcurrencia(Pila<T> pila, T dato) throws PilaVacia {
        boolean eliminado = false;
        if (pila != null) {
            eliminado = eliminarPrimeraOcurrenciaR(pila, dato);
        }
        return eliminado;
    }

    private static <T> boolean eliminarPrimeraOcurrenciaR(Pila<T> pila, T dato) throws PilaVacia {
        boolean eliminado = false;
        if (!pila.pilaVacia()) {
            T guardar = pila.desapilar();
            if (mismoDato(guardar, dato)) {
                devolverRestante(pila);
                eliminado = true;
            } else {
                eliminado = eliminarPrimeraOcurrenciaR(pila, dato);
                pila.apilar(guardar);
            }
        }
        return eliminado;
    }

    public static <T> boolean eliminarBase(Pila<T> pila, T datoBase) throws PilaVacia {
        boolean eliminado = false;
        if (pila != null) {
            eliminado = eliminarBaseR(pila, datoBase);
        }
        return eliminado;
    }

    private static <T> boolean eliminarBaseR(Pila<T> pila, T datoBase) throws PilaVacia {
        boolean eliminado = false;
        if (!pila.pilaVacia()) {
            T guardar = pila.desapilar();
            if (pila.pilaVacia()) {
                if (mismoDato(guardar, datoBase)) {
                    eliminado = true;
                } else {
                    pila.apilar(guardar);
                }
            } else {
                eliminado = eliminarBaseR(pila, datoBase);
                pila.apilar(guardar);
            }
        }
        return eliminado;
    }

    public static <T> void actualizarBase(Pila<T> pila, T nuevoValor) throws PilaVacia {
        if (pila != null) {
            actualizarBaseR(pila, nuevoValor);
        }
    }

    private static <T> void actualizarBaseR(Pila<T> pila, T nuevoValor) throws PilaVacia {
        if (!pila.pilaVacia()) {
            T guardar = pila.desapilar();
            if (pila.pilaVacia()) {
                pila.apilar(nuevoValor);
            } else {
                actualizarBaseR(pila, nuevoValor);
                pila.apilar(guardar);
            }
        }
    }

    public static <T> boolean actualizarEnPosicionSeguro(Pila<T> pila, int posicion, T nuevoValor) throws PilaVacia {
        boolean actualizado = false;
        if (pila != null && posicion >= 1) {
            actualizado = actualizarEnPosicionSeguroR(pila, posicion, nuevoValor);
        }
        return actualizado;
    }

    private static <T> boolean actualizarEnPosicionSeguroR(Pila<T> pila, int posicion, T nuevoValor) throws PilaVacia {
        boolean actualizado = false;
        if (!pila.pilaVacia()) {
            T guardar = pila.desapilar();
            if (posicion == 1) {
                pila.apilar(nuevoValor);
                actualizado = true;
            } else {
                actualizado = actualizarEnPosicionSeguroR(pila, posicion - 1, nuevoValor);
                pila.apilar(guardar);
            }
        }
        return actualizado;
    }

    private static <T> void devolverRestante(Pila<T> pila) throws PilaVacia {
        if (!pila.pilaVacia()) {
            T guardar = pila.desapilar();
            devolverRestante(pila);
            pila.apilar(guardar);
        }
    }

    private static <T> boolean mismoDato(T a, T b) {
        boolean res = false;
        if (a == b || (a != null && a.equals(b))) {
            res = true;
        }
        return res;
    }

}
