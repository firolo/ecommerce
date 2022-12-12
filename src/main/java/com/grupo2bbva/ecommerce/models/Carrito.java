package com.grupo2bbva.ecommerce.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long Id;

    private double montoTotal;

    @OneToMany(mappedBy = "carrito", fetch = FetchType.EAGER)
    private Set<CarritoProducto> carritoProductos;

    @OneToOne (mappedBy = "carrito", fetch = FetchType.EAGER)
    @JoinColumn (name = "client_id")
    private Cliente cliente;

    public Carrito() {
    }

    public Carrito(Cliente cliente) {
        this.montoTotal = 0;
        this.cliente = cliente;
        this.carritoProductos = new HashSet<>();
    }

    public Long getId() {
        return Id;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Set<CarritoProducto> getCarritoProductos() {
        return carritoProductos;
    }

    public void setCarritoProductos(Set<CarritoProducto> carritoProductos) {
        this.carritoProductos = carritoProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return carritoProductos.stream().map(carritoProducto -> carritoProducto.getProducto()).collect(Collectors.toList());
    }
}
