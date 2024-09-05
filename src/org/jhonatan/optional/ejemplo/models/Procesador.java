package org.jhonatan.optional.ejemplo.models;

public class Procesador {

    private String procesador;
    private Fabricante fabricante;

    public Procesador(String procesador, Fabricante fabricante) {
        this.procesador = procesador;
        this.fabricante = fabricante;
    }

    public Procesador() {

    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

}
