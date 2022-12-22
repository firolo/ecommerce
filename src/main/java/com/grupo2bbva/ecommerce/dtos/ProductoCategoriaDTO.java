package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.CategoriaProducto;

public class ProductoCategoriaDTO {
    private Long id;
    private Long idCategoria;
    private String nombre;
    private boolean active;

    public Long getId() {
        return id;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActive() {
        return active;
    }

    public ProductoCategoriaDTO() {
    }

    public ProductoCategoriaDTO(CategoriaProducto categoriaProducto) {
        this.id = categoriaProducto.getId();
        this.idCategoria = categoriaProducto.getCategoria().getId();
        this.nombre = categoriaProducto.getCategoria().getNombre();
        this.active = categoriaProducto.getCategoria().isActive();
    }
}
