package EjerciciosNormales;

import java.util.Scanner;

public class EContarDigitos {
    static void main(String[] args) {
        Long start = System.nanoTime();
        Scanner input = new Scanner(System.in);
        int n = 0, digitos = 0;
        System.out.println("----------------------------------------");
        System.out.println("          CONTADOR DE DIGITOS           ");
        System.out.println("----------------------------------------");
        System.out.print("Ingrese el numero entero Positivo: "); n = input.nextInt();
        input.nextLine();
        digitos = ContarDigitos(n);
        System.out.println("Numero Ingresado: " + n);
        System.out.println("Digitos: " + digitos);
        System.out.println("----------------------------------------");
        Long end = System.nanoTime();
        System.out.println("Tiempo Total Ejecucion: " + (end - start) + " nanosegundos");
    }

    public static int ContarDigitos(int n){
        if(n < 10){
            return 1;
        }

        return 1 + ContarDigitos(n / 10);
    }
}
