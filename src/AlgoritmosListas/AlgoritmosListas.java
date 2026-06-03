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
        aux.asignarReferencia(lista.devolverReferencia()); // el nodo auxiliar toma la referencia del nodo siguiente al
                                                           // nodo cabeza, para empezar a contar desde el primer nodo de
                                                           // la lista
        return contarR(aux); // llama al metodo recursivo privado
    }

    private static <T> int contarR(Lista<T> aux) {
        // comprueba si existe un siguiente nodo, si existe, avanza al siguiente nodo y
        // suma 1 al contador, hasta llegar al final de la lista
        if (aux.esNulo()) {
            return 0;
        }

        Lista<T> sig = new TadLista<T>();
        sig.asignarReferencia(aux.devolverSiguiente()); // el nodo sig toma la referencia del nodo siguiente al nodo
                                                        // auxiliar, para avanzar al siguiente nodo
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

            insertarAlPrincipio(listaD, dato); // una vez terminada la recursividad, se insertan los datos al principio
                                               // de la listaD
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
        if (!aux.esNulo()) { // caso base, si el nodo es nulo, quiere decir que se busco toda la lista y no
                             // se encontro el dato
            if (mismoDato(aux.devolverClave(), dato)) { // si el dato del nodo actual es igual al dato buscado, si se cumple
                                                    // devuelve true
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
            aux.asignarReferencia(lista.devolverReferencia()); // le doy a aux el primer nodo que a su vez se conecta
                                                               // con los demas nodos
            imprimirInversoR(aux);
        } else {
            System.out.println("Error: Lista Vacia");
        }
    }

    private static <T> void imprimirInversoR(Lista<T> aux) {
        Lista<T> sig = new TadLista<T>(); // aux para recorrer la lista
        if (!aux.esNulo()) {
            T elem = aux.devolverClave(); // va almacenando en call stack los elementos de aux
            sig.asignarReferencia(aux.devolverSiguiente());
            imprimirInversoR(sig);
            System.out.print("[" + elem + "] ");
        }
    }

    public static int sumar(Lista<Integer> lista) {
        Lista<Integer> aux = new TadLista<Integer>();
        Integer total = 0;
        if (!lista.esNulo()) {
            aux.asignarReferencia(lista.devolverReferencia());
            total = sumarR(aux);
        }
        return total;
    }

    private static int sumarR(Lista<Integer> aux) {
        Lista<Integer> sig = new TadLista<Integer>();
        Integer sum = 0;
        if (!aux.esNulo()) {
            Integer guardar = aux.devolverClave();
            sig.asignarReferencia(aux.devolverSiguiente());
            sum = guardar + sumarR(sig);

        }
        return sum;
    }

    public static <T> T obtenerUltimo(Lista<T> lista) {
        Lista<T> aux = new TadLista<T>();
        T elem = null;
        if (!lista.esNulo()) {
            aux.asignarReferencia(lista.devolverReferencia());
            elem = obtenerUltimoR(aux);
        }
        return elem;
    }

    public static <T> T obtenerUltimoR(Lista<T> aux) {
        boolean on = false;
        T guardar = null;

        if (aux.devolverSiguiente() == null) {
            guardar = aux.devolverClave();
        } else {
            aux.asignarReferencia(aux.devolverSiguiente());
            guardar = obtenerUltimoR(aux);
        }

        return guardar;
    }

    public static <T> void imprimirLista(Lista<T> lista) {
        if (!lista.esNulo()) {
            Lista<T> aux = new TadLista<>();
            aux.asignarReferencia(lista.devolverReferencia());
            imprimirListaR(aux);
        }
    }

    private static <T> void imprimirListaR(Lista<T> aux) {
        if (!aux.esNulo()) {
            T guardar = aux.devolverClave();
            System.out.print("[" + guardar + "], ");
            aux.asignarReferencia(aux.devolverSiguiente());
            imprimirListaR(aux);
        }
    }

    public static <T> void imprimirInvertido(Lista<T> lista){
        if(!lista.esNulo()){
            Lista<T> aux = new TadLista<>();
            aux.asignarReferencia(lista.devolverReferencia());
            imprimirInvertidoR(aux);
        }
    }

    private static <T> void imprimirInvertidoR(Lista<T> aux){
        if(!aux.esNulo()){
            T guardar = aux.devolverClave();
            aux.asignarReferencia(aux.devolverSiguiente());
            imprimirInvertidoR(aux);
            System.out.println(guardar);
        }
    }

    public static<T> int countNodos(Lista<T> lista){
        int cant = 0;
        if(!lista.esNulo()){
            Lista<T> aux = new TadLista<>();
            aux.asignarReferencia(lista.devolverReferencia());
            cant = countNodosR(aux);
        }
        return cant;
    }

    private static <T> int countNodosR(Lista<T> aux){
        int result  = 0;
        if(aux.esNulo()){
            return 0;
        }else{
            aux.asignarReferencia(aux.devolverSiguiente());
            result = 1 + countNodosR(aux);
        }

        return result;
    }

    public static <T> boolean contiene(Lista<T> lista, T dato){
        boolean result = false;
        if(!lista.esNulo()){
            Lista<T>  aux = new TadLista<>();
            aux.asignarReferencia(lista.devolverReferencia());
            result = contieneR(aux,dato);
        }

        return result;
    }

    private static <T> boolean contieneR(Lista<T> aux, T dato){
        boolean encontrado = false;
        if(!aux.esNulo() && encontrado == false){
            if(mismoDato(aux.devolverClave(), dato)){
                encontrado = true;
            }else{
                aux.asignarReferencia(aux.devolverSiguiente());
                encontrado = contieneR(aux, dato);
            }
        }

        return encontrado;

    }

    public static <T> void insertarEnPosicion(Lista<T> lista, T dato, int posicion) {
        if (lista != null) {
            if (posicion <= 1 || lista.esNulo()) {
                insertarAlPrincipio(lista, dato);
            } else {
                Lista<T> aux = new TadLista<T>();
                aux.asignarReferencia(lista.devolverReferencia());
                insertarEnPosicionR(aux, dato, posicion);
            }
        }
    }

    private static <T> void insertarEnPosicionR(Lista<T> aux, T dato, int posicion) {
        if (posicion > 0 && aux != null) {
            if (posicion <= 2 || aux.devolverSiguiente() == null) {
                Lista<T> nuevo = new TadLista<T>();
                insertarAlPrincipio(nuevo, dato);
                nuevo.asignarReferenciaSiguiente(aux.devolverSiguiente());
                aux.asignarReferenciaSiguiente(nuevo.devolverReferencia());
            } else {
                aux.asignarReferencia(aux.devolverSiguiente());
                insertarEnPosicionR(aux, dato, posicion - 1);
            }
        }
    }

    public static <T> T obtenerEnPosicion(Lista<T> lista, int posicion) {
        T res = null;
        if (lista != null && !lista.esNulo() && posicion >= 1) {
            Lista<T> aux = new TadLista<T>();
            aux.asignarReferencia(lista.devolverReferencia());
            res = obtenerEnPosicionR(aux, posicion);
        }
        return res;
    }

    private static <T> T obtenerEnPosicionR(Lista<T> aux, int posicion) {
        T res = null;
        if (aux != null && !aux.esNulo()) {
            if (posicion == 1) {
                res = aux.devolverClave();
            } else {
                Lista<T> sig = new TadLista<T>();
                sig.asignarReferencia(aux.devolverSiguiente());
                res = obtenerEnPosicionR(sig, posicion - 1);
            }
        }
        return res;
    }

    public static <T> boolean actualizarEnPosicion(Lista<T> lista, int posicion, T nuevoDato) {
        boolean res = false;
        if (lista != null && !lista.esNulo() && posicion >= 1) {
            Lista<T> aux = new TadLista<T>();
            aux.asignarReferencia(lista.devolverReferencia());
            res = actualizarEnPosicionR(aux, posicion, nuevoDato);
        }
        return res;
    }

    private static <T> boolean actualizarEnPosicionR(Lista<T> aux, int posicion, T nuevoDato) {
        boolean res = false;
        if (aux != null && !aux.esNulo()) {
            if (posicion == 1) {
                aux.asignarClave(nuevoDato);
                res = true;
            } else {
                Lista<T> sig = new TadLista<T>();
                sig.asignarReferencia(aux.devolverSiguiente());
                res = actualizarEnPosicionR(sig, posicion - 1, nuevoDato);
            }
        }
        return res;
    }

    public static <T> boolean eliminarPrimeraOcurrencia(Lista<T> lista, T dato) {
        boolean res = false;
        if (lista != null && !lista.esNulo()) {
            if (mismoDato(lista.devolverClave(), dato)) {
                lista.asignarReferencia(lista.devolverSiguiente());
                res = true;
            } else {
                Lista<T> aux = new TadLista<T>();
                aux.asignarReferencia(lista.devolverReferencia());
                res = eliminarPrimeraOcurrenciaR(aux, dato);
            }
        }
        return res;
    }

    private static <T> boolean eliminarPrimeraOcurrenciaR(Lista<T> aux, T dato) {
        boolean res = false;
        if (aux != null && !aux.esNulo()) {
            Lista<T> sig = new TadLista<T>();
            sig.asignarReferencia(aux.devolverSiguiente());
            if (!sig.esNulo() && mismoDato(sig.devolverClave(), dato)) {
                aux.asignarReferenciaSiguiente(sig.devolverSiguiente());
                res = true;
            } else if (!sig.esNulo()) {
                aux.asignarReferencia(sig.devolverReferencia());
                res = eliminarPrimeraOcurrenciaR(aux, dato);
            }
        }
        return res;
    }

    public static <T> boolean eliminarUltimo(Lista<T> lista) {
        boolean res = false;
        if (lista != null && !lista.esNulo()) {
            if (lista.devolverSiguiente() == null) {
                lista.asignarNulo();
                res = true;
            } else {
                Lista<T> aux = new TadLista<T>();
                aux.asignarReferencia(lista.devolverReferencia());
                res = eliminarUltimoR(aux);
            }
        }
        return res;
    }

    private static <T> boolean eliminarUltimoR(Lista<T> aux) {
        boolean res = false;
        if (aux != null && !aux.esNulo()) {
            Lista<T> sig = new TadLista<T>();
            sig.asignarReferencia(aux.devolverSiguiente());
            if (sig.devolverSiguiente() == null) {
                aux.asignarReferenciaSiguiente(null);
                res = true;
            } else {
                aux.asignarReferencia(sig.devolverReferencia());
                res = eliminarUltimoR(aux);
            }
        }
        return res;
    }

    public static <T> void invertirLista(Lista<T> lista) {
        if (lista != null && !lista.esNulo() && lista.devolverSiguiente() != null) {
            Lista<T> aux = new TadLista<T>();
            aux.asignarReferencia(lista.devolverReferencia());
            Lista<T> nuevaCabeza = invertirListaR(aux);
            lista.asignarReferencia(nuevaCabeza.devolverReferencia());
        }
    }

    private static <T> Lista<T> invertirListaR(Lista<T> aux) {
        Lista<T> res = aux;
        if (aux != null && !aux.esNulo()) {
            Lista<T> sig = new TadLista<T>();
            sig.asignarReferencia(aux.devolverSiguiente());
            if (!sig.esNulo()) {
                res = invertirListaR(sig);
                sig.asignarReferenciaSiguiente(aux.devolverReferencia());
                aux.asignarReferenciaSiguiente(null);
            }
        }
        return res;
    }

    private static <T> boolean mismoDato(T a, T b) {
        boolean res = false;
        if (a == b || (a != null && a.equals(b))) {
            res = true;
        }
        return res;
    }

}
