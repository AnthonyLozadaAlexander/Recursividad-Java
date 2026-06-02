package Algoritmos;

import Stack.*;

public class AlgoritmosPila {
	public static <T> int contar(Pila<T> pila) throws PilaVacia {
		int resul = 0;
		T elem;
		
		if(pila!=null)
			if(!pila.pilaVacia()) {
				try {
					elem = pila.desapilar();			
					resul = 1 + contar(pila);
					pila.apilar(elem);
				} catch (PilaVacia e) {
	
				}
			}
			else
				resul=0;
		else
			resul=-1;
				
		return resul;
	}
	
	public static <T> void sumergir(Pila<T> pila, T dato) throws PilaVacia {
		T elem;
		if(pila!=null)
			if(!pila.pilaVacia()) {
				try {
					elem = pila.desapilar();
					sumergir(pila, dato);
					pila.apilar(elem);
				} catch (PilaVacia e) {
					
				}	
			} 
			else 
				pila.apilar(dato);
	}
	
	public static <T> T fondo(Pila<T> pila) throws PilaVacia{
		T resul = null;
		T elem;
		
		if(!pila.pilaVacia()) {
			try {
				elem = pila.desapilar();
				if(pila.pilaVacia())
					resul = elem;
				else
					resul = fondo(pila);
				pila.apilar(elem);
			} catch (PilaVacia e) {
				
			}			
		}
		return resul;
	}
	
	public static <T> void invertirPila(Pila<T> pila) throws PilaVacia{
		T elem;
		
		if(!pila.pilaVacia()) {
			try {
				elem = pila.desapilar();
				invertirPila(pila);
				sumergir(pila, elem);
			} catch (PilaVacia e) {

			}
			
		}
	}
	
}
