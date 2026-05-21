package Stack;

public class TadPila<T> implements Pila<T> {

    private NodoPila<T> nodoCima; // puntero principal de la cima
    private int tamanio; // contador de elementos
    private String nombre; // nombre para la pila

    public TadPila(String nombre) {
        this.nodoCima = null; // la pila inicia vacia
        this.tamanio = 0; // su tamanio tambien inicia en 0
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaVacia() {
        return nodoCima == null; // true
    }

    public void imprimirPila() {
        boolean vacia = estaVacia();
        NodoPila<T> aux;
        aux = nodoCima;
        if (estaVacia()) {
            System.out.println("Error: Pila Vacia");
        }

        while (!vacia) {
            System.out.println(aux.dato + " ");
            aux = aux.siguiente;
            if (aux == null) {
                vacia = true;
            }

        }
        System.out.println();
    }

    public void apilar(T dato) {
        NodoPila<T> aux = new NodoPila<>(dato); // utilizamos un nodo aux para crear un nuevo nodo y poder asignar el
                                                // dato al nuevo nodo
        aux.siguiente = nodoCima; // toma el puntero de la cima y lo asigna al nuevo nodo aux
        nodoCima = aux;
        tamanio++;
    }

    public T desapilar() {
        T guardar;
        if (estaVacia()) {
            throw new IllegalStateException("La Pila se encuentra vacia");
        }
        guardar = nodoCima.dato;
        nodoCima = nodoCima.siguiente;
        tamanio--;
        return guardar;
    }

    public T cima() {
        if (estaVacia()) {
            throw new IllegalStateException("La Pila se encuentra vacia");
        }

        return nodoCima.dato;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void invertirPila() {

        TadPila<T> pilaAux = new TadPila<>("Aux");
        // pila auxiliar

        // mientras la pila no este vacia
        while (!this.estaVacia()) {
            T guardar;
            guardar = this.desapilar(); // desapilamos la pila original
            pilaAux.apilar(guardar);
        }

        nodoCima = pilaAux.nodoCima;

    }

    @Override
    public void vaciarPila() {
        // desconectamos el puntero de la cima de los nodos de la pila
        nodoCima = null;
        tamanio = 0;
    }

}
