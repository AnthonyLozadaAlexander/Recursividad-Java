package archivosBinarios;

/**
 * PruebaArchivos — programa principal para probar tus implementaciones.
 *
 * PASOS ANTES DE EJECUTAR:
 *   1. Ejecuta GenerarDatos.java UNA sola vez para crear "productos.dat"
 *   2. Luego ejecuta este programa para probar tus métodos
 *
 * NO MODIFIQUES este archivo. Solo implementa los métodos en AlgoritmosArchivos.
 */
public class PruebaArchivos {

    public static void main(String[] args) {

        String archivo  = "productos.dat";
        String copia    = "productos_copia.dat";

        System.out.println("═══════════════════════════════════════════");
        System.out.println("  PRUEBA — AlgoritmosArchivos");
        System.out.println("  Archivo: " + archivo);
        System.out.println("═══════════════════════════════════════════\n");

        // ── Ejercicio 1: contarRegistros ─────────────────────
        System.out.println("── Ejercicio 1: contarRegistros ──────────");
        int total = AlgoritmosArchivos.contarRegistros(archivo);
        System.out.println("Total de productos en el archivo: " + total);
        System.out.println("Salida esperada: 7\n");

        // ── Ejercicio 2: mostrarTodos ─────────────────────────
        System.out.println("── Ejercicio 2: mostrarTodos ─────────────");
        System.out.println("Productos en orden normal:");
        AlgoritmosArchivos.<Producto>mostrarTodos(archivo);
        System.out.println("Salida esperada: 101-Manzana, 102-Leche, ... 107-Yogur\n");

        // ── Ejercicio 3: mostrarInverso ───────────────────────
        System.out.println("── Ejercicio 3: mostrarInverso ───────────");
        System.out.println("Productos en orden INVERSO:");
        AlgoritmosArchivos.<Producto>mostrarInverso(archivo);
        System.out.println("Salida esperada: 107-Yogur, ... 101-Manzana\n");

        // ── Ejercicio 4: copiarArchivo ────────────────────────
        System.out.println("── Ejercicio 4: copiarArchivo ────────────");
        AlgoritmosArchivos.copiarArchivo(archivo, copia);
        System.out.println("Verificando copia (" + copia + "):");
        AlgoritmosArchivos.<Producto>mostrarTodos(copia);
        System.out.println("Salida esperada: igual que mostrarTodos()\n");

        System.out.println("═══════════════════════════════════════════");
        System.out.println("  FIN DE PRUEBAS");
        System.out.println("═══════════════════════════════════════════");
    }
}
