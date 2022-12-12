package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.Carrito;

import java.util.Set;
import java.util.stream.Collectors;

public class CarritoDTO {
    private Long id;

    private double montoTotal;

    private Set<CarritoProductoDTO> carritoProductos;

    private ClienteDTO cliente;

    public CarritoDTO() {
    }

    public CarritoDTO(Carrito carrito) {
        this.id = carrito.getId();
        this.montoTotal = carrito.getMontoTotal();
        this.carritoProductos = carrito.getCarritoProductos().stream().map(carritoProducto -> new CarritoProductoDTO(carritoProducto)).collect(Collectors.toSet());
        this.cliente = new ClienteDTO(carrito.getCliente());
    }

    public Long getId() {
        return id;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public Set<CarritoProductoDTO> getCarritoProductos() {
        return carritoProductos;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }
}
