package Ejercicios;

import java.util.Scanner;

public class EPares {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        int resul = 0;
        System.out.println("---------------------");
        System.out.println("   Suma De N Pares   ");
        System.out.println("---------------------");
        System.out.println("Ingrese la cantidad N a sumar: ");
        n = input.nextInt();
        input.nextLine();
        resul = sumaPar(n);
        System.out.println("El resultado es: " + resul);
        input.close();

    }

    public static int sumaPar(int n) {

        if (n <= 0) { // si n llega a ser menor igual a 0
            return 0; // retorna Cero
        }

        if (n % 2 != 0) { // si el residuo de n es distinto de 0
            n--; // Decrementa
        }

        return n + sumaPar(n - 2);
    }
}
