package archivosBinarios;

import java.io.Serializable;

/**
 * Clase Producto — entidad serializable para ejercicios de archivos binarios.
 * Implementa Serializable para poder ser escrita/leída con ObjectOutputStream.
 */
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int    codigo;
    private String nombre;
    private double precio;
    private int    stock;

    public Producto(int codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock  = stock;
    }

    // ── Getters ──────────────────────────────────────────────
    public int    getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int    getStock()  { return stock;  }

    // ── Setters ──────────────────────────────────────────────
    public void setPrecio(double precio) { this.precio = precio; }
    public void setStock(int stock)      { this.stock  = stock;  }

    @Override
    public String toString() {
        return "Producto{codigo=" + codigo
                + ", nombre='"   + nombre + "'"
                + ", precio="    + precio
                + ", stock="     + stock  + "}";
    }
}
