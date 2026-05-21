package EjerciciosNormales;

import java.util.Scanner;

public class EPotencia {
    static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a = 0, n = 0;
        System.out.print("Ingrese La Base: "); a = input.nextInt(); input.nextLine();
        System.out.print("Ingrese El Exponente: "); n = input.nextInt(); input.nextLine();
        int res = PotenciaR(a, n);
        System.out.println(a+"^"+n+ " : " + res);
    }

    public static int PotenciaR(int a, int n){
       if(n == 0){
           return 1;
       }
       return a*PotenciaR(a,n-1);
    }
}
