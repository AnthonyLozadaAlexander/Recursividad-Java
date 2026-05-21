package EjerciciosNormales;

import java.util.Scanner;

public class EImpar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        int resultado = 0;
        System.out.println("Ingrese Hasta Que Numero Impar Desea Sumar: ");
        n = input.nextInt();
        input.nextLine();
        resultado = sumaImpar(n);
        System.out.println("La suma de los numeros impares hasta " + n + " es: " + resultado);
        input.close();
    }

    public static int sumaImpar(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n % 2 == 0) {
            n = n - 1; // n--
            return sumaImpar(n);
        } else {
            return n + sumaImpar(n - 1);
        }
    }
}
