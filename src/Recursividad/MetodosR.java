package Recursividad;

public class MetodosR {
    public static void main(String[] args) {
        PotenciarR(5, 1);
        DivisorR(2, 1);
    }

    public static void PotenciarR(int dato, int i) {
        if (i <= 10) {
            System.out.println(i + "^" + dato + "=" + Math.pow(i, dato));
            PotenciarR(dato, i + 1);
        }
    }

    public static void DivisorR(double dato, int i) {
        if (i < 20) {
            System.out.println(i + "/" + dato + "=" + (i / dato));
            DivisorR(dato, i + 1);
        }
    }
}
