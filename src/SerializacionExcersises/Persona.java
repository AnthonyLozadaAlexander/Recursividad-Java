package SerializacionExcersises;

import java.io.Serializable;

/**
 * Persona — entidad serializable para el ejercicio de pilas con archivos.
 * Implementa Serializable para poder guardarse en un archivo .dat.
 */
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cedula;
    private int    edad;

    public Persona(String cedula, int edad) {
        this.cedula = cedula;
        this.edad   = edad;
    }

    public String getCedula() { return cedula; }
    public int    getEdad()   { return edad;   }

    @Override
    public String toString() {
        return cedula + "-" + edad;
    }
}
