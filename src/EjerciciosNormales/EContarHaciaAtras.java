package EjerciciosNormales;

public class EContarHaciaAtras {
    public static void main(String[] args) {
        f(3);
    }

    public static void f(int n) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            System.out.print(n);
        } else {
            System.out.print(n + ", ");
        }

        f(n - 1);
    }

}
