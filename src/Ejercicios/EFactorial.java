package Ejercicios;

public class EFactorial {
    static void main(String[] args) {
        int num = 5; int res = calcularFactorial(num);
        System.out.println("El Factorial De " + num + "! : " + res);
    }

    static int calcularFactorial(int num){
        if(num == 1 || num == 0){
            return 1;
        }else{
            return num*(calcularFactorial(num-1));
        }
    }
}
