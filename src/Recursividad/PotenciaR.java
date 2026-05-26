package Recursividad;

public class PotenciaR {
    public static void main(String[] args) {
        PotenciarR(5, 1);
    }

    public static void PotenciarR(int dato, int i) {
        if (i <= 10) {
            System.out.println(i + "^" + dato + "=" + Math.pow(i, dato));
            PotenciarR(dato, i + 1);
        }
    }

}
