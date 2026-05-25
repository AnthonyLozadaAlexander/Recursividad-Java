package Stack;

public interface Pila<T> {
    boolean pilaVacia() throws PilaVacia;

    void apilar(T dato);

    T desapilar() throws PilaVacia;

    T cima();

    int getTamanio();

    void vaciarPila();
}
