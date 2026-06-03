package PruebasList;

/**
 * CLASE AUXILIAR — Estudiante
 * ────────────────────────────────────────────────────────────────────
 * PATRÓN PARA EXAMEN: cuando te pidan ordenar objetos propios con
 * Ordenacion.bubbleSort / insercion, la clase DEBE implementar
 * Comparable<T> y sobrescribir compareTo().
 *
 * Comparable<T> es la interfaz que permite a bubbleSort/insercion
 * comparar objetos con .compareTo()  →  devuelve:
 *   < 0  si this < otro
 *   = 0  si son iguales
 *   > 0  si this > otro
 */
public class Estudiante implements Comparable<Estudiante> {

    // ── ATRIBUTOS ─────────────────────────────────────────────────────────
    private String nombre;
    private double nota;   // entre 0.0 y 10.0

    // ── CONSTRUCTOR ───────────────────────────────────────────────────────
    public Estudiante(String nombre, double nota) {
        this.nombre = nombre;
        this.nota   = nota;
    }

    // ── GETTERS ───────────────────────────────────────────────────────────
    public String getNombre() { return nombre; }
    public double getNota()   { return nota;   }

    // ── compareTo — CLAVE PARA EL ORDENAMIENTO ───────────────────────────
    // Double.compare(a, b):
    //   devuelve negativo si a < b  → this.nota < otro.nota → this va primero
    //   devuelve 0          si a == b
    //   devuelve positivo   si a > b  → this va después
    // Resultado: orden ASCENDENTE por nota (menor nota → primero)
    @Override
    public int compareTo(Estudiante otro) {
        return Double.compare(this.nota, otro.nota);
        // Para orden DESCENDENTE usaríamos: Double.compare(otro.nota, this.nota)
    }

    // ── toString — para imprimir con System.out.println ──────────────────
    @Override
    public String toString() {
        return "[" + nombre + " - " + nota + "]";
    }
}
