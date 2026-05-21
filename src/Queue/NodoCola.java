package Queue;

public class NodoCola<T> {
    T dato;
    NodoCola<T> siguiente;

    NodoCola(T dato, NodoCola<T> siguiente) {
        this.dato = dato;
        this.siguiente = null;
    }

}
