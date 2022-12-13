package com.grupo2bbva.ecommerce.dtos;

public class CategoriaDTOApplication {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaDTOApplication() {
    }

    public CategoriaDTOApplication(String nombre) {
        this.nombre = nombre;
    }
}
