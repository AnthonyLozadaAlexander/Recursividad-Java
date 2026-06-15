package PruebasArboles;

import Arboles.Arbol;

public class pruebaArbolBinario {
	public static void main (String[] args) {
			
		   Arbol<Integer> a4 = new Arbol<>(4);
		   Arbol<Integer> a9 = new Arbol<>(9);
		   Arbol<Integer> a17 = new Arbol<>(17);
		   Arbol<Integer> a7 = new Arbol<>();
		   Arbol<Integer> a3 = new Arbol<>();
		   Arbol<Integer> a1 = new Arbol<Integer>();
		   
		   Arbol.juntar(a7, 7, a4, a9);
		   Arbol.juntar(a3, 3, a17, null);
		   Arbol.juntar(a1, 1, a7, a3);

		   System.out.println("Recorrido en PreOrden");
		   a1.preOrder();
		   System.out.println("\nRecorrido en InOrden");
		   a1.inOrder();
		   System.out.println("\nRecorrido en PosOrden");
		   a1.postOrder();
		   System.out.println("\nRecorrido en Amplitud");
		   a1.listarAmplitud();
		   System.out.println("Eliminar la raiz");
		   a1.eliminar(a1.getRaiz().getClave());
		   a1.info();
		   
	    
	    }
}
