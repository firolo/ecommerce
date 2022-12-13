package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.Ticket;

public class TicketDTO {

    private long id;
    private double monto;
    private double subtotal;

    public TicketDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.monto = ticket.getMonto();
        this.subtotal = ticket.getSubtotal();
    }

    public long getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
