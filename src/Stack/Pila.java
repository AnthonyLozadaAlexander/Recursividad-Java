package Stack;

public interface Pila<T> {
    boolean estaVacia();

    void apilar(T dato);

    T desapilar() throws PilaVacia;

    T cima();

    int getTamanio();

    void vaciarPila();
}
