package Ejercicios;

class EAEuclides{
    static void main(String[] args) {

    }

    static int calcularMCD(int a, int b){
        if(b == 0){
            return Math.abs(a);
        }

        return calcularMCD(b, a % b);
    }
}
