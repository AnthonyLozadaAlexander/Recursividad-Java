package EjerciciosNormales;

public class EPalindromo {
    public static void main(String[] args) {
        String cadena = "reconocer";
        boolean result = esPalindromo(cadena);
        System.out.println(cadena + " es un palindromo?: " + result);
    }

    public static boolean esPalindromo(String s) {
        boolean resul = false;
        resul = esPalindromoR(s, 0, s.length() - 1);
        return resul;
    }

    private static boolean esPalindromoR(String s, int inicio, int fin) {
        boolean result = false;

        if (inicio >= fin) { // si el index inicio es == a fin, entonces es Palindromo
            result = true;
            // charAt me permite acceder al caracter en el indice del String
        } else if (s.charAt(inicio) != s.charAt(fin)) {
            result = false;
        } else {
            result = esPalindromoR(s, inicio + 1, fin - 1); // va moviendo los punteros para seguir comparando
        }

        return result;
    }

}
