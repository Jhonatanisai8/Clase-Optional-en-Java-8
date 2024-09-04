package org.jhonatan.optional.ejemplo;

import java.util.Optional;

/*
La clase Optional en Java es una clase contenedora que puede o no contener un 
valor no nulo. Es parte del paquete java.util y se introdujo en Java 8 como una
forma de manejar valores que pueden ser nulos de manera más segura y expresiva,
evitando el uso directo de null y reduciendo la posibilidad de errores comunes
como el temido NullPointerException.
 */
public class Ejemplo01ClaseOptional {

    public static void main(String[] args) {
        ejemploOptionalIsEmpty();
    }

    public static void ejemplo01Optional() {
        /*
        Optional.of(T value): Crea un Optional que contiene 
        el valor dado. Si el valor es null, lanza una excepción 
        NullPointerException.
         */
        System.out.println("\tCLASE OPTINAL");
        String nombre = "Andrez";

        //creamos el optinal
        Optional<String> opt = Optional.of(nombre);

        System.out.println("Optional: " + opt);

        /*Para ver si un valor esta presente: */
        System.out.println("Esta presente el valor: " + opt.isPresent());

        if (opt.isPresent()) {
            /* get() : obtenemos el valor.*/
            System.out.println("Hola " + opt.get());
        }

        /*isEmpty(): para ver si esta vacio*/
        System.out.println("Esta vacio: " + opt.isEmpty());

        /*para ver si el valor esta presente*/
        opt.ifPresent((t) -> {
            System.out.println("Hola " + t);
        });
    }

    public static void ejemplo02Optional() {
        System.out.println("Uso del of");
        String nombre = null;
        Optional<String> optional = Optional.of(nombre);

        System.out.println("Valor: " + optional);
    }

    public static void ejemplo03Optional() {
        System.out.println("Uso del ofNullable");
        String nombre = null;
        Optional<String> optional = Optional.ofNullable(nombre);

        System.out.println("Valor: " + optional);
    }

    public static void ejemplo04Optional() {
        System.out.println("Uso del ofNullable");
        String nombre = null;
        Optional<String> optional = Optional.ofNullable(nombre);

        System.out.println("Valor: " + optional);
        System.out.println("¿Esta presente?: " + optional.isPresent());
        System.out.println("¿Esta vacio el optional?: " + optional.isEmpty());

        /*si esta presente imprimira la frase*/
        //optional.ifPresent(valor -> System.out.println("Hola " + valor));
        optional.ifPresentOrElse(valor
                -> System.out.println("Hola: " + valor),
                () -> {
                    System.out.println("No esta presente");
                });
    }

    public static void ejemploOptionalIsEmpty() {
        System.out.println("\t=EJEMPLO DE OPTIONAL empty=");
        Optional<String> opt = Optional.empty();
        System.out.println("¿Esta vacio? = " + opt.isEmpty());
        System.out.println("¿Esta presente? = " + opt.isPresent());
        
    }
}
