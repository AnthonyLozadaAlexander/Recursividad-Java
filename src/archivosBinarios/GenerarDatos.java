package archivosBinarios;

import archivos.Escritura;

/**
 * GenerarDatos — programa auxiliar que crea el archivo binario "productos.dat"
 * con objetos Producto serializados.
 *
 * EJECUTA ESTE PROGRAMA UNA SOLA VEZ para generar el archivo de datos.
 * Después de ejecutarlo, NO lo vuelvas a correr o sobreescribirá los datos.
 */
public class GenerarDatos {

    public static void main(String[] args) {

        // Ruta del archivo que se va a generar
        String rutaArchivo = "productos.dat";

        // Datos de ejemplo que se guardarán en el archivo
        Producto[] productos = {
            new Producto(101, "Manzana",    1.50,  200),
            new Producto(102, "Leche",      0.99,  150),
            new Producto(103, "Pan",        2.30,   80),
            new Producto(104, "Arroz",      1.75,  300),
            new Producto(105, "Aceite",     3.20,   60),
            new Producto(106, "Huevos",     2.50,  120),
            new Producto(107, "Yogur",      1.10,   90)
        };

        // Usamos el TAD Escritura del paquete archivos
        Escritura<Producto> escritura = new Escritura<>(rutaArchivo);

        try {
            escritura.abrir();

            for (Producto p : productos) {
                escritura.escribir(p);
                System.out.println("Guardado: " + p);
            }

            escritura.cerrar();
            System.out.println("\n✅ Archivo '" + rutaArchivo + "' generado correctamente.");
            System.out.println("   Total de productos guardados: " + productos.length);

        } catch (Exception e) {
            System.err.println("❌ Error al generar el archivo: " + e.getMessage());
        }
    }
}
