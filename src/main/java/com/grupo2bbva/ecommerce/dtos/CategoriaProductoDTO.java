package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.CategoriaProducto;

import java.util.Set;

public class CategoriaProductoDTO {
    private Long id;
    private Long idproducto;
    private String nombre;
    private Long stock;
    private Double precio;
    private boolean active;

    public Long getId() {
        return id;
    }

    public Long getIdproducto() {
        return idproducto;
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

    public boolean isActive() {
        return active;
    }

    public CategoriaProductoDTO() {}

    public CategoriaProductoDTO(CategoriaProducto categoriaProducto) {
        this.id = categoriaProducto.getId();
        this.idproducto = categoriaProducto.getProducto().getId();
        this.nombre = categoriaProducto.getProducto().getNombre();
        this.stock = categoriaProducto.getProducto().getStock();
        this.precio = categoriaProducto.getProducto().getPrecio();
        this.active = categoriaProducto.getProducto().isActive();
    }
}
