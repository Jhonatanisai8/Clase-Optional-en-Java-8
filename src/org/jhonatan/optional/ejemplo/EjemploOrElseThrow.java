package org.jhonatan.optional.ejemplo;

import java.util.Optional;
import org.jhonatan.optional.ejemplo.models.Computador;
import org.jhonatan.optional.ejemplo.models.repositorio.ComputadorRespositorio;
import org.jhonatan.optional.ejemplo.models.repositorio.Repositorio;

public class EjemploOrElseThrow {

    public static void main(String[] args) {
        ejemploExtraerExtension();
    }

    public static void ejemplo01() {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        //retornamos la excepcion
        Computador pc = repositorio.filtrar("rog").orElseThrow(IllegalStateException::new);
        System.out.println("RESULTADO: " + pc);

    }

    //ejemplo de extraer la extension de un documento
    public static void ejemploExtraerExtension() {
        System.out.println("EJEMPLO EXTRAER EXTENSION");
        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo).filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();

        System.out.println("Resultado : " + extension);
    }

}
