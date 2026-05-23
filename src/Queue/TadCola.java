package Queue;

public class TadCola<T> implements Cola<T> {
    private NodoCola<T> principio;
    private NodoCola<T> fin;
    private String nombreCola;

    public TadCola(String nombreCola) {
        this.nombreCola = nombreCola;
        principio = null;
        fin = null;
    }

    public T primero() throws ColaVacia{
        if(colaVacia()){
            throw new ColaVacia("Error: La Cola Se Encuentra Vacia");
        }else {
            return principio.dato;
        }
    }

    @Override
    public void encolar(T dato) {
        NodoCola<T> aux;
        aux = new NodoCola<>(dato, null); // nodo que almacena el dato a conectar con cola

        if (principio == null) { // si el puntero principio es null, se refiere a que fue creado y esta vacio
            principio = aux; // principio conecta con el nodo q almacena el dato
            fin = aux; // fin conecta con el nodo que almacena el dato
        } else {
            fin.siguiente = aux; // el puntero de fin se mueve al siguiente elemento de la cola tomando el nuevo
                                 // nodo creado con el dato almacenado
            fin = aux; // se actualiza el puntero de fin apuntando al ultimo elemento de la cola
        }
    }

    @Override
    public T desencolar() throws ColaVacia {
        if (colaVacia()) {
            throw new ColaVacia("Desencolar: la cola se encuentra vacia");
        } else {
            T resultado; // guardar el resultado
            resultado = principio.dato; // principio.dato se refiere al primer elemento de la cola
            principio = principio.siguiente; // principio avanzara al siguiente elemento de la cola
            if (principio == null) { // si principio es igual a null
                fin = null; // puntero fin apunta al null
            }
            return resultado; // muestra el resultado desencolado de la cola
        }
    }

    @Override
    public void imprimirCola() {
        NodoCola<T> aux;
        System.out.println("Cola: " + this.nombreCola);
        aux = principio; // aux copia la cola principio (original)
        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.siguiente; // aux avanza al siguiente posicion de la Cola
        }

        System.out.println();

    }

    @Override
    public int numElemCola() {
        int count = 0; // reinicia el contador de elementos en la cola, para volverlos a contar
        NodoCola<T> aux; // nodo Auxiliar

        aux = principio; // nodo Auxiliar toma la referencia del nodo Principio (original)
        while (aux != null) {
            count++;
            aux = aux.siguiente; // vector[i] = vector[i+1]

        }

        return count;
    }

    @Override
    public void invertirColaIterativo() {

        if(!colaVacia()) {
            int n = numElemCola();
            T vector[] = (T[]) new Object[n]; // vector de tipo Generico
            for (int i = 0; i < n; i++) {
                vector[i] = principio.dato; // el vector va guardar los elementos del nodo principio.dato
                principio = principio.siguiente; // el nodo se mueve al siguiente nodo
                if (principio == null) { // cuando el nodo principio este vacio
                    fin = null; // puntero fin apuntara a null
                }

            }

            for (int i = n - 1; i >= 0; i--) {
                this.encolar(vector[i]); // va encolar los elementos del vector invertidos a la cola
            }
        }
    }

    public void invertirCola()  {
        T guardar;
        if(!colaVacia()) {
            try {
                guardar = this.desencolar();
                invertirCola();
                this.encolar(guardar);
            } catch (ColaVacia e) {

            }
        }

    }

    @Override
    public String getNombre() {
        return nombreCola;
    }

    @Override
    public void mostrarEstadoCola() {
        System.out.println("Estado De La Cola:");
        System.out.println("Numero Elementos: " + this.numElemCola());
        if (!colaVacia()) {
            System.out.println("Primer Elemento: " + " [Principio] -> " + principio.dato); // principio.dato es el
                                                                                           // elemento primero que esta
                                                                                           // conectado al puntero
                                                                                           // principio
            System.out.println("Ultimo Elemento: " + " [Fin] -> " + fin.dato); // fin.dato es el elemento final de la
                                                                               // cola que esta conectado al puntero fin
        }

    }

    @Override
    public void eliminarCola() {
        principio = null; // desconectamos el nodo del principio
        fin = null; // desconectamos el nodo del final
    }

    @Override
    public boolean colaVacia() {
        return principio == null;
    }

}
