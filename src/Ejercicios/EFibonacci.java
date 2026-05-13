package Ejercicios;

import java.util.Scanner;

public class EFibonacci {
    public static int factorialR(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return factorialR(n-1) + factorialR(n - 2);
    }

    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int limite = 0;
        System.out.println("------------------------");
        System.out.println(" Secuencia De Fibonacci ");
        System.out.println("------------------------");
        System.out.print("Ingrese el limite de la sucuencia: "); limite = input.nextInt();
        input.nextLine();
        System.out.println("------------------------");
        System.out.print("[ ");
        for (int i = 0; i < limite; i++) {
            System.out.print(factorialR(i) + " ");
        }
        System.out.print(" ]");
    }

}
