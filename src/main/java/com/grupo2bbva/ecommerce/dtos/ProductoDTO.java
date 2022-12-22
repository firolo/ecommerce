package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.Producto;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private Long stock;
    private Double precio;
    private Set<ProductoCategoriaDTO> categorias;
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

    public Set<ProductoCategoriaDTO> getCategorias() {
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
        this.categorias = producto.getProductoCategorias().stream().map(ProductoCategoriaDTO::new).collect(toSet());
        this.active = producto.isActive();
    }

}
