package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.Producto;
import com.grupo2bbva.ecommerce.models.Ticket;

import java.util.List;

public class TicketDTO {

    private long id;
    private List<Producto> productos;
    private double monto;
    private double subtotal;


    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.productos = ticket.getProductos();
        this.monto = ticket.getMonto();
        this.subtotal = ticket.getSubtotal();
    }

    public long getId() {
        return id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getMonto() {
        return monto;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
