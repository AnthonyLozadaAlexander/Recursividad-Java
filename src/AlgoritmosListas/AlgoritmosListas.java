package AlgoritmosListas;


import List.Lista;
import List.TadLista;

public class AlgoritmosListas {

    // insertar al principio de la lista
    public static <T> void insertarAlPrincipio(Lista<T> lista, T dato) {

        lista.crearNodo(); // crear nodo
        lista.asignarClave(dato); // dato

    }

    public static <T> int contar(Lista<T> lista) {
        if (lista.esNulo()) {
            return 0; // si la lista esta vacia, devuelve 0
        }
        Lista<T> aux = new TadLista<T>();
        aux.asignarReferencia(lista.devolverReferencia()); // el nodo auxiliar toma la referencia del nodo siguiente al nodo cabeza, para empezar a contar desde el primer nodo de la lista
        return contarR(aux); // llama al metodo recursivo privado
    }

    private static <T> int contarR(Lista<T> aux) {
        // comprueba si existe un siguiente nodo, si existe, avanza al siguiente nodo y suma 1 al contador, hasta llegar al final de la lista
        if (aux.esNulo()) {
            return 0;
        }

        Lista<T> sig = new TadLista<T>();
        sig.asignarReferencia(aux.devolverSiguiente()); // el nodo sig toma la referencia del nodo siguiente al nodo auxiliar, para avanzar al siguiente nodo
        return 1 + contarR(sig);

    }

    public static <T> void eliminarPrimero(Lista<T> lista) {
        lista.asignarReferencia(lista.devolverSiguiente());
    }

    public static <T> void insertarAlFinal(Lista<T> lista, T dato) {
        if (lista.esNulo()) { // si esta nulo la lista
            insertarAlPrincipio(lista, dato); // insertamos al principio de la lista
        } else { // si no esta nulo, se van insertando con el metodo recursivo
            Lista<T> aux = new TadLista<T>();
            aux.asignarReferencia(lista.devolverReferencia());
            insertarAlFinalR(aux, dato);
        }
    }

    private static <T> void insertarAlFinalR(Lista<T> aux, T dato) {
        if (!aux.esNulo() && aux.devolverSiguiente() != null) {
            aux.asignarReferencia(aux.devolverSiguiente());
            insertarAlFinalR(aux, dato);
        } else {
            if (aux.esNulo()) {
                insertarAlPrincipio(aux, dato);
            } else {
                Lista<T> aux2 = new TadLista<T>();
                insertarAlPrincipio(aux2, dato);
                aux.asignarReferenciaSiguiente(aux2.devolverReferencia());
            }
        }
    }

    // Metodo Recursivo insertando al final
    public static <T> void duplicarLista1(Lista<T> Lista, Lista<T> listaD) {
        Lista<T> aux = new TadLista<T>();
        aux.asignarReferencia(Lista.devolverReferencia());
        duplicarLista1R(aux, listaD);
    }

    private static <T> void duplicarLista1R(Lista<T> aux, Lista<T> listaD) {

        if (!aux.esNulo()) {

            if (listaD.esNulo()) {
                insertarAlPrincipio(listaD, aux.devolverClave());
            } else {
                insertarAlFinal(listaD, aux.devolverClave());
            }
            aux.asignarReferencia(aux.devolverSiguiente()); // avanzamos al siguiente nodo
            duplicarLista1R(aux, listaD); // invocacion recursiva

        }
    }

    // Metodo Recursivo insertando al principio
    public static <T> void duplicarLista2(Lista<T> listaO, Lista<T> listaD) {
        Lista<T> aux = new TadLista<T>();
        aux.asignarReferencia(listaO.devolverReferencia()); // siguiente nodo
        duplicarLista2R(aux, listaD);
    }

    private static <T> void duplicarLista2R(Lista<T> aux, Lista<T> listaD) {

        if (!aux.esNulo()) {
            T dato = aux.devolverClave(); // guardamos el dato del nodo actual
            aux.asignarReferencia(aux.devolverSiguiente()); // avanzamos al siguiente nodo
            duplicarLista2R(aux, listaD); // invocacion recursiva

            insertarAlPrincipio(listaD, dato); // una vez terminada la recursividad, se insertan los datos al principio de la listaD
        }
    }

    public static <T> boolean buscar(Lista<T> lista, T dato) {
        boolean encontrado = false;
        if (!lista.esNulo()) { // si la lista esta vacia, devuelve false
            Lista<T> aux = new TadLista<T>();
            aux.asignarReferencia(lista.devolverReferencia()); // empezamos en primer nodo
            encontrado = buscarR(aux, dato); // invocacion recursiva
        }

        return encontrado;
    }

    public static <T> boolean buscarR(Lista<T> aux, T dato) {
        boolean resul = false;
        if (!aux.esNulo()) { // caso base, si el nodo es nulo, quiere decir que se busco toda la lista y no se encontro el dato
            if (aux.devolverClave().equals(dato)) { // si el dato del nodo actual es igual al dato buscado,  si se cumple devuelve true
                resul = true;
            } else {
                Lista<T> sig = new TadLista<T>(); // lista sig aux para el siguiente del nodo
                sig.asignarReferencia(aux.devolverSiguiente());
                resul = buscarR(sig, dato); // invocacion recursiva para avanzar al siguiente nodo y seguir buscando
            }
        }

        return resul;
    }

    public static <T> void imprimirInverso(Lista<T> lista) {
        if (!lista.esNulo()) {
            Lista<T> aux = new TadLista<T>();
            aux.asignarReferencia(lista.devolverReferencia());
            imprimirInversoR(aux);
        } else {
            System.out.println("Error: Lista Vacia");
        }
    }

    private static <T> void imprimirInversoR(Lista<T> aux) {
        Lista<T> sig = new TadLista<T>();
        if (!aux.esNulo()) {
            T elem = aux.devolverClave();
            sig.asignarReferencia(aux.devolverSiguiente());
            imprimirInversoR(sig);
            System.out.print("[" + elem + "] ");
        }
    }


}
