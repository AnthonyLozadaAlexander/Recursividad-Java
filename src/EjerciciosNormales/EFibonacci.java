package EjerciciosNormales;

import java.util.Scanner;

public class EFibonacci {
    public static int fibonacciR(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacciR(n-1) + fibonacciR(n - 2);
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
            System.out.print(fibonacciR(i) + " ");
        }
        System.out.print("]");
    }

}
