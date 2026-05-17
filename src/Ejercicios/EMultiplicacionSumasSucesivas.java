package Ejercicios;

import java.util.Scanner;

public class EMultiplicacionSumasSucesivas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int resultado = 0;
        System.out.println("Ingrese dos numeros para multiplicar");
        System.out.println("Ingrese A: ");
        a = input.nextInt();
        input.nextLine();

        System.out.println("Ingrese B: ");
        b = input.nextInt();
        input.nextLine();

        resultado = sumaS(a, b);
        System.out.println("El resultado de multiplicar: ("+ a + ")(" + b + ") = " + resultado);

        input.close();
    }

    public static int sumaS(int a, int b) {
        if (b == 0) {
            return 0;
        }

        return a + sumaS(a, b - 1);
    }
}
