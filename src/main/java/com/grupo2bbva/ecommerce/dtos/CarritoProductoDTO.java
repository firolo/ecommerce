package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.CarritoProducto;

public class CarritoProductoDTO {
    private Long id;

    private Long carritoId;

    private String nombreProducto;

    private double monto;

    private int cantidadProductos;

    public CarritoProductoDTO() {
    }

    public CarritoProductoDTO(CarritoProducto carritoProducto) {
        this.carritoId = carritoProducto.getId();
        this.nombreProducto = carritoProducto.getProducto().getNombre();
        this.monto = carritoProducto.getMonto();
        this.cantidadProductos = carritoProducto.getCantidadProductos();
    }

    public Long getId() {
        return id;
    }

    public Long getCarritoId() {
        return carritoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getMonto() {
        return monto;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }
}
