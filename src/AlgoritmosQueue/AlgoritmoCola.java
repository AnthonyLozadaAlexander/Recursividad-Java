package AlgoritmosQueue;

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

    public static <T> void borrarDosPosicion(Cola<T> cola, int pos1, int pos2) throws ColaVacia {

        borrarDosPosicionR(cola, 0, pos1, pos2);

    }

    private static <T> void borrarDosPosicionR(Cola<T> cola, int count, int pos1, int pos2) throws ColaVacia {

        T guardar2 = null;
        T guardar4 = null;

        if (!cola.colaVacia()) {
            T guardar = cola.desencolar();

            // count == 2
            if (count == pos1) {
                guardar2 = cola.desencolar();
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

    /*
     * de una cola ejemplo 1 2 3 4 5 6 7 quiero que todo los datos pares se
     * intercambien por el 99 entonnces quedaria asi 1 99 3 99 5 99 7
     */
    public static <T> void intercambiarParesMA(Cola<T> cola) throws ColaVacia {
        Integer dato1 = 99;
        intercambiarParesM(cola, (T) dato1);
    }

    private static <T> void intercambiarParesM(Cola<T> cola, T dato) throws ColaVacia {
        if (!cola.colaVacia()) {
            T elem = cola.desencolar();
            intercambiarParesM(cola, dato);
            if ((Integer) elem % 2 == 0) {
                cola.encolar(dato);
            } else {
                cola.encolar(elem);
            }
        }
    }

    public static <T> void intercambiarParesA(Cola<T> cola) throws ColaVacia {
        Integer dato1 = 99;
        intercambiarParesR(cola, (T) dato1);
    }

    private static <T> void intercambiarParesR(Cola<T> cola, T dato1) throws ColaVacia {

        /*
         * Aqui comienza la recursividad hasta que la cola quede vacia, se desencolan
         * los datos en la memoria, de IDA
         */
        // ------------------------------------------------------
        if (!cola.colaVacia()) {
            T dato = cola.desencolar();
            intercambiarParesA(cola);
            // -----------------------------------------------------

            if ((Integer) dato % 2 == 0) {
                cola.encolar(dato1);
            } else {
                cola.encolar(dato);
            }

            /* Este es el momento donde el bucle va de regreso */

        }
    }

    /*
     * TONTO QUIEN LO LEA
     *
     *
     */

    /*
     * TONTO QUIEN LO Siga LEYENDO
     *
     *
     */

    /*
     *
     * de una cola ejemplo 2 3 5 6 9 1 quiero que la mitad de mi cola final se
     * cambie de orden ejemplo
     * quedaria 2 3 5 1 9 6
     *
     *
     */

    public static <T> void intercambiarMitad(Cola<T> cola) throws ColaVacia {
        int total = cola.numElemCola();
        int mitad = total / 2;

        intercambiarMitadR(cola, mitad, 1, total);
    }

    private static <T> void intercambiarMitadR(Cola<T> cola, int mitad, int count, int total) throws ColaVacia {
        if (count > total) {
            return;
        }

        T save = cola.desencolar();

        if (count <= mitad) {
            cola.encolar(save);
            intercambiarMitadR(cola, mitad, count + 1, total);
        } else {
            intercambiarMitadR(cola, mitad, count + 1, total);
            cola.encolar(save);
        }

    }

    public static <T> void filtrarImparesE(Cola<Integer> c) throws ColaVacia {

        if (!c.colaVacia()) {
            Integer actual = c.desencolar();
            filtrarImparesE(c);

            if (actual % 2 == 0) {
                c.encolar(actual);
                c.invertirCola();
            }

        }

    }

    public static void filtrarImparesDos(Cola<Integer> cola) throws ColaVacia {
        if (!cola.colaVacia()) {
            filtrarImparesR(cola, cola.numElemCola());
        }
    }

    private static void filtrarImparesR(Cola<Integer> cola, int elementosRestantes) throws ColaVacia {
        if (elementosRestantes > 0) {
            Integer guardar = cola.desencolar();
            if (guardar % 2 == 0) {
                cola.encolar(guardar);
            }
            filtrarImparesR(cola, elementosRestantes - 1);
        }

    }

    public static <T> void duplicarElemento(Cola<T> cola) throws ColaVacia {
        duplicarElementoR(cola, cola.numElemCola());
    }

    private static <T> void duplicarElementoR(Cola<T> cola, int elementosRestantes) throws ColaVacia {
        if (elementosRestantes > 0) {
            T elem = cola.desencolar();
            cola.encolar(elem);
            cola.encolar(elem);
            duplicarElementoR(cola, elementosRestantes - 1);
        }
    }

    public static <T> boolean encontrar(Cola<T> c, T buscar) throws ColaVacia {
        Boolean encontrado = false;
        if (!c.colaVacia()) {
            encontrado = encontrarR(c, buscar, c.numElemCola());
        }

        return encontrado;
    }

    private static <T> boolean encontrarR(Cola<T> c, T buscar, int elementosRestantes) throws ColaVacia {
        boolean resul = false;
        if (elementosRestantes != 0) {
            T guardar = c.desencolar();
            c.encolar(guardar);
            resul = encontrarR(c, buscar, elementosRestantes - 1);

            if (guardar == buscar) {
                resul = true;
            }
        }

        return resul;

    }

    public static <T> void insertarDelanteDe(Cola<T> cola, T a, T b) throws ColaVacia {

        insertarDelanteDeR(cola, a, b, cola.numElemCola());

    }

    private static <T> void insertarDelanteDeR(Cola<T> cola, T a, T b, int elementosRestantes) throws ColaVacia {

        if (elementosRestantes > 0) {
            T actual = cola.desencolar();
            if (actual.equals(b)) {
                cola.encolar(a);
                cola.encolar(actual);
            } else {
                cola.encolar(actual);
            }
            insertarDelanteDeR(cola, a, b, elementosRestantes - 1);

        }

    }

    public static <T> void insertarDelanteDeB(Cola<T> cola, T a, T b) throws ColaVacia {
        insertarDelanteDeBR(cola, a, b);
        cola.invertirCola();

    }

    // b es la ocurrencia (repetido)
    // a es el insertar
    // (a) -> (b)

    private static <T> void insertarDelanteDeBR(Cola<T> cola, T a, T b) throws ColaVacia {

        if (!cola.colaVacia()) {
            T actual = cola.desencolar();
            insertarDelanteDeBR(cola, a, b);
            if (actual.equals(b)) {
                cola.encolar(actual);
                cola.encolar(a);

            }else{
                cola.encolar(actual);

            }
        }

    }

    public static <T> void insertarDelanteDe2(Cola<T> cola, T a, T b) throws ColaVacia {
        insertarDelanteDeR2(cola, a, b);
        cola.invertirCola();
    }

    private static <T> void insertarDelanteDeR2(Cola<T> cola, T a, T b) throws ColaVacia {
        boolean resul = false;
        T actual = null;
        if(!cola.colaVacia() && resul == false){
            actual = cola.desencolar();
            if(actual.equals(b)){
                resul = true;
            }
            insertarDelanteDeR2(cola, a, b);
            if(resul == true){
                cola.encolar(actual);
                cola.encolar(a);
            }else {
                cola.encolar(actual);
            }
        }

    }

    public static <T> void encolarAlFrente(Cola<T> cola, T dato) throws ColaVacia {
        if (cola != null) {
            Cola<T> aux = new TadCola<>("AuxFrente");
            int total = cola.numElemCola();
            moverColaRecursivo(cola, aux, total);
            cola.encolar(dato);
            moverColaRecursivo(aux, cola, aux.numElemCola());
        }
    }

    public static <T> T obtenerFrente(Cola<T> cola) throws ColaVacia {
        T frente = null;
        if (cola != null && !cola.colaVacia()) {
            frente = cola.primero();
        }
        return frente;
    }

    public static <T> boolean buscarElemento(Cola<T> cola, T dato) throws ColaVacia {
        boolean encontrado = false;
        if (cola != null && !cola.colaVacia()) {
            Cola<T> aux = new TadCola<>("AuxBuscar");
            int total = cola.numElemCola();
            encontrado = buscarElementoR(cola, aux, dato, total);
            moverColaRecursivo(aux, cola, aux.numElemCola());
        }
        return encontrado;
    }

    private static <T> boolean buscarElementoR(Cola<T> cola, Cola<T> aux, T dato, int restantes) throws ColaVacia {
        boolean encontrado = false;
        if (restantes > 0) {
            T actual = cola.desencolar();
            aux.encolar(actual);
            encontrado = mismoDato(actual, dato);
            boolean resto = buscarElementoR(cola, aux, dato, restantes - 1);
            encontrado = encontrado || resto;
        }
        return encontrado;
    }

    public static <T> boolean eliminarPrimeraOcurrencia(Cola<T> cola, T dato) throws ColaVacia {
        boolean eliminado = false;
        if (cola != null && !cola.colaVacia()) {
            Cola<T> aux = new TadCola<>("AuxEliminar");
            int total = cola.numElemCola();
            eliminado = eliminarPrimeraOcurrenciaR(cola, aux, dato, total, false);
            moverColaRecursivo(aux, cola, aux.numElemCola());
        }
        return eliminado;
    }

    private static <T> boolean eliminarPrimeraOcurrenciaR(Cola<T> cola, Cola<T> aux, T dato, int restantes,
            boolean eliminado) throws ColaVacia {
        boolean res = eliminado;
        if (restantes > 0) {
            T actual = cola.desencolar();
            if (!eliminado && mismoDato(actual, dato)) {
                res = eliminarPrimeraOcurrenciaR(cola, aux, dato, restantes - 1, true);
            } else {
                aux.encolar(actual);
                res = eliminarPrimeraOcurrenciaR(cola, aux, dato, restantes - 1, eliminado);
            }
        }
        return res;
    }

    public static <T> boolean eliminarUltimo(Cola<T> cola) throws ColaVacia {
        boolean eliminado = false;
        if (cola != null && !cola.colaVacia()) {
            Cola<T> aux = new TadCola<>("AuxUltimo");
            int total = cola.numElemCola();
            moverColaRecursivo(cola, aux, total);
            eliminarUltimoDesdeAux(aux, cola, aux.numElemCola());
            eliminado = true;
        }
        return eliminado;
    }

    private static <T> void eliminarUltimoDesdeAux(Cola<T> aux, Cola<T> cola, int restantes) throws ColaVacia {
        if (restantes > 0) {
            T actual = aux.desencolar();
            if (restantes > 1) {
                cola.encolar(actual);
            }
            eliminarUltimoDesdeAux(aux, cola, restantes - 1);
        }
    }

    public static <T> boolean actualizarPrimero(Cola<T> cola, T nuevoDato) throws ColaVacia {
        boolean actualizado = false;
        if (cola != null && !cola.colaVacia()) {
            Cola<T> aux = new TadCola<>("AuxActualizarPrimero");
            int total = cola.numElemCola();
            actualizado = actualizarEnPosicionR(cola, aux, 1, nuevoDato, 1, total);
            moverColaRecursivo(aux, cola, aux.numElemCola());
        }
        return actualizado;
    }

    public static <T> boolean actualizarUltimo(Cola<T> cola, T nuevoDato) throws ColaVacia {
        boolean actualizado = false;
        if (cola != null && !cola.colaVacia()) {
            Cola<T> aux = new TadCola<>("AuxActualizarUltimo");
            int total = cola.numElemCola();
            actualizado = actualizarEnPosicionR(cola, aux, total, nuevoDato, 1, total);
            moverColaRecursivo(aux, cola, aux.numElemCola());
        }
        return actualizado;
    }

    public static <T> boolean actualizarEnPosicion(Cola<T> cola, int posicion, T nuevoDato) throws ColaVacia {
        boolean actualizado = false;
        if (cola != null && !cola.colaVacia() && posicion >= 1) {
            Cola<T> aux = new TadCola<>("AuxActualizarPosicion");
            int total = cola.numElemCola();
            actualizado = actualizarEnPosicionR(cola, aux, posicion, nuevoDato, 1, total);
            moverColaRecursivo(aux, cola, aux.numElemCola());
        }
        return actualizado;
    }

    private static <T> boolean actualizarEnPosicionR(Cola<T> cola, Cola<T> aux, int posicion, T nuevoDato,
            int actual, int total) throws ColaVacia {
        boolean res = false;
        if (actual <= total) {
            T guardado = cola.desencolar();
            if (actual == posicion) {
                aux.encolar(nuevoDato);
                res = true;
            } else {
                aux.encolar(guardado);
            }
            boolean resto = actualizarEnPosicionR(cola, aux, posicion, nuevoDato, actual + 1, total);
            res = res || resto;
        }
        return res;
    }

    public static <T> void rotarHaciaLaIzquierda(Cola<T> cola, int veces) throws ColaVacia {
        if (cola != null && !cola.colaVacia() && veces > 0) {
            int total = cola.numElemCola();
            rotarHaciaLaIzquierdaR(cola, veces % total);
        }
    }

    private static <T> void rotarHaciaLaIzquierdaR(Cola<T> cola, int veces) throws ColaVacia {
        if (veces > 0) {
            T guardar = cola.desencolar();
            cola.encolar(guardar);
            rotarHaciaLaIzquierdaR(cola, veces - 1);
        }
    }

    private static <T> void moverColaRecursivo(Cola<T> origen, Cola<T> destino, int restantes) throws ColaVacia {
        if (restantes > 0) {
            T actual = origen.desencolar();
            destino.encolar(actual);
            moverColaRecursivo(origen, destino, restantes - 1);
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


