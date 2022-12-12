package com.grupo2bbva.ecommerce.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class CarritoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    private double monto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private int cantidadProductos;

    public CarritoProducto() {
    }

    public CarritoProducto(Carrito carrito, Producto producto, int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
        this.monto = producto.getPrecio() * this.cantidadProductos;
        // hacer carritoProductoUtils?
        this.carrito = carrito;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidad) {
        this.cantidadProductos = cantidad;
    }
}
