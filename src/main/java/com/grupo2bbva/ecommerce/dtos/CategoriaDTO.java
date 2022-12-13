package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.Categoria;
import com.grupo2bbva.ecommerce.models.Cliente;

public class CategoriaDTO {
    private Long id;
    private String nombre;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nombre = categoria.getNombre();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}
