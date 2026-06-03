package SerializacionExcersises;

import Stack.Pila;
import Stack.TadPila;
import Stack.PilaVacia;
import archivos.Lectura;

public class practica01 {
    public static void main(String[] args) {

        String archivo = "datos.dat";

        // ── PRUEBA 1: crearPila desde archivo ──────────────────
        System.out.println("Pila de personas del archivo: " + archivo);
        Pila<Persona> pPersonas = crearPila(archivo);
        System.out.print("Estado de la pila Personas: ");
        pPersonas.imprimirPila();

        // ── PRUEBA 2: intercambiar cima con fondo ──────────────
        System.out.println();
        System.out.println("Intercambiar la cima con el fondo");

        // Pila de prueba manual
        Pila<Persona> pIntercambio = new TadPila<>("Personas");
        pIntercambio.apilar(new Persona("2108871720", 96));
        pIntercambio.apilar(new Persona("0754224558", 29));
        pIntercambio.apilar(new Persona("2032270965", 44));
        pIntercambio.apilar(new Persona("1633515562", 52));

        System.out.println("Pila original");
        System.out.print("Estado de la pila Personas: ");


        intercambiar(pIntercambio);

        System.out.println("Pila cambiada");
        System.out.print("Estado de la pila Personas: ");
        pIntercambio.imprimirPila();
    }

    public static  <T> Pila<T> crearPila(String archivo){
       Pila<T> pila = new TadPila<>("Pila");

       if(archivo != null && !archivo.isEmpty()){
           Lectura<T> lector = new Lectura<>(archivo);
           try{
               lector.abrir();
               crearPilaR(lector, pila);
               lector.cerrar();
           }catch(Exception e){
               System.err.println(e.getMessage());
           }
       }

        return pila;
    }

    private static <T> void crearPilaR(Lectura<T> lector, Pila<T> pila){
        try{
            T objeto = lector.leer();
            if(objeto != null){ // si el objeto existe
                crearPilaR(lector, pila);
                pila.apilar(objeto);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static <T> void intercambiar(Pila<T> pila){
        try{
            if(pila != null && !pila.pilaVacia() && pila.getTamanio() >  1){
                T cima = pila.desapilar();
                T fondo = obtenerFondoR(pila);
                remplazarFondoR(pila, cima);
                pila.apilar(fondo);
            }
        }catch(PilaVacia e){
            System.err.println(e.getMessage());
        }
    }

    private static <T> T obtenerFondoR(Pila<T> pila) throws PilaVacia{
        T guardar = pila.desapilar();
        T fondo;

        if(pila.pilaVacia()){
            fondo = guardar;            // caso base: guardar ES el fondo
            pila.apilar(guardar);       // restaura el fondo
        }else{
            fondo = obtenerFondoR(pila); // sigue bajando
            pila.apilar(guardar);        // restaura este elemento al subir ✅
        }
        return fondo;                   // única salida
    }

    private static <T> void remplazarFondoR(Pila<T> pila, T nuevoValor) throws PilaVacia {
        T guardar = pila.desapilar();
        if(pila.pilaVacia()){
            pila.apilar(nuevoValor);
        }else{
            remplazarFondoR(pila, nuevoValor);
            pila.apilar(guardar);
        }
    }


}
