package PruebasRecursivas;

import AlgoritmosListas.AlgoritmosListas;
import AlgoritmosQueue.AlgoritmoCola;
import AlgoritmosStack.AlgoritmosPila;
import List.TadLista;
import Queue.ColaVacia;
import Queue.TadCola;
import Stack.PilaVacia;
import Stack.TadPila;

public class PruebaCrudRecursivo {

    public static void main(String[] args) throws PilaVacia, ColaVacia {
        pruebaLista();
        pruebaPila();
        pruebaCola();
    }

    private static void pruebaLista() {
        TadLista<Integer> lista = new TadLista<>("ListaCRUD");
        AlgoritmosListas.insertarAlPrincipio(lista, 3);
        AlgoritmosListas.insertarAlPrincipio(lista, 2);
        AlgoritmosListas.insertarAlPrincipio(lista, 1);

        System.out.print("Lista inicial: ");
        AlgoritmosListas.imprimirLista(lista);
        System.out.println("Elemento en pos 2: " + AlgoritmosListas.obtenerEnPosicion(lista, 2));
        AlgoritmosListas.insertarEnPosicion(lista, 99, 2);
        AlgoritmosListas.actualizarEnPosicion(lista, 3, 77);
        AlgoritmosListas.eliminarPrimeraOcurrencia(lista, 99);
        AlgoritmosListas.invertirLista(lista);
        System.out.print("Lista final: ");
        AlgoritmosListas.imprimirLista(lista);
    }

    private static void pruebaPila() throws PilaVacia {
        TadPila<Integer> pila = new TadPila<>("PilaCRUD");
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);

        System.out.println("Cima de pila: " + pila.cima());
        AlgoritmosPila.insertarEnBase(pila, 0);
        AlgoritmosPila.actualizarEnPosicionSeguro(pila, 2, 88);
        AlgoritmosPila.eliminarPrimeraOcurrencia(pila, 2);
        System.out.println("Base de pila: " + AlgoritmosPila.obtenerBase(pila));
    }

    private static void pruebaCola() throws ColaVacia {
        TadCola<Integer> cola = new TadCola<>("ColaCRUD");
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);

        System.out.println("Frente de cola: " + AlgoritmoCola.obtenerFrente(cola));
        AlgoritmoCola.encolarAlFrente(cola, 0);
        AlgoritmoCola.actualizarEnPosicion(cola, 2, 99);
        AlgoritmoCola.eliminarPrimeraOcurrencia(cola, 2);
        AlgoritmoCola.rotarHaciaLaIzquierda(cola, 1);
        System.out.println("Buscar 99: " + AlgoritmoCola.buscarElemento(cola, 99));
        cola.imprimirCola();
    }
}

