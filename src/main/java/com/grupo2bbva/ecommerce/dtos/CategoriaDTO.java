package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.Categoria;

public class CategoriaDTO {
    private Long id;
    private String nombre;
    private boolean active;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nombre = categoria.getNombre();
        this.active = categoria.isActive();
    }
}
