package org.jhonatan.optional.ejemplo.models.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.jhonatan.optional.ejemplo.models.Computador;

public class ComputadorRespositorio
        implements Repositorio<Computador> {

    private List<Computador> dataSource;

    public ComputadorRespositorio() {
        dataSource = new ArrayList<>();
        dataSource.add(new Computador("Asus ROG", "Strix G512"));
        dataSource.add(new Computador("MacBook", "MNK2CI"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
        /*return dataSource.stream().filter(c -> c.getNombre().equalsIgnoreCase(nombre)
        ).findFirst();
         */
        return dataSource.stream().filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase())
        ).findFirst();

        /*for (Computador computador : dataSource) {
            if (computador.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(computador);
            }

        }
        //devuelve un vacio
        return Optional.empty();*/
    }

}
