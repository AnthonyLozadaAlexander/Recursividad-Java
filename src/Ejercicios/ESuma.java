package Ejercicios;

class ESuma {
    static void main(String[] args) {
        int n = 10;
        int res = sumaRecursiva(n);
        System.out.println("La suma total es: " + res);
    }

    static int sumaRecursiva(int n){
        int res;

        if(n == 1){
            return 1;
        }
        else{
            res = n + sumaRecursiva(n -1);
        }

        return res;
    }
}
