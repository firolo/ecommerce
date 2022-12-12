package com.grupo2bbva.ecommerce.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="categoria_id")
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="producto_id")
    private Producto producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public CategoriaProducto() {
    }

    public CategoriaProducto(Categoria categoria, Producto producto) {
        this.categoria = categoria;
        this.producto = producto;
    }
}
