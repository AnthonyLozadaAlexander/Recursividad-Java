package Stack;

public class NodoPila<T> {
    T dato; // el dato se amacenara en el nodo
    NodoPila<T> siguiente; // puntero siguiente que apuntara al nodo siguiente

    public NodoPila(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

}
