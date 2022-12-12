package com.grupo2bbva.ecommerce.dtos;

import com.grupo2bbva.ecommerce.models.Cliente;


public class ClienteDTO {

    private long id;
    private String nombre;
    private String apellido;
    private String email;

    private String password;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.email = cliente.getEmail();
        this.password = cliente.getPassword();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
