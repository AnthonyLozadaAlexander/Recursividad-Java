package EjerciciosNormales.Repaso;

import java.util.Scanner;

public class Enumerar {
    public static void main(String[] args) {
        // int es para numeros enteros
        // in , input = entrada, output = salida
        Scanner leer = new Scanner(System.in);
        int num = 0;
        System.out.println("ingrese un limite: ");
        num = leer.nextInt();
        leer.nextLine();
        Enumerar(num);
        leer.close();

    }

    public static void Enumerar(int num) {
        System.out.print("[ ");
        for (int i = 0; i <= num; i++) {
            if (i < num) { // i <= num - 1
                System.out.print(i + " Maury, ");
            }
            if (i == num) {
                System.out.print(i + " Maury ");
            }
        }
        System.out.print(" ]");
    }
}
