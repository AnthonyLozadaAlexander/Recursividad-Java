package SerializacionExcersises;

import Stack.Pila;
import Stack.TadPila;
import Stack.PilaVacia;
import archivos.Lectura;

public class practica01 {
    public static void main(String[] args) {

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
            fondo = guardar; // fondo
            pila.apilar(guardar);
        }else{
            fondo = obtenerFondoR((pila));
            pila.apilar(fondo);
        }
        return fondo;
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
