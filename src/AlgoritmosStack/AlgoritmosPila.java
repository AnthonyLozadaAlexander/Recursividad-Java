package AlgoritmosStack;

import Stack.Pila;
import Stack.*;

public class AlgoritmosPila<T> {

    public static int contarPila(Pila<Integer> p) throws PilaVacia{
        int count = 0;
        if(p.estaVacia()){
            return 0;
        }

        Integer guardar = p.desapilar();
        count = 1 + contarPila(p);
        p.apilar(guardar);

        return count;
    }
}
