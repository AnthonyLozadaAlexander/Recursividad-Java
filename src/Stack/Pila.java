package Stack;

public interface Pila<T> {
    boolean estaVacia();

    void apilar(T dato);

    T desapilar();

    T cima();

    int getTamanio();

    void vaciarPila();
}
