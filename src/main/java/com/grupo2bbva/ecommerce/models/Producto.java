package com.grupo2bbva.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String nombre;
    private Long stock;
    private Double precio;
    private boolean active;

    @OneToMany(mappedBy="producto", fetch= FetchType.EAGER)
    Set<CategoriaProducto> productoCategorias = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="owner_id")
    private TicketProducto ticketProducto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    @JsonIgnore
    public Set<CategoriaProducto> getProductoCategorias() {
        return productoCategorias;
    }

    @JsonIgnore
    public void setProductoCategorias(Set<CategoriaProducto> productoCategorias) {
        this.productoCategorias = productoCategorias;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Producto() {
    }

    public Producto(String nombre, Long stock, Double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.active = true;
    }

    public TicketProducto getTicketProducto() {
        return ticketProducto;
    }

    public void setTicketProducto(TicketProducto ticketProducto) {
        this.ticketProducto = ticketProducto;
    }
}
