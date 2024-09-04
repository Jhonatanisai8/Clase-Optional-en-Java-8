package org.jhonatan.optional.ejemplo.models.repositorio;

import java.util.ArrayList;
import java.util.List;
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
    public Computador filtrar(String nombre) {
        for (Computador computador : dataSource) {
            if (computador.getNombre().equalsIgnoreCase(nombre)) {
                return computador;
            }
        }
        return null;

    }

}
