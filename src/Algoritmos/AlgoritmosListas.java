package Algoritmos;

import List.*;

public class AlgoritmosListas {
	public static <T> void insertarAlPrincipio(Lista<T> lista, T dato) {
		lista.crearNodo();
		lista.asignarClave(dato);
	}
	
	public static <T> int contar(Lista<T> lista) {
		Lista<T> aux = new TadLista<T>();
		aux.asignarReferencia(lista.devolverReferencia());
		return contar(aux, 0);
	}
	
	private static <T> int contar(Lista<T> aux, int cont) {		
		if(aux.devolverReferencia() != null) {
			cont = cont + 1;
			aux.asignarReferencia(aux.devolverSiguiente());
			cont = contar(aux, cont);
		} 
		return cont;
	}
	
	public static <T> void eliminarPrimero(Lista<T> lista) {
		lista.asignarReferencia(lista.devolverSiguiente());
	}

	public static <T> void insertarAlFinal(Lista<T> lista, T dato) {
		Lista<T> aux = new TadLista<T>();
		aux.asignarReferencia(lista.devolverReferencia());
		insertarAlFinalR(aux, dato);
	}

	private static <T> void insertarAlFinalR(Lista<T> aux, T dato) {
		if(aux.devolverSiguiente() != null) {
			aux.asignarReferencia(aux.devolverSiguiente());
			insertarAlFinalR(aux, dato);
		}
		else {
			Lista<T> aux2 = new TadLista<T>();
			insertarAlPrincipio(aux2, dato);
			aux.asignarReferenciaSiguiente(aux2.devolverReferencia());
		}
	}
	
	public static <T extends Comparable<T>> boolean buscar(Lista<T> lista, T dato) {
		if(lista != null && !lista.esNulo()) {
			Lista<T> aux = new TadLista<T>();
			aux.asignarReferencia(lista.devolverReferencia());
			return buscarR(aux, dato);
		}
		else
			return false;
	}
	
	private static <T extends Comparable<T>> boolean buscarR(Lista<T> aux, T dato) {
		if(!aux.esNulo()) {
			if(aux.devolverClave().compareTo(dato) == 0) {
				return true;
			}
			else {
				aux.asignarReferencia(aux.devolverSiguiente());
				return buscarR(aux, dato);
			}
		}
		else
			return false;
	}
	
	public static <T> void duplicarLista1(Lista<T> listaO, Lista<T> listaD){
		if(listaO != null && listaD != null) {
			Lista<T> aux =  new TadLista<>();
			aux.asignarReferencia(listaO.devolverReferencia());
			duplicarLista1R(aux, listaD);
		}
		
	}
	
	private static <T> void duplicarLista1R(Lista<T> aux, Lista<T> listaD){
		if(!aux.esNulo()) {
			insertarAlFinal(listaD, aux.devolverClave());
			aux.asignarReferencia(aux.devolverSiguiente());
			duplicarLista1R(aux, listaD);
		}
	}
	
	public static <T> void duplicarLista2(Lista<T> listaO, Lista<T> listaD){
		if(listaO != null && listaD != null) {
			Lista<T> aux =  new TadLista<>();
			aux.asignarReferencia(listaO.devolverReferencia());
			duplicarLista2R(aux, listaD);
		}
	}
	
	private static <T> void duplicarLista2R(Lista<T> aux, Lista<T> listaD){
		if(!aux.esNulo()) {
			T elem = aux.devolverClave();
			aux.asignarReferencia(aux.devolverSiguiente());
			duplicarLista2R(aux, listaD);
			insertarAlPrincipio(listaD, elem);
		}
	}	
	
}
