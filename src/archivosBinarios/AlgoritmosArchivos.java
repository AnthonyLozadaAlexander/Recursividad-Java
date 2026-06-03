package archivosBinarios;

import archivos.Lectura;
import archivos.Escritura;

/**
 * AlgoritmosArchivos — implementación de métodos recursivos sobre archivos binarios.
 *
 * REGLAS aplicadas:
 *   - Solo recursión (sin for, while, do-while)
 *   - TADs: Lectura<T> y Escritura<T> del paquete archivos
 *   - Todos los métodos son genéricos (<T>)
 *   - Protección con try-catch en todas las operaciones de archivo
 */
public class AlgoritmosArchivos {

    // ════════════════════════════════════════════════════════
    //  EJERCICIO 1 — contarRegistros
    // ════════════════════════════════════════════════════════

    /**
     * Cuenta recursivamente cuántos objetos hay almacenados en el archivo.
     * Abre el stream, delega la recursión al método privado y cierra el stream.
     *
     * @param archivo ruta del archivo binario (.dat)
     * @return número total de objetos en el archivo, 0 si está vacío o no existe
     */
    public static <T> int contarRegistros(String archivo) {
        if (archivo == null || archivo.isEmpty()) {
            return 0;
        }

        Lectura<T> lector = new Lectura<>(archivo);
        int resultado = 0;

        try {
            lector.abrir();
            resultado = contarRegistrosR(lector);  // delega la recursión
            lector.cerrar();
        } catch (Exception e) {
            System.err.println("contarRegistros — error al acceder al archivo: " + e.getMessage());
        }

        return resultado;
    }

    /**
     * Método privado recursivo que lee objeto a objeto y cuenta.
     *
     * Caso base:    lector.leer() retorna null  → fin del archivo → return 0
     * Paso recurs.: objeto leído                → 1 + contarRegistrosR(lector)
     *
     * @param lector stream de lectura ya abierto
     * @return cantidad de objetos restantes desde la posición actual
     */
    private static <T> int contarRegistrosR(Lectura<T> lector) {
        try {
            T objeto = lector.leer();   // intenta leer el siguiente objeto

            if (objeto == null) {
                return 0;               // caso base: llegó al final del archivo
            }

            return 1 + contarRegistrosR(lector);  // cuenta este + el resto

        } catch (Exception e) {
            System.err.println("contarRegistrosR — error de lectura: " + e.getMessage());
            return 0;
        }
    }


    // ════════════════════════════════════════════════════════
    //  EJERCICIO 2 — mostrarTodos
    // ════════════════════════════════════════════════════════

    /**
     * Lee e imprime recursivamente todos los objetos del archivo en orden directo
     * (del primero guardado al último).
     *
     * @param archivo ruta del archivo binario (.dat)
     */
    public static <T> void mostrarTodos(String archivo) {
        if (archivo == null || archivo.isEmpty()) {
            System.out.println("mostrarTodos — archivo no especificado.");
            return;
        }

        Lectura<T> lector = new Lectura<>(archivo);

        try {
            lector.abrir();
            mostrarTodosR(lector);      // delega la recursión
            lector.cerrar();
        } catch (Exception e) {
            System.err.println("mostrarTodos — error al acceder al archivo: " + e.getMessage());
        }
    }

    /**
     * Método privado recursivo que imprime cada objeto en la BAJADA (ida).
     * Imprime ANTES de la llamada recursiva → orden directo (primero al último).
     *
     * Caso base:    objeto == null  → fin del archivo → return
     * Paso recurs.: imprime el objeto actual, luego llama al siguiente
     *
     * @param lector stream de lectura ya abierto
     */
    private static <T> void mostrarTodosR(Lectura<T> lector) {
        try {
            T objeto = lector.leer();   // lee el siguiente objeto

            if (objeto == null) {
                return;                 // caso base: no hay más objetos
            }

            System.out.println(objeto); // ← imprime ANTES de la llamada recursiva
            mostrarTodosR(lector);      // ← avanza al siguiente objeto

        } catch (Exception e) {
            System.err.println("mostrarTodosR — error de lectura: " + e.getMessage());
        }
    }


