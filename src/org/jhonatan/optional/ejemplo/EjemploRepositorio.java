package org.jhonatan.optional.ejemplo;

import java.util.Optional;
import org.jhonatan.optional.ejemplo.models.Computador;
import org.jhonatan.optional.ejemplo.models.repositorio.ComputadorRespositorio;
import org.jhonatan.optional.ejemplo.models.repositorio.Repositorio;

public class EjemploRepositorio {

    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        repositorio.filtrar("rog")
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No se encontro."));

    }

    public static void ejemplo01Optional() {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();
        Optional<Computador> pc = repositorio.filtrar("Asus ROG");
//        System.out.println("Resultado: " + pc.getNombre());

        if (pc.isPresent()) {
            System.out.println("Resultado");
            System.out.println(pc.get().getModelo());
        } else {
            System.out.println("No se encontro.");
        }
    }

}
