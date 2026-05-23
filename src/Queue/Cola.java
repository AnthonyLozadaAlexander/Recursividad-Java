package Queue;

public interface Cola<T> {
    void encolar(T dato);

    T desencolar() throws ColaVacia;

    void imprimirCola();

    int numElemCola();

    void invertirColaIterativo();

    void invertirCola();

    String getNombre();

    void mostrarEstadoCola();

    void eliminarCola();

    boolean colaVacia();

}
