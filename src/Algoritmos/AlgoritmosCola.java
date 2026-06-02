package Algoritmos;

import Queue.*;

public class AlgoritmosCola {
	
	public static <T> void encolarPrimero(Cola<T> cola, T dato) {
		try {
			if(cola != null) {
				cola.invertirCola();
				encolarPrimeroR(cola, dato);
			}
			else
				System.err.println("No existe la cola");
		} catch (ColaVacia e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	private static <T> void encolarPrimeroR(Cola<T> cola, T dato) throws ColaVacia {
		if(!cola.colaVacia()) {
			T elem = cola.desencolar();
			encolarPrimeroR(cola, dato);
			cola.encolar(elem);
		}
		else
			cola.encolar(dato);
	}
	
	public static <T> int contar(Cola<T> cola) {
		int resul = contarR(cola);
		cola.invertirCola();
		return resul;
	}
	
	private static <T> int contarR(Cola<T> cola) {
		int resul = -1;
		if(cola != null) {
			if(!cola.colaVacia()) {
				T elem;
				try {
					elem = cola.desencolar();
					resul = 1 + contarR(cola);
					cola.encolar(elem);
				} catch (ColaVacia e) {	
					
				}			
			}
			else
				resul = 0;
		}
		return resul;
	}
	
	public static <T> void quitarUltimo(Cola<T> cola) {
		quitarUltimoR(cola);
		cola.invertirCola();
	}
	
	private static <T> void quitarUltimoR(Cola<T> cola){
		if(!cola.colaVacia()) {
			T elem;
			try {
				elem = cola.desencolar();
				if(!cola.colaVacia()) {
					quitarUltimoR(cola);
					cola.encolar(elem);
				}
			} catch (ColaVacia e) {
				
			}	
		}
	}
	
	public static <T> void addElement(Cola<T> cola, T dato, int pos) {
		if(cola!=null && pos>0 && pos<=cola.numElemCola()+1) {
			try {
				addElement(cola, dato, pos, 1);
				cola.invertirCola();
			} catch (ColaVacia e) {

			}
			
		}
	}
	
	private static <T> void addElement(Cola<T> cola, T dato, int pos, int n) throws ColaVacia {
		if(n<pos) {
			T elem = cola.desencolar();
			addElement(cola, dato, pos, n+1);
			cola.encolar(elem);
		}
		else {
			cola.invertirCola();
			cola.encolar(dato);
		}
	}
	
	public static <T> void removeElement(Cola<T> cola, int pos) {
		if(cola!=null && pos>0 && pos<=cola.numElemCola()+1) {
			try {
				removeElement(cola, pos, 1);
				cola.invertirCola();
			} catch (ColaVacia e) {

			}
		}
	}
	
	private static <T> void removeElement(Cola<T> cola, int pos, int n) throws ColaVacia {
		if(n<=pos) {
			T elem = cola.desencolar();
			removeElement(cola, pos, n+1);
			if(n!=pos)
				cola.encolar(elem);
		}
	}
	
	public static <T> void removeElement(T dato, Cola<T> cola) {
		try {
			removeElementR(dato, cola);
			cola.invertirCola();
		} catch (ColaVacia e) {
		}
	}
	
	private static <T> void removeElementR(T dato, Cola<T> cola) throws ColaVacia {
		if(!cola.colaVacia()) {
			T elem = cola.desencolar();
			if(!elem.equals(dato)) {				
				removeElementR(dato, cola);
				cola.encolar(elem);
			}			
		}
	}
	
	public static <T> T ultimo(Cola<T> cola) {
		T resul;
		resul = ultimoR(cola);
		cola.invertirCola();
		return resul;
	}
	
	private static <T> T ultimoR(Cola<T> cola) {
		T resul=null;
		T elem;
		if(!cola.colaVacia()) {
			try {
				elem = cola.desencolar();
				if(cola.colaVacia())
					resul = elem;
				else
					resul = ultimoR(cola);
				cola.encolar(elem);
			} catch (ColaVacia e) {
				
			}			
		}
		return resul;
	}

}
