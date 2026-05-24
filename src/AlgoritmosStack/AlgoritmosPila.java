package AlgoritmosStack;

import Stack.Pila;
import Stack.*;

public class AlgoritmosPila<T> {

    public static int contarPila(Pila<Integer> p) throws PilaVacia {
        int count = 0;
        if (p.estaVacia()) {
            return 0;
        }

        Integer guardar = p.desapilar();
        count = 1 + contarPila(p);
        p.apilar(guardar);

        return count;
    }

    public static void imprimirPilaInvertida(Pila<Integer> p) throws PilaVacia {
        Integer cima = 0;
        if (p.estaVacia()) {
            return;
        }

        cima = p.desapilar();
        imprimirPilaInvertida(p);

        System.out.println(cima);
        p.apilar(cima);

    }

    public static <T> void insertarAlFondo(Pila<T> pila, T elemento) throws PilaVacia {

        T elementoExtraido;

        if (pila.estaVacia()) {
            pila.apilar(elemento);
            return;
        } else {
            elementoExtraido = pila.desapilar();
            insertarAlFondo(pila, elemento); // llamada recursiva
            pila.apilar(elementoExtraido);
        }

    }

}
