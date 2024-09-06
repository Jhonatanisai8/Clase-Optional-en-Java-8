package org.jhonatan.optional.ejemplo;

import org.jhonatan.optional.ejemplo.models.Computador;
import org.jhonatan.optional.ejemplo.models.Fabricante;
import org.jhonatan.optional.ejemplo.models.Procesador;
import org.jhonatan.optional.ejemplo.models.repositorio.ComputadorRespositorio;
import org.jhonatan.optional.ejemplo.models.repositorio.Repositorio;

public class EjemploOptionalMetodos {

    public static void main(String[] args) {
        ejemplo01FlapMap();
    }

    public static void ejemplo01FlapMap() {
        // Creamos una instancia de un repositorio que almacena objetos de tipo Computador.
        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        // Aplicamos una cadena de métodos para obtener el nombre del fabricante del procesador
        // de un computador filtrado por el nombre "asus". Si el fabricante es "Ryzen 9",
        // se asigna ese nombre a la variable f, de lo contrario, se asigna "Desconocido".
        String f = repositorio.filtrar("asus") // Filtra los computadores que coinciden con "asus"
                .flatMap(Computador::getProcesador) // Obtiene el procesador del computador (si existe)
                .flatMap(Procesador::getFabricante) // Obtiene el fabricante del procesador (si existe)
                .filter(fab -> "Ryzen 9".equalsIgnoreCase(fab.getNombre())) // Filtra si el nombre del fabricante es "Ryzen 9"
                .map(Fabricante::getNombre) // Obtiene el nombre del fabricante
                .orElse("Desconocido");                   // Si no se encuentra, devuelve "Desconocido"

        // Imprime el resultado del filtro
        System.out.println("Resultado: " + f);
    }

    /*
    public static void ejemplo01() {

        Repositorio<Computador> repositorio = new ComputadorRespositorio();

        //si lo encuentra muestra el objeto o si no lanza una exception
        Fabricante pc = repositorio.filtrar("rog")
                .map(c -> c.getProcesador())
                .map(p -> p.getFabricante()).
                orElseThrow();
  forma mas simplificada
        Fabricante f = repositorio.filtrar("rog")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .orElseThrow();
        System.out.println("Resultado: " + f.getNombre());
    }

     */

 /*
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

     */
 /*    public static void ejemplo03() {
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
     */
}
