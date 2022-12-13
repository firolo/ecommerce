package com.grupo2bbva.ecommerce.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TicketProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;

    private double cantidad;
    @OneToMany(mappedBy="ticketProducto", fetch= FetchType.EAGER)
    Set<Producto> productos = new HashSet<>();

    public TicketProducto() { }

    public TicketProducto(double cantidad) {
        this.cantidad = cantidad;
    }

    public static void save(TicketProducto ticketProducto) {
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void addProductos(Producto producto) {
        producto.setTicketProducto(this);
        productos.add(producto);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }


}
