package PruebasArboles;

import Arboles.ArbolBB;
public class pruebaABB {
	 public static void main (String[] args) {
	    	ArbolBB<Integer> abb = new ArbolBB<Integer> ("Mi ABB");
	    	
	    	abb.insertar(50);
	    	abb.insertar(40);
	    	abb.insertar(30);
	    	abb.insertar(60);
	    	abb.insertar(45);
	    	abb.insertar(38);
	    	abb.insertar(75);
	    	abb.insertar(25);
	    	abb.insertar(68);
	    	System.out.println("Recorrido en PreOrden");
	    	abb.preOrder();
	    	System.out.println("\nRecorrido en InOrder");
	    	abb.inOrder();
	    	System.out.println("\nRecorrido en PosOrden");
	    	abb.postOrder();
	    	System.out.println("\nRecorrido en Amplitud");
	    	abb.listarAmplitud();
	    
	    }
}
