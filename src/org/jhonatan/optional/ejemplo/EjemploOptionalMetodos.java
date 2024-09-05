package org.jhonatan.optional.ejemplo;

import org.jhonatan.optional.ejemplo.models.Computador;
import org.jhonatan.optional.ejemplo.models.Fabricante;
import org.jhonatan.optional.ejemplo.models.Procesador;
import org.jhonatan.optional.ejemplo.models.repositorio.ComputadorRespositorio;
import org.jhonatan.optional.ejemplo.models.repositorio.Repositorio;

public class EjemploOptionalMetodos {

    public static void main(String[] args) {
        ejemplo03();
    }

    public static void ejemplo01() {

        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        //si lo encuentra muestra el objeto o si no lanza una exception
        /*Fabricante pc = repositorio.filtrar("rog")
                .map(c -> c.getProcesador())
                .map(p -> p.getFabricante()).
                orElseThrow();*/
 /*forma mas simplificada*/
        Fabricante f = repositorio.filtrar("rog")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .orElseThrow();
        System.out.println("Resultado: " + f.getNombre());
    }

    public static void ejemplo02() {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        //obtiendo el nombre del fabricante filtrando por nombre y si no devolvemos un valor por defecto
        String f = repositorio.filtrar("asus")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .map(Fabricante::getNombre)
                .orElse("DESCONICIDO");
        System.out.println("Resultado: " + f);
    }

    public static void ejemplo03() {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        //obtiendo el nombre del fabricante filtrando por nombre y la vez por el fabricante intel y si no devolvemos un valor por defecto
        String f = repositorio.filtrar("asus")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .filter(fab -> "amd".equalsIgnoreCase(fab.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("DESCONOCIDO");
        System.out.println("Resultado: " + f);
    }
}
