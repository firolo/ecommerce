package com.grupo2bbva.ecommerce.dtos;

public class CategoriaDTOApplication {
    private Long id;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public CategoriaDTOApplication() {
    }

    public CategoriaDTOApplication(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