    // ════════════════════════════════════════════════════════
    //  EJERCICIO 3 — mostrarInverso
    // ════════════════════════════════════════════════════════

    /**
     * Lee el archivo y muestra todos los objetos en orden INVERSO usando backtracking.
     * No usa ninguna estructura auxiliar (sin pilas, listas ni arreglos).
     *
     * @param archivo ruta del archivo binario (.dat)
     */
    public static <T> void mostrarInverso(String archivo) {
        if (archivo == null || archivo.isEmpty()) {
            System.out.println("mostrarInverso — archivo no especificado.");
            return;
        }

        Lectura<T> lector = new Lectura<>(archivo);

        try {
            lector.abrir();
            mostrarInversoR(lector);    // delega la recursión
            lector.cerrar();
        } catch (Exception e) {
            System.err.println("mostrarInverso — error al acceder al archivo: " + e.getMessage());
        }
    }

    /**
     * Método privado recursivo que imprime cada objeto en la SUBIDA (vuelta).
     * Imprime DESPUÉS de la llamada recursiva → backtracking → orden inverso.
     *
     * Caso base:    objeto == null  → fin del archivo → return
     * Paso recurs.: primero llama al siguiente, luego imprime el actual
     *
     * @param lector stream de lectura ya abierto
     */
    private static <T> void mostrarInversoR(Lectura<T> lector) {
        try {
            T objeto = lector.leer();   // lee el siguiente objeto

            if (objeto == null) {
                return;                 // caso base: no hay más objetos
            }

            mostrarInversoR(lector);    // ← llama PRIMERO (baja hasta el final)
            System.out.println(objeto); // ← imprime DESPUÉS (al regresar = backtracking)

        } catch (Exception e) {
            System.err.println("mostrarInversoR — error de lectura: " + e.getMessage());
        }
    }


    // ════════════════════════════════════════════════════════
    //  EJERCICIO 4 — copiarArchivo
    // ════════════════════════════════════════════════════════
    /**
     * Copia recursivamente todos los objetos de un archivo origen
     * a un archivo destino, en el MISMO orden.
     *
     * @param origen   ruta del archivo a leer
     * @param destino  ruta del archivo a escribir
     */
    public static <T> void copiarArchivo(String origen, String destino) {
        if (origen == null || destino == null || origen.isEmpty() || destino.isEmpty()) {
            System.out.println("copiarArchivo — rutas de archivo no especificadas.");
            return;
        }

        Lectura<T>   lector   = new Lectura<>(origen);
        Escritura<T> escritor = new Escritura<>(destino);

        try {
            lector.abrir();                         // abre stream de lectura
            escritor.abrir();                       // abre stream de escritura
            copiarArchivoR(lector, escritor);       // delega la recursión
            lector.cerrar();
            escritor.cerrar();
            System.out.println("Copia completada: " + origen + " → " + destino);
        } catch (Exception e) {
            System.err.println("copiarArchivo — error: " + e.getMessage());
        }
    }

    /**
     * Método privado recursivo que lee un objeto del origen y lo escribe en el destino.
     * Escribe ANTES de la llamada recursiva → mismo orden que el original.
     *
     * Caso base:    objeto == null  → fin del archivo → return
     * Paso recurs.: escribe el objeto actual, luego copia el siguiente
     *
     * @param lector   stream de lectura ya abierto (origen)
     * @param escritor stream de escritura ya abierto (destino)
     */
    private static <T> void copiarArchivoR(Lectura<T> lector, Escritura<T> escritor) {
        try {
            T objeto = lector.leer();               // lee el siguiente objeto del origen

            if (objeto == null) {
                return;                             // caso base: no hay más objetos
            }

            escritor.escribir(objeto);              // ← escribe ANTES (orden directo)
            copiarArchivoR(lector, escritor);       // ← avanza al siguiente

        } catch (Exception e) {
            System.err.println("copiarArchivoR — error: " + e.getMessage());
        }
    }

}
