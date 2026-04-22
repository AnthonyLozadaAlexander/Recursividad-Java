package Ejercicios;

class EAEuclides{
    static void main(String[] args) {

        int a = 50; int b =5;
        int res = calcularMCD(a, b);
        System.out.println("MCD de " + a + " % " + b + " = " + res);

    }

    static int calcularMCD(int a, int b){
        if(b == 0){
            return Math.abs(a);
        }
        return calcularMCD(b, a % b);
    }
}
