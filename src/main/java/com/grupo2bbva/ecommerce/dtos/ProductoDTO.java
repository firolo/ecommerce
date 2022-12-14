package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.Producto;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private Long stock;
    private Double precio;
    private Set<CategoriaDTO> categorias;
    private boolean active;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getStock() {
        return stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public Set<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public boolean isActive() {
        return active;
    }

    public ProductoDTO() {
    }

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.stock = producto.getStock();
        this.precio = producto.getPrecio();
        /*this.categorias = producto.getProductoCategorias().stream().map(categoriaProducto ->
                new CategoriaDTO(categoriaProducto.getCategoria())).collect(toSet());*/
        this.active = producto.isActive();
    }

}
