package EjerciciosNormales;

/*📝 Enunciado: Número Primo con Recursividad 
  ## Descripción del Problema

  Escribe un programa en Java que determine si un número entero N es primo, usando exclusivamente recursividad (sin bucles
  for ,  while  ni  do-while ).
  │ Un número es primo si es mayor que 1 y solo es divisible por 1 y por sí mismo.
  ──────
  ## Requisitos

  Debes implementar dos métodos:

  •  esPrimo(int n)  → Método público que recibe el número a evaluar y retorna  boolean . Su único trabajo es llamar al
  auxiliar con el divisor inicial 2.
  •  auxiliar(int n, int divisor)  → Método privado que contiene toda la lógica recursiva.
  ──────
  ## Lógica (evalúa las condiciones en este orden)

  1. Si  n <= 1  → retorna false (no es primo por definición)

  2. Si  n % divisor == 0  → retorna false (encontró un divisor exacto)

  3. Si  divisor * divisor > n  → retorna true (es primo, ya no hay más divisores posibles)

  4. Si ninguna anterior se cumple → llama recursivamente con  divisor + 1 
  ──────
  ## Ejemplos Esperados

    esPrimo(1)   →  false
    esPrimo(2)   →  true
    esPrimo(7)   →  true
    esPrimo(9)   →  false
    esPrimo(13)  →  true
    esPrimo(25)  →  false
  ──────
  ## Traza Rápida con N = 7

    auxiliar(7, 2)  →  7 % 2 != 0  y  2x2=4 < 7  →  sigue...
    auxiliar(7, 3)  →  7 % 3 != 0  y  3x3=9 > 7  →  retorna true ✅
  ──────
  │ 💡 Pista clave: No necesitas probar divisores hasta  N - 1 . Basta con llegar hasta la raíz cuadrada de N para
  │ garantizar el resultado.
 */

public class ENumPrimo {
    public static void main(String[] args) {
        int n = 7;
        boolean resul = esPrimo(n);
        System.out.println("El numero " + n + " es Primo? = " + resul);

    }

    public static boolean esPrimo(int n) {
        boolean result;
        result = esPrimoR(n, 2);
        return result;
    }

    private static boolean esPrimoR(int n, int divisor) {
        boolean result = false;

        if (n <= 1) {
            result = false;
        } else if (Math.pow((divisor), 2) > n) {
            result = true;
        } else if (divisor % n == 0) {
            result = false;
        } else {
            result = esPrimoR(n, divisor + 1);
        }

        return result;

    }

}
