package Algoritmos;

public class Busqueda {
	public static <T extends Comparable<T>> int busquedaBinaria(T dato, T[] vector) {
		int centro, inf=0, sup=vector.length-1;
		int resul = -1;
		while(inf<=sup) {
			centro = (inf+sup)/2;
			if(vector[centro].compareTo(dato)==0) {
				resul = centro;
				inf = sup+1; //salida lógica del lazo si ya lo encontró
			}
			else
				if(vector[centro].compareTo(dato)>0)
					sup = centro - 1;
				else
					inf = centro + 1;
		}
		return resul;
	}
	
	public static <T extends Comparable<T>> int busquedaBinariaR(T dato, T[] vector) {
		return busquedaBinariaR(dato, vector, 0, vector.length-1);
	}
	
	private static <T extends Comparable<T>> int busquedaBinariaR(T dato, T[] vector, int inf, int sup) {
		int centro;
		int resul = -1;
		while(inf<=sup) {
			centro = (inf+sup)/2;
			if(vector[centro].compareTo(dato)==0) {
				resul = centro;
				inf = sup+1; //salida lógica del lazo si ya lo encontró
			}
			else
				if(vector[centro].compareTo(dato)>0)
					sup = centro - 1;
				else
					inf = centro + 1;
			resul = busquedaBinariaR(dato, vector, inf, sup);
		}
		return resul;
	}
	
	public static <T extends Comparable<T>> int busquedaSecuencial(T dato, T[] vector) {
		int pos = 0, resul = -1;
		while(pos<=vector.length-1) {
			if(vector[pos].compareTo(dato)==0) {
				resul = pos;
				pos = vector.length; //salida l�gica del lazo
			}
			else
				++pos;
		}
		return resul;
	}	
	
	public static <T extends Comparable<T>> int busquedaSecuencialR(T dato, T[] vector) {
		return busquedaSecuencialR(dato, vector, 0);
	}
	
	private static <T extends Comparable<T>> int busquedaSecuencialR(T dato, T[] vector, int pos) {
		int resul = -1;
		if(pos<=vector.length-1) {
			if(vector[pos].compareTo(dato)==0)
				resul = pos;
			else
				resul = busquedaSecuencialR(dato, vector, pos+1);
		}
		return resul;
	}	
}
