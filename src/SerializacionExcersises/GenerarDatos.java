package SerializacionExcersises;

import archivos.Escritura;

/**
 * GenerarDatos — crea el archivo binario "datos.dat" con objetos Persona.
 *
 * ▶ EJECUTA ESTE PROGRAMA UNA SOLA VEZ antes de correr practica01.
 *   Si lo ejecutas de nuevo sobreescribirá el archivo existente.
 */
public class GenerarDatos {

    public static void main(String[] args) {

        String rutaArchivo = "datos.dat";

        // Personas de ejemplo que se guardarán en el archivo
        Persona[] personas = {
            new Persona("2045763584", 61),
            new Persona("2345854380", 54),
            new Persona("1024266791", 69),
            new Persona("0151403441", 98),
            new Persona("1842674312", 35)
        };

        Escritura<Persona> escritura = new Escritura<>(rutaArchivo);

        try {
            escritura.abrir();

            for (Persona p : personas) {
                escritura.escribir(p);
                System.out.println("Guardado: " + p);
            }

            escritura.cerrar();

            System.out.println();
            System.out.println("✅ Archivo '" + rutaArchivo + "' generado correctamente.");
            System.out.println("   Total de personas: " + personas.length);

        } catch (Exception e) {
            System.err.println("❌ Error al generar el archivo: " + e.getMessage());
        }
    }
}
