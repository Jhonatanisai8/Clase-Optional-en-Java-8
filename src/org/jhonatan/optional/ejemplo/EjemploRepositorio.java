package org.jhonatan.optional.ejemplo;

import org.jhonatan.optional.ejemplo.models.Computador;
import org.jhonatan.optional.ejemplo.models.repositorio.ComputadorRespositorio;
import org.jhonatan.optional.ejemplo.models.repositorio.Repositorio;

public class EjemploRepositorio {

    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();
        Computador pc = repositorio.filtrar("Asus");
//        System.out.println("Resultado: " + pc.getNombre());

        //forma tipica de validar si se encontro o no el objeto 
        if (pc != null) {
            System.out.println("Resultado: " + pc.getNombre());
        } else {
            System.out.println("No se encontro.");
        }
    }

}
