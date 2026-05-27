package AlgoritmosListas;


import List.Lista;
import List.TadLista;

public class AlgoritmosListas {
	
	// insertar al principio de la lista
	public static <T> void insertarAlPrincipio(Lista<T> lista, T dato) {
		
		lista.crearNodo();
		lista.asignarClave(dato);
		
	}
	public static <T> int contar(Lista<T> lista) {
		Lista<T> aux = new TadLista<T>();
		aux.asignarReferencia(lista.devolverReferencia());
		return contar(aux, 0);
	}
	
	private static <T> int contar(Lista<T> aux, int count) {
		if(aux.devolverSiguiente() != null) {
			aux.asignarReferencia(aux.devolverSiguiente());
			count = 1 + contar(aux,count);
		}
			return count;
		
	}
	
	public static <T> void eliminarPrimero(Lista<T> lista) {
		lista.asignarReferencia(lista.devolverSiguiente());
	}
	
	public static <T> void insertarAlFinal(Lista<T> lista, T dato) {
		Lista<T> aux = new TadLista<T>();
		aux.asignarReferencia(lista.devolverReferencia());
		insertarAlFinalR(aux, dato);
	}
	
	public static <T> void insertarAlFinalR(Lista<T> aux, T dato) {
		if(aux.devolverSiguiente() != null){
			aux.asignarReferencia(aux.devolverSiguiente());
			insertarAlFinalR(aux, dato);
		}else {
			Lista<T> aux2 = new TadLista<T>();
			insertarAlPrincipio(aux2, dato);
			aux.asignarReferenciaSiguiente(aux2.devolverReferencia());
		}
	}
	
	// Metodo Recursivo insertando al final
	public static <T> void duplicarLista1(Lista<T> Lista, Lista<T> listaD) {
		Lista<T> aux = new TadLista<T>();
		aux.asignarReferencia(Lista.devolverReferencia());
		duplicarLista1R(aux, listaD);
	}
	
	private static <T> void duplicarLista1R(Lista<T> aux, Lista<T> listaD) {

		if (!aux.esNulo()) {

			if (listaD.esNulo()) {
				insertarAlPrincipio(listaD, aux.devolverClave());
			} else {
               insertarAlFinal(listaD, aux.devolverClave());
			}
			aux.asignarReferencia(aux.devolverSiguiente()); // avanzamos al siguiente nodo
			duplicarLista1R(aux, listaD); // invocacion recursiva

		}
	}
	
	// Metodo Recursivo insertando al principio 
	public static <T> void duplicarLista2(Lista<T> listaO, Lista<T> listaD) {
		Lista<T> aux = new TadLista<T>(); 
		aux.asignarReferencia(listaO.devolverReferencia()); // siguiente nodo
		duplicarLista2R(aux, listaD);
	}
	
	private static <T> void duplicarLista2R(Lista<T> aux, Lista<T> listaD) {
		
		if(!aux.esNulo()) {
			T dato = aux.devolverClave(); // guardamos el dato del nodo actual
			aux.asignarReferencia(aux.devolverSiguiente()); // avanzamos al siguiente nodo
			duplicarLista2R(aux, listaD); // invocacion recursiva
			
			insertarAlPrincipio(listaD, dato); // una vez terminada la recursividad, se insertan los datos al principio de la listaD
		}
	}
	
	public static <T> boolean buscar(Lista<T> lista, T dato) {
		Lista<T> aux = new TadLista<T>(); // aux
		aux.asignarReferencia(lista.devolverSiguiente()); // siguiente nodo
		return buscarR(aux, dato); // invocacion recursiva
	}
	
	public static <T> boolean buscarR(Lista<T> aux, T dato) {
		boolean resul = false;
		if(aux.esNulo()) { // caso base, si el nodo es nulo, quiere decir que se busco toda la lista y no se encontro el dato
			return resul;
		}
		
		if(aux.devolverClave().equals(dato)) { // si el dato del nodo actual es igual al dato buscado,  si se cumple devuelve true
			resul = true;
			return resul;
		}
		
		aux.asignarReferencia(aux.devolverSiguiente());
		return buscarR(aux, dato);
	}



}
