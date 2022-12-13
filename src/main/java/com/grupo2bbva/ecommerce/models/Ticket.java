package com.grupo2bbva.ecommerce.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private double monto;
    private double subtotal;

    private LocalDateTime fechaCompra;
    public Ticket() { }

    public Ticket(double monto, double subtotal, LocalDateTime fechaCompra) {
        this.monto = monto;
        this.subtotal = subtotal;
        this.fechaCompra = fechaCompra;
    }

    public static void save(Ticket ticket) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
