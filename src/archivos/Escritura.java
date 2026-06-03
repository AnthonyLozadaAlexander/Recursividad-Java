package archivos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Escritura<T> {
	private String nombreArchivo;
	private FileOutputStream archivo;
	private ObjectOutputStream escritura;

	public Escritura(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}

	public void abrir() throws IOException {
		archivo = new FileOutputStream(nombreArchivo);
		escritura = new ObjectOutputStream(archivo);
	}
	
	public void escribir(T dato) throws IOException {
		if(escritura != null)
			escritura.writeObject(dato);
	}
	
	public void cerrar() throws IOException {
		if(escritura != null)
			escritura.close();
	}

}
