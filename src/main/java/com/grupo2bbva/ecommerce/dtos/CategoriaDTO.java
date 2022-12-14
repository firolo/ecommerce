package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.Categoria;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoriaDTO {
    private Long id;
    private String nombre;
    private boolean active;

    private Set<CategoriaProductoDTO> productos;

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

    public Set<CategoriaProductoDTO> getProductos() {
        return productos;
    }

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nombre = categoria.getNombre();
        this.active = categoria.isActive();
        //this.productos = categoria.getCategoriaProductos().stream().map(categoriaProducto -> new ProductoDTO(categoriaProducto.getProducto())).collect(Collectors.toList());
        this.productos = categoria.getCategoriaProductos().stream().map(CategoriaProductoDTO::new).collect(Collectors.toSet());
    }
}