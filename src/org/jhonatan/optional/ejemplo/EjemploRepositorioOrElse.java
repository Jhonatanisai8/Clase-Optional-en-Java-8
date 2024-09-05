package org.jhonatan.optional.ejemplo;

import org.jhonatan.optional.ejemplo.models.Computador;
import org.jhonatan.optional.ejemplo.models.repositorio.ComputadorRespositorio;
import org.jhonatan.optional.ejemplo.models.repositorio.Repositorio;

public class EjemploRepositorioOrElse {

    public static void main(String[] args) {
        ejemplo04();
    }

    public static void ejemplo01() {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        Computador defecto = new Computador("HP Omen", "LA001");

        //en este caso devolvemos un objeto por defecto con el metodo orElse si no se encuentra el objeto  buscar
        Computador pc = repositorio.filtrar("rogs")
                .orElse(defecto);
        System.out.println("Resultado: " + pc);
    }

    public static void ejemplo02() {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        //creamos el obeto que vamos a devolver por defecto
        Computador defecto = new Computador("HP Omen", "LA001");

        //orELSEGET  retorna un objeto que encuentra en el repo
        Computador pc = repositorio.filtrar("macbooky").orElseGet(
                () -> {
                    return defecto;
                });
        System.out.println("Resultado " + pc);
    }

    public static void ejemplo03() {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        //creamos el obeto que vamos a devolver por defecto
        Computador defecto = new Computador("HP Omen", "LA001");

        //orELSEGET  retorna un objeto que encuentra en el repo
        Computador pc = repositorio.filtrar("macbooky").orElseGet(() -> new Computador("HP Omen", "LA001"));
        System.out.println("Resultado " + pc);
    }

    public static void ejemplo04() {
        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        String nombre = "rog3";
        Computador pc = repositorio.filtrar(nombre).orElseGet(EjemploRepositorioOrElse::valorDefecto);
        //orELSEGET  retorna un objeto que encuentra en el repo
        System.out.println("Resultado " + pc);
    }

    //metodo propio para obtener el valor por defecto
    public static Computador valorDefecto() {
        System.out.println("Obteniendo el valor por defecto....");
        return new Computador("LENOVO G40", "A12D");
    }
}
