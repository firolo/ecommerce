package com.grupo2bbva.ecommerce.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String nombre;
    @OneToMany(mappedBy="categoria", fetch= FetchType.EAGER)
    Set<CategoriaProducto> categoriaProductos = new HashSet<>();

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

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
