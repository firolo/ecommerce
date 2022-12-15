package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.TicketProducto;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class TicketProductoDTO {

    private long id;
    private double cantidad;
    private Set<ProductoDTO> productos;

    public TicketProductoDTO(TicketProducto ticketProducto) {
        this.id = ticketProducto.getId();
        this.cantidad = ticketProducto.getCantidad();
    }

    public long getId() {
        return id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Set<ProductoDTO> getProductos() {
        return productos;
    }

}
