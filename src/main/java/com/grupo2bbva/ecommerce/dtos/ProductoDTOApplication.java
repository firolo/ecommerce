package com.grupo2bbva.ecommerce.dtos;

public class ProductoDTOApplication {
    private Long id;
    private String nombre;
    private Long stock;
    private Double precio;
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

    public boolean isActive() {
        return active;
    }

    public ProductoDTOApplication() {
    }

    public ProductoDTOApplication(Long id, String nombre, Long stock, Double precio, boolean active) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.active = active;
    }
}
