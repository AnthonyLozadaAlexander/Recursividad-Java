package EjerciciosNormales;

import java.util.Scanner;

public class ESumaDigitos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        int resultado = 0;
        System.out.println("------------------------");
        System.out.println("    Ingrese El Numero   ");
        System.out.println("------------------------");
        System.out.print("-> "); num = input.nextInt();
        System.out.println("------------------------");
        System.out.println("La suma de los digitos es: ");
        resultado = sumDigitos(num);
        System.out.println(resultado);
        System.out.println("------------------------");
        input.close();

    }

    public static int sumDigitos(int num){
        int aux = 0;
        if(num == 0){
            return 0;
        }
        aux = num;
        num = num % 10; // guarda el ultimo digito del numero

        return num + sumDigitos(aux / 10); // quita el ultimo diito del numero
    }

}
